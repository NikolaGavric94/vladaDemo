package com.demo.vlada.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String indexPage() {
		return "index";
	}
	
}
