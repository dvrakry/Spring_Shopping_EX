package com.shop.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shop.domain.CartListVO;
import com.shop.domain.CartVO;
import com.shop.domain.GoodsViewVO;
import com.shop.domain.OrderDetailVO;
import com.shop.domain.OrderListVO;
import com.shop.domain.OrderVO;
import com.shop.domain.ReplyListVO;
import com.shop.domain.ReplyVO;
import com.shop.persistence.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {
	private static Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);
	
	@Inject
	private ShopDAO dao;
	
	//카테고리별 상품 리스트
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		
		int cateCodeRef = 0;
		
		if(level == 1) { //1차분류
			
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
			
		} else { // 2차분류
			return dao.list(cateCode);
		}
		
	}
	
	//상품조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}
	
	//상품 댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		dao.registReply(reply);
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return dao.replyList(gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		dao.deleteReply(reply);
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		return dao.idCheck(repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		dao.modifyReply(reply);
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		dao.addCart(cart);
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return dao.cartList(userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		dao.deleteCart(cart);
	}
	
	//주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		dao.orderInfo(order);
	}

	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		dao.orderInfo_Details(orderDetail);
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		dao.cartAllDelete(userId);
	}

	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return dao.orderList(order);
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return dao.orderView(order);
	}
	

}
