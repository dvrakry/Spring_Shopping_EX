package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//관리자 화면.
	@GetMapping(value = "/index")
	public void getIndex() throws Exception{
		logger.info("get index");
	}
	
}
