package com.shop.persistence;

import java.util.List;

import com.shop.domain.GoodsViewVO;
import com.shop.domain.ReplyListVO;
import com.shop.domain.ReplyVO;

public interface ShopDAO {
	
	//카테고리별 상품 리스트: 1차분류
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	//카테고리별 상품 리스트 : 2차분류
	public List<GoodsViewVO> list(int cateCode) throws Exception;
	
	//상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//상품 댓글 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	//상품 댓글 리스트
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
}
