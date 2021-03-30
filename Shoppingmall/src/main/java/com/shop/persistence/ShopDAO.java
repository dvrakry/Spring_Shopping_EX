package com.shop.persistence;

import java.util.List;

import com.shop.domain.CartListVO;
import com.shop.domain.CartVO;
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
	
	//상품 댓글 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//아이디 체크
	public String idCheck(int repNum) throws Exception;
	
	//상품 댓글 수정
	public void modifyReply(ReplyVO reply) throws Exception;
	
	//장바구니 담기
	public void addCart(CartVO cart) throws Exception;
	
	//장바구니 리스트
	public List<CartListVO> cartList(String userId) throws Exception;
	
	//장바구니 삭제
	public void deleteCart(CartVO cart) throws Exception;
	
	
	
}
