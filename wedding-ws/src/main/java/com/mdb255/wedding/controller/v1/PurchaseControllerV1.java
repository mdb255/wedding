package com.mdb255.wedding.controller.v1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb255.wedding.domain.service.WeddingService;
import com.mdb255.wedding.domain.viewmodel.GenericResponseViewModel;
import com.mdb255.wedding.domain.viewmodel.PurchaseViewModel;

@Controller
@RequestMapping("/v1/purchases")
public class PurchaseControllerV1 {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WeddingService weddingService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<GenericResponseViewModel> createPurchases(@RequestBody List<PurchaseViewModel> viewModelList, HttpServletRequest request) {
		log.info("viewModels={}", viewModelList.toString());
		
		GenericResponseViewModel response = weddingService.createPurchases(viewModelList);
		return new ResponseEntity<GenericResponseViewModel>(response, HttpStatus.OK);
	}
}
