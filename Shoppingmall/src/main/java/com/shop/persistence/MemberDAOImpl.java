package com.shop.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shop.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	private static Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "MemberMapper.";
	
	//회원가입
	@Override
	public void signup(MemberVO vo) throws Exception {
		sql.insert(namespace+"signup", vo);
	}
	
	//로그인
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespace+"signin", vo);
	}

}
