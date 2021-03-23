package com.shop.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.domain.GoodsViewVO;
import com.shop.domain.MemberVO;
import com.shop.domain.ReplyListVO;
import com.shop.domain.ReplyVO;
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
	
	//상품조회
	@GetMapping(value = "/view")
	public void getView(@RequestParam("n")int gdsNum, Model model) throws Exception{
		logger.info("get view");
		
		GoodsViewVO view = service.goodsView(gdsNum);
		model.addAttribute("view", view);
		
		/*
		 * List<ReplyListVO> reply = service.replyList(gdsNum);
		 * model.addAttribute("reply", reply);
		 */
	}
	
	/*
	 * //상품조회 - 댓글작성
	 * 
	 * @PostMapping(value = "/view") public String registReply(ReplyVO reply,
	 * HttpSession session) throws Exception{ logger.info("regist reply");
	 * 
	 * MemberVO member = (MemberVO)session.getAttribute("member");
	 * reply.setUserId(member.getUserId());
	 * 
	 * service.registReply(reply);
	 * 
	 * return "redirect:/shop/view?n=" + reply.getGdsNum(); }
	 */
	
	// 상품 소감(댓글) 작성
	@ResponseBody
	@PostMapping(value = "/view/registReply")
	public void registReply(ReplyVO reply,  HttpSession session) throws Exception {
	 logger.info("regist reply");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 reply.setUserId(member.getUserId());
	 
	 service.registReply(reply);
	 
	} 
	
	//상품 댓글 목록
	@ResponseBody
	@GetMapping(value = "/view/replyList")
	public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("get reply List");
		
		List<ReplyListVO> reply = service.replyList(gdsNum);
		
		return reply;
	}
	
}
