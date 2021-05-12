<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    *{ margin:0; padding: 0;}
    body{background-color: #F5F6F7;}
    div{margin-top: 60px;margin-left: 38%;}
    ul,li{ list-style: none;}
   li{margin-bottom: 20px; text-align: left;}
    .box{width: 450px; height: 50px; border: 1px solid #666; padding: 10px;}
    .pbox{width: 120px; height: 50px; border: 1px solid #666; padding: 10px;}
    .necessary{font-size: small; color:red;}
    button{background:#00C850; color:white; width: 450px; border: 1px solid #666; height:50px; font-size: x-large; }
</style>

<section id="container">
	<div id="container_box">
		
		<section id="content">
			<form role="form" method="post" autocomplete="off">
				<ul>
					<li>
					<input type="email" class="box" id="userId" name="userId" placeholder="example@example.com">
					</li>
					<li>
					<input type="password" class="box" id="userPass" name="userPass" placeholder="비밀번호를 입력하세요" required>
					</li>
					<li>
					<input type="text" id="userName" class="box" name="userName" placeholder="닉네임을 입력하세요">
					</li>
					<li>
					<input type="text" class="box" id="userPhon" name="userPhon" placeholder="연락처를 입력하세요">
					</li>
				<li>	
				<button type="submit" id="signup_btn" name="signup_btn">회원가입</button>
				</li>
				</ul>
				
			</form>

		</section>
	
	</div>
</section>


