package com.shop.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.domain.CartListVO;
import com.shop.domain.CartVO;
import com.shop.domain.GoodsViewVO;
import com.shop.domain.MemberVO;
import com.shop.domain.OrderDetailVO;
import com.shop.domain.OrderListVO;
import com.shop.domain.OrderVO;
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
		
	}
	

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

	//상품 댓글 삭제
	@ResponseBody
	@PostMapping(value = "/view/deleteReply")
	public int getReplyList(ReplyVO reply, HttpSession session) throws Exception{
		logger.info("post delete reply");
		
		int result = 0;
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum()); //(String) userId 를 가져옴
		
		if(member.getUserId().equals(userId)) {
			reply.setUserId(member.getUserId()); 
			service.deleteReply(reply); 
			
			result = 1;
		}
		
		return result;
	}
	
	//상품 댓글 수정
	@ResponseBody
	@PostMapping(value = "/view/modifyReply")
	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception{
		logger.info("modify reply");
		
		int result = 0;
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());
		
		if(member.getUserId().equals(userId)) {
			
			reply.setUserId(member.getUserId());
			service.modifyReply(reply);
			result = 1;
		}
		return result;
	}
	
	//카트담기
	@ResponseBody
	@PostMapping(value = "/view/addCart")
	public int addCart(CartVO cart, HttpSession session) throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		int result = 0;
		
		if(member != null) {
		cart.setUserId(member.getUserId());
		service.addCart(cart);
		result = 1;
		}
		
		return result;
		
	}
	
	//카트리스트
	@GetMapping(value = "/cartList")
	public void getCartList(HttpSession session, Model model) throws Exception {
		logger.info("get cart List");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = member.getUserId();
	
		List<CartListVO> cartList = service.cartList(userId);
		
		model.addAttribute("cartList", cartList);
	}
	
	//카트삭제
	@ResponseBody
	@PostMapping(value = "/deleteCart")
	public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {
		logger.info("delete cart");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = member.getUserId();
		
		int result = 0;
		int cartNum = 0;
		
		if(member != null) {
			cart.setUserId(userId);
			
			for(String i : chArr) {
				cartNum = Integer.parseInt(i);
				
				logger.info("cartNum:~~~~~~~~~~~~~~~~~" + cartNum);
				
				cart.setCartNum(cartNum);
				service.deleteCart(cart);
			}
			result = 1;
		} 
		return result;
	}
	
	//주문관련POST
	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
	public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) throws Exception {
	 logger.info("order");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");  
	 String userId = member.getUserId();
	 
	 Calendar cal = Calendar.getInstance();
	 int year = cal.get(Calendar.YEAR);
	 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
	 String subNum = "";
	 
	 for(int i = 1; i <= 6; i ++) {
	  subNum += (int)(Math.random() * 10);
	 }
	 
	 String orderId = ymd + "_" + subNum;
	 
	 order.setOrderId(orderId);
	 order.setUserId(userId);
	  
	 service.orderInfo(order);
	 
	 orderDetail.setOrderId(orderId);   
	 service.orderInfo_Details(orderDetail);
	 
	 service.cartAllDelete(userId);
	 
	 return "redirect:/shop/orderList";  
	}
	
	//주문 목록
	@GetMapping(value = "/orderList")
	public void getOrderList(HttpSession session, OrderVO order, Model model) throws Exception{
		logger.info("get order list");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = member.getUserId();
		
		order.setUserId(userId);
		
		List<OrderVO> orderList	= service.orderList(order);
		
		model.addAttribute("orderList", orderList);
		
	}
	
	//주문 목록 확인
	@GetMapping(value = "/orderView")
	public void getOrderList(HttpSession session,
							@RequestParam("n")String orderId,
							OrderVO order, Model model) throws Exception{
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userId = member.getUserId();
		
		order.setUserId(userId);
		order.setOrderId(orderId);
		
		List<OrderListVO> orderView = service.orderView(order);
		model.addAttribute("orderView",orderView);
	}
}
