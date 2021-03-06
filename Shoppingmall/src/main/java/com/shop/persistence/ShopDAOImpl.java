package com.shop.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shop.domain.CartListVO;
import com.shop.domain.CartVO;
import com.shop.domain.GoodsViewVO;
import com.shop.domain.OrderDetailVO;
import com.shop.domain.OrderListVO;
import com.shop.domain.OrderVO;
import com.shop.domain.ReplyListVO;
import com.shop.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	private static Logger logger = LoggerFactory.getLogger(ShopDAOImpl.class);
	
	@Inject
	private SqlSession sql;
	
	//메퍼
	public static String namespace = "ShopMapper.";
	
	//카테고리별 상품 리스트: 1차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		
		return sql.selectList(namespace+"list1", map);
	}

	//카테고리별 상품 리스트: 2차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		
		return sql.selectList(namespace+"list2", cateCode);
	}
	
	//상품조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace+"goodsView", gdsNum);
	}
	
	//상품 댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert(namespace+"registReply", reply);
	}
	
	//상품 댓글 리스트
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return sql.selectList(namespace+"replyList", gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete(namespace+"deleteReply", reply);
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace+"replyUserIdCheck", repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update(namespace+"modifyReply", reply);
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		sql.insert(namespace+"addCart", cart);
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return sql.selectList(namespace+"cartList", userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		sql.delete(namespace+"deleteCart", cart);
	}
	
	//주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		sql.insert(namespace+"orderInfo", order);
	}
	
	//주문 상세정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		sql.insert(namespace+"orderInfo_Details", orderDetail);
	}
	
	//카트 비우기
	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete(namespace+"cartAllDelete", userId);
	}
	
	//주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception{
		return sql.selectList(namespace+"orderList", order);
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList(namespace+"orderView", order);
	}
	
	
	
}
