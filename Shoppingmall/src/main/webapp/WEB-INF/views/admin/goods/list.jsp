<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rak admin list</title>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="/resources/bootstrap/bootstrap-theme.min.css">
<link rel="stylesheet" href="/resources/css/index.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<style>
#container_box table td { width:100px; }
</style>

<style>
#container_box table { width:900px; } 
#container_box table th { font-size:20px; font-weight:bold;
							text-align:center; padding:10px; border-bottom:2px solid #666; }
#container_box table tr:hover { background:#eee; }
#container_box table td { padding:10px; text-align:center; }
#container_box table img { width:150px; height:auto; }
</style>

</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>
			
			<div id="container_box">
			<!--  <h2>상품 목록</h2> -->
			<table>
				<thead>
					<tr>
						<th>썸네일</th>
						<th>이름</th>
						<th>카테고리</th>
						<th>가격</th>
						<th>수량</th>
						<th>등록날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
					<tr>
						<td>
							<img src="${list.gdsThumbImg }">
						</td>
						<td>
							<a href="/admin/goods/view?n=${list.gdsNum}">${list.gdsName}</a>
						</td>
						<td>
							<%-- ${list.cateCode} --%>
							${list.cateName }
						</td>
						<td>
							<fmt:formatNumber value="${list.gdsPrice}"  pattern="###,###,###"/>
						</td>
						<td>${list.gdsStock}</td>
						<td>
							<fmt:formatDate value="${list.gdsDate}" pattern="yyyy-MM-dd" />
						</td>
					</tr>			
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>
	
	</div>

</body>


</html>



