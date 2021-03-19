<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>

<style>
 body { margin:0; padding:0; font-family:'맑은 고딕', verdana; }
 a { color:#05f; text-decoration:none; }
 a:hover { text-decoration:underline; }
 
 h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }
 ul, lo, li { margin:0; padding:0; list-style:none; }

 /* ---------- */
 
 div#root { width:900px; margin:0 auto; }
 header#header { }
 nav#nav { }
 section#container { }
  section#content { float:right; width:700px; }
  aside#aside { float:left; width:180px; }
  section#container::after { content:""; display:block; clear:both; } 
 footer#footer { background:#eee; padding:20px; }
 
 /* ---------- */
 
 header#header div#header_box { text-align:center; padding:30px 0; }
 header#header div#header_box h1 { font-size:50px; }
 header#header div#header_box h1 a { color:#000; }
 
 nav#nav div#nav_box { font-size:14px; padding:10px; text-align:right; }
 nav#nav div#nav_box li { display:inline-block; margin:0 10px; }
 nav#nav div#nav_box li a { color:#333; }
 
 section#container { }
 
 aside#aside h3 { font-size:22px; margin-bottom:20px; text-align:center; }
 aside#aside li { font-size:16px; text-align:center; }
 aside#aside li a { color:#000; display:block; padding:10px 0; }
 aside#aside li a:hover { text-decoration:none; background:#eee; }
 
 footer#footer { margin-top:100px; border-radius:50px 50px 0 0; }
 footer#footer div#footer_box { padding:0 20px; }
 
 aside#aside li { position:relative; }
aside#aside li:hover { background:#eee; }   
aside#aside li > ul.low { display:none; position:absolute; top:0; left:180px;  }
aside#aside li:hover > ul.low { display:block; }
aside#aside li:hover > ul.low li a { background:#eee; border:1px solid #eee; }
aside#aside li:hover > ul.low li a:hover { background:#fff;}
aside#aside li > ul.low li { width:180px; }
 
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>카테고리</h3>

 <ul>
  <li><a href="/shop/list?c=100&l=1">음료</a>
  	
	  	<ul class="low">
		  	<li><a href="/shop/list?c=101&l=2">에스프레소</a></li>
		  	<li><a href="/shop/list?c=102&l=2">프라프치노</a></li>
		  	<li><a href="/shop/list?c=103&l=2">피지오</a></li>
		  	<li><a href="/shop/list?c=104&l=2">티</a></li>
	  	</ul>
	</li>
  	
  <li><a href="/shop/list?c=200&l=1">푸드</a>
  	
	  	<ul class="low">
		  	<li><a href="/shop/list?c=201&l=2">브레드</a></li>
		  	<li><a href="/shop/list?c=202&l=2">케이크</a></li>
		  	<li><a href="/shop/list?c=203&l=2">샌드위치</a></li>
	  	</ul>
	</li>
	
 </ul>
</body>
</html>
