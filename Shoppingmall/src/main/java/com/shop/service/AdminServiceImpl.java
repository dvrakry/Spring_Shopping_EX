package com.shop.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shop.domain.CategoryVO;
import com.shop.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	private static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Inject
	private AdminDAO dao;
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

}