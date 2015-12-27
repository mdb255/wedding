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
import com.mdb255.wedding.domain.viewmodel.RsvpViewModel;

@Controller
@RequestMapping("/v1/rsvps")
public class RsvpControllerV1 {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WeddingService weddingService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<GenericResponseViewModel> createRsvp(@RequestBody List<RsvpViewModel> viewModelList, HttpServletRequest request) {
		log.info("viewModels={}", viewModelList.toString());
		
		GenericResponseViewModel response = weddingService.createRsvps(viewModelList);
		return new ResponseEntity<GenericResponseViewModel>(response, HttpStatus.OK);
	}
	
	// TODO This is an admin method - add authorization
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<RsvpViewModel>> getRsvpIndex(HttpServletRequest request) {
		return new ResponseEntity<List<RsvpViewModel>>(weddingService.getRsvpsIndex(), HttpStatus.OK);
	}
}
