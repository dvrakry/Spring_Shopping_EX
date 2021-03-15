package com.shop.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.domain.CategoryVO;
import com.shop.service.AdminService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
<<<<<<< HEAD
	@Inject
	AdminService adminService;
	
	//관리자 화면
=======
	//관리자 화면.
>>>>>>> refs/remotes/origin/main
	@GetMapping(value = "/index")
	public void getIndex() throws Exception{
		logger.info("get index");
	}
	
	//상품등록
	@GetMapping(value = "/goods/register")
	public void getGoodsRegister(Model model) throws Exception{
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
}
