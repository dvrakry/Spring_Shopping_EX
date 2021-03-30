<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
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
 
</style>

<style>
 /*
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
 */
 section#content ul li { margin:10px 0; }
 section#content ul li img { width:250px; height:250px; }
 section#content ul li::after { content:""; display:block; clear:both; }
 section#content div.thumb { float:left; width:250px; }
 section#content div.gdsInfo { float:right; width:calc(100% - 300px); }
 section#content div.gdsInfo { font-size:20px; line-height:2; }
 section#content div.gdsInfo span { display:inline-block; width:100px; font-weight:bold; margin-right:10px; }
 section#content div.gdsInfo .delete { text-align:right; }
 section#content div.gdsInfo .delete button { font-size:22px;
            padding:5px 10px; border:1px solid #eee; background:#eee;}
.allCheck { float:left; width:200px; }
.allCheck input { width:16px; height:16px; }
.allCheck label { margin-left:10px; }
.delBtn { float:right; width:300px; text-align:right; }
.delBtn button { font-size:18px; padding:5px 10px; border:1px solid #eee; background:#eee;}

.checkBox { float:left; width:30px; }
.checkBox input { width:16px; height:16px; }
.listResult { padding:20px; background:#eee; }
.listResult .sum { float:left; width:45%; font-size:22px; }

.listResult .orderOpne { float:right; width:45%; text-align:right; }
.listResult .orderOpne button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}
.listResult::after { content:""; display:block; clear:both; }
</style>
	<title>장바구니</title>
</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="../include/header.jsp" %>
		</div>
	</header>
	
	<nav id="nav">
		<div id="nav_box">
			<%@ include file="../include/nav.jsp" %>
		</div>
	</nav>
	
	<section id="container">
		<div id="container_box">
		
			<section id="content">
 
				 <ul>
				 	<li>
				 		<div class="allCheck">
				 			<input type="checkbox" name="allCheck" id="allCheck"/><label for="allCheck">모두선택</label>
				 			
				 			<script>
				 				$("#allCheck").click(function(){
				 					var chk = $("#allCheck").prop("checked");
				 					if(chk){
				 						$(".chBox").prop("checked", this.checked);
				 					} else {
				 						$(".chBox").prop("checked", this.checked);
				 					}
				 				});
				 			</script>
				 		</div>
				 		<div class="delBtn">
							<button type="button" class="selectDelete_btn">선택 삭제</button>
 						
 							<script>
								$(".selectDelete_btn").click(function(){
									var confirm_val = confirm("정말 삭제하시겠습니까?");
									
									if(confirm_val) {
										var checkArr = new Array();
										
										// 체크된 체크박스의 갯수만큼 반복
										$("input[class='chBox']:checked").each(function(){
											checkArr.push($(this).attr("data-cartNum"));  // 배열에 데이터 삽입
										});
											
										$.ajax({
											url : "/shop/deleteCart",
											type : "post",
											data : { chbox : checkArr },
											success : function(result){
												
												if(result == 1) {												
													location.href = "/shop/cartList";
												} else {
													alert("삭제 실패");
												}
											}
										});
									}	
								});
							</script>
						</div>
				 	</li>
				 	<hr>
				 	
				 	<c:set var="sum" value="0"/>
				 		
			  		<c:forEach items="${cartList}" var="cartList">
				  	<li>
				  		<div class="checkBox">
							<input type="checkbox" name="chBox" class="chBox" data-cartNum="${carList.cartNum }" />
							
							<script type="text/javascript">
								$(".chBox").click(function(){
									$("#allCheck").prop("checked", false);
								});
							</script>
				  		</div>
				  	
					   	<div class="thumb">
					    	<img src="${cartList.gdsThumbImg}" />
					   </div>
					   
					   	<div class="gdsInfo">
						    <p>
							     <span>상품명 : </span>${cartList.gdsName}<br />
							     <span>개당 가격 : </span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice}" /><br />
							     <span>구입 수량 : </span>${cartList.cartStock}<br />
							     <span>최종 가격 : </span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice * cartList.cartStock}" />
						    </p>
						    
						    <div class="delete">
						    	<button class="delete_${cartList.cartNum}_btn" data-cartNum="${cartList.cartNum }">삭제</button>
						    </div>
						    
						    <script type="text/javascript">
						    	$(".delete_${cartList.cartNum}_btn").click(function(){
						    		var confirm_val = confirm("정말 삭제하시겠습니까?");
						    		
						    		if(confirm_val) {
						    			var checkArr = new Array();
						    			
						    			checkArr.push($(this).attr("data-cartNum"));
						    			
						    			$.ajax({
						    				url : "/shop/deleteCart",
						    				type : "post",
						    				data : { chbox : checkArr },
						    				success : function(result) {
						    					
						    					if(result == 1) {
						    						location.href = "/shop/cartList";
						    					} else {
						    						alert("삭제 실패");
						    					}
						    				}
						    			});
						    		}
						    	});
						    </script>
					   	</div>
				  	</li>
			        <hr>
			        
			        <c:set var="sum" value="${sum + (cartList.gdsPrice * cartList.cartStock)}" />
			  		</c:forEach>				
				 </ul>
				 
			<div class="listResult">
				 <div class="sum">
				  총 합계 : <fmt:formatNumber pattern="###,###,###" value="${sum}" />원
				 </div>
				 
				 <div class="orderOpen">
				  <button type="button" class="orderOpne_bnt">주문 정보 입력</button>
				 </div>
			</div>
				 
			</section>
			
			<aside id="aside">
				<%@ include file="../include/aside.jsp" %>
			</aside>
			
		</div>
	</section>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp" %>
		</div>		
	</footer>

</div>


</body>
</html>
