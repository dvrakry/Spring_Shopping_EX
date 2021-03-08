package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shop.domain.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req,
					HttpServletResponse res, Object obj) throws Exception{
		
		//현재의 세션을 불러와 session 에 저장
		HttpSession session = req.getSession(); 
		
		//그 중 member 라는 명칭의 세션을 불러와 MemberVO 의 형태로 변환한 뒤, MemberVO 형태의 변수인 member 에 저장
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if(member == null) {
			res.sendRedirect("/member/signin");
			return false;
		}
		
		if(member.getVerify() !=9 ) {
			res.sendRedirect("/");
			return false;
		}
		
			return true;
		
	}

}
