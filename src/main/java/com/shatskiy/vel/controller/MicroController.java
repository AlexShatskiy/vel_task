package com.shatskiy.vel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shatskiy.vel.service.MicroService;

@Controller
public class MicroController {
	
	@Autowired
	private MicroService microService;
	
	@RequestMapping("/info")
	public String info(@RequestParam(value = "number") int number) {
		
		microService.addInfo(number);
		
		return "index";	
	}
}
