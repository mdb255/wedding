package com.mdb255.wedding.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdb255.wedding.test.domain.service.WeddingTestService;

@Controller
@RequestMapping("/rsvps")
public class RsvpController {
	
	@Autowired
	private WeddingTestService weddingTestService;
}
