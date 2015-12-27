package com.mdb255.wedding.controller.v1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb255.wedding.domain.service.WeddingService;
import com.mdb255.wedding.domain.viewmodel.RegistryItemViewModel;

@Controller
@RequestMapping("/v1/registryItems")
public class RegistryItemControllerV1 {
	
	@Autowired
	private WeddingService weddingService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<RegistryItemViewModel>> getRegistryItems(HttpServletRequest request) {
		String category = request.getParameter("category");
		List<RegistryItemViewModel> items = weddingService.getRegistryItems(category);
		
		return new ResponseEntity<List<RegistryItemViewModel>>(items, HttpStatus.OK);
	}
}
