package com.shop.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shop.domain.CartVO;
import com.shop.domain.GoodsViewVO;
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
	
	
	
}
