<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <section id="container">
	<div id="container_box">
		
		<section id="content">
			<form role="form" method="post" autocomplete="off">
				<div class="input_area">
					<label for="userId">아이디</label>
					<input type="email" id="userId" name="userId" required />
				</div>
				
				<div class="input_area">
					<label for="userPass">패스워드</label>
					<input type="password" id="userPass" name="userPass" required />
				</div>
				
				<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
				
				<c:if test="${msg == false }">
					<p style="color:#f00;">로그인에 실패했습니다.</p>
				</c:if>
				
			</form>

		</section>
	
	</div>
</section> --%>

<!doctype HTML>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="stylesheet" href="/resources/css/style.css">
	<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="main-container">
		<div class="main-wrap">
		<header>
			<div class="sel-lang-wrap">
				<select class="lang-select">
					<option>한국어</option>
					<option>English</option>
				</select>
			</div>
			<div class="logo-wrap">
				<h1>Rak's Coffee</h1>
			</div>
		</header>
		<!-- <section class="login-input-section-wrap">
			<div class="login-input-wrap">	
				<input placeholder="Username" type="text"></input>
			</div>
			<div class="login-input-wrap password-wrap">	
				<input placeholder="Password" type="password"></input>
			</div>
			<div class="login-button-wrap">
				<button>Sign in</button>
			</div>
			<div class="login-stay-sign-in">
				<i class="far fa-check-circle"></i>
				<span>Stay Signed in</span>
			</div>
		</section> -->
		
		<section id="content" class="login-input-section-wrap">
			<form role="form" method="post" autocomplete="off">
				<div class="input_area" class="login-input-wrap">
					<!-- <label for="userId">아이디: </label> -->
					<input placeholder="Username" type="text" id="userId" name="userId" required />
				</div>
				<div class="input_area" class="login-input-wrap password-wrap">
					<!-- <label for="userPass">패스워드: </label> -->
					<input placeholder="Password" type="password" id="userPass" name="userPass" required />
				</div>
				<div class="login-button-wrap" >
					<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
				</div>
				<c:if test="${msg == false }">
					<p style="color:#f00;">로그인에 실패했습니다.</p>
				</c:if>
			</form>
		</section>
		
		<section class="Easy-sgin-in-wrap">
			<h2>Easier sign in</h2>
			<ul class="sign-button-list">
				<li><button><i class="fas fa-qrcode"></i><span>Sign in with QR code</span></button></li>
				<li><button><i class="fab fa-facebook-square"></i><span>Facebook</span></button></li>
				<li><button><i class="fab fa-line"></i><span>line</span></button></li>
			</ul>
			<p class="forget-msg">Forgot your Username or Password? | <a href="/member/signup"> Sign up </a></p>
		</section>
		<footer>
			<div class="copyright-wrap">
			<span>Copyright © Rak's Coffee Corp. All Rights Reserved.</span>
			</div>
		</footer>
		</div>
	</div>
</body>

