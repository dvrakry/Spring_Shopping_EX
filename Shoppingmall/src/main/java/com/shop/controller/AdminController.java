package com.shop.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.domain.CategoryVO;
import com.shop.domain.GoodsVO;
import com.shop.domain.GoodsViewVO;
import com.shop.service.AdminService;
import com.shop.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;

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
	
	//상품등록
	@PostMapping(value = "/goods/register")
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception{
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}
	
	//상품 목록
	@GetMapping(value = "/goods/list")
	public void getGoodsList(Model model) throws Exception{
		logger.info("get goods list");
		
		List<GoodsVO> list = adminService.goodslist();
		
		model.addAttribute("list", list);
	}
	
	//상품 조회
	@GetMapping(value = "/goods/view")
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get goods view");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		
		model.addAttribute("goods", goods);
	}
	
	//상품 수정
	@GetMapping(value = "/goods/modify")
	public void getGoodsModify(@RequestParam("n") int gdsNum , Model model) throws Exception{
		logger.info("get goods modify");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	//상품수정
	@PostMapping(value = "/goods/modify")
	public String postGoodsModify(GoodsVO vo) throws Exception {
		logger.info("post goods modify");
		
		adminService.goodsModify(vo);
		
		return "redirect:/admin/index";
	}
	
	//상품삭제
	@PostMapping(value = "/goods/delete")
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception{
		logger.info("post goods delete");
		
		adminService.goodsDelete(gdsNum);
		
		return "redirect:/admin/index";
	}
	
	
}
