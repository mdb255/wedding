package com.mdb255.wedding.test.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb255.wedding.domain.datamodel.RegistryItem;
import com.mdb255.wedding.domain.viewmodel.GenericResponseViewModel;
import com.mdb255.wedding.test.domain.service.WeddingTestService;

@Controller
@RequestMapping("/registryItems")
public class RegistryItemController {
	
	@Autowired
	private WeddingTestService weddingTestService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Long> createRegistryItem(@RequestBody RegistryItem model, HttpServletRequest request) {
		Long regItemId = weddingTestService.createRegistryItem(model);

		return new ResponseEntity<Long>(regItemId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponseViewModel> deleteRegistryItemsByDescription(@RequestBody Map<String, String> body, HttpServletRequest request) {
		String description = body.get("description");
		weddingTestService.deleteRegistryItemsByDescription(description);
		
		GenericResponseViewModel response = new GenericResponseViewModel(true, null);
		return new ResponseEntity<GenericResponseViewModel>(response, HttpStatus.OK);
	}
}
