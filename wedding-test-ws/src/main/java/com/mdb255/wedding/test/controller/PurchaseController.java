package com.mdb255.wedding.test.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb255.wedding.domain.datamodel.Purchase;
import com.mdb255.wedding.domain.viewmodel.GenericResponseViewModel;
import com.mdb255.wedding.test.domain.service.WeddingTestService;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {
	
	@Autowired
	private WeddingTestService weddingTestService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Purchase>> getPurchasesIndex(HttpServletRequest request) {
		String purchasedByEmail = request.getParameter("purchasedByEmail");
		List<Purchase> purchases = weddingTestService.getPurchasesIndex(purchasedByEmail);
		
		return new ResponseEntity<List<Purchase>>(purchases, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponseViewModel> deletePurchasesByEmail(@RequestBody Map<String, String> body, HttpServletRequest request) {
		String purchasedByEmail = body.get("purchasedByEmail");
		weddingTestService.deletePurchasesByEmail(purchasedByEmail);
		
		GenericResponseViewModel response = new GenericResponseViewModel(true, null);
		return new ResponseEntity<GenericResponseViewModel>(response, HttpStatus.OK);
	}
}
