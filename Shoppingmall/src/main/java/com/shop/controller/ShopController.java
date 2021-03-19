package com.shop.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.domain.GoodsViewVO;
import com.shop.service.ShopService;

@Controller
@RequestMapping("/shop/**")
public class ShopController {
	private static Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	private ShopService service;
	
	//카테고리별 상품 리스트
	@GetMapping(value = "/list")
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception{
		logger.info("get List");
		
		List<GoodsViewVO> list = null;
		list = service.list(cateCode, level);
		
		model.addAttribute("list", list);
	}
	
}
