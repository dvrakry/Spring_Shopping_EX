package com.shop.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shop.domain.CategoryVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	private static Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "AdminMapper.";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace+"category");
	}

}
