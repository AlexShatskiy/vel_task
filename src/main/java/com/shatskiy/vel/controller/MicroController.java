package com.shatskiy.vel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MicroController {
	
	@RequestMapping("/info")
	public String info(@RequestParam(value = "hardCodeNumber") int number) {

		
		return "index";	
	}
}
