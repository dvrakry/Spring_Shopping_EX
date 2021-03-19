package com.shop.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shop.domain.GoodsViewVO;
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

}
