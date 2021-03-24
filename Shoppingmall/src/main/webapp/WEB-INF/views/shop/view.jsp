<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<script> 
				function replyList(){
					
					console.log("replyList 함수 시작");
					
					
					 var gdsNum = ${view.gdsNum};
					 $.getJSON("/shop/view/replyList" + "?n=" + gdsNum, function(data){
					  var str = "";
					  
					  $(data).each(function(){
					   
					   console.log(data);
					   
					   var repDate = new Date(this.repDate);
					   repDate = repDate.toLocaleDateString("ko-US")
					   
					   str += "<li data-repNum='" + this.repNum + "'>"
					     + "<div class='userInfo'>"
					     + "<span class='userName'>" + this.userName + "</span>"
					     + "<span class='date'>" + repDate + "</span>"
					     + "</div>"
					     + "<div class='replyContent' name='modRepCon'>" + this.repCon + "</div>"
					     
					     + "<c:if test='${member != null}'>"
					     
					     + "<div class='replyFooter'>"
					     + "<button type='button' class='modify' data-repNum='"+ this.repNum +"'>수정</button>"
					     + "<button type='button' class='delete' data-repNum='"+ this.repNum +"'>삭제</button>"
					     
					     + "</c:if>"
					     
					     + "</li>";           
					  });
					  
					  $("section.replyList ol").html(str);
					 });
					 
				}
				</script>
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

 div.goods div.goodsImg { float:left; width:350px; }
 div.goods div.goodsImg img { width:350px; height:auto; }
 
 div.goods div.goodsInfo { float:right; width:330px; font-size:22px; }
 div.goods div.goodsInfo p { margin:0 0 20px 0; }
 div.goods div.goodsInfo p span { display:inline-block; width:100px; margin-right:15px; }
 
 div.goods div.goodsInfo p.cartStock input { font-size:22px; width:50px; padding:5px; margin:0; border:1px solid #eee; }
 div.goods div.goodsInfo p.cartStock button { font-size:26px; border:none; background:none; }
 div.goods div.goodsInfo p.addToCart { text-align:right; }
 div.goods div.gdsDes { font-size:18px; clear:both; padding-top:30px; }
 div.goods div.goodsInfo p.cartStock button { font-size:26px; border:none; background:none; }
  section.replyForm { padding:30px 0; }
 section.replyForm div.input_area { margin:10px 0; }
 section.replyForm textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px;; height:150px; }
 section.replyForm button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 
 section.replyList { padding:30px 0; }
 section.replyList ol { padding:0; margin:0; }
 section.replyList ol li { padding:10px 0; border-bottom:2px solid #eee; }
 section.replyList div.userInfo { }
 section.replyList div.userInfo .userName { font-size:24px; font-weight:bold; }
 section.replyList div.userInfo .date { color:#999; display:inline-block; margin-left:10px; }
 section.replyList div.replyContent { padding:10px; margin:20px 0; }
 section.replyList div.replyFooter button { font-size:14px; border: 1px solid #999; background:none; margin-right:10px; }
</style>
<style>
 div.replyModal { position:relative; z-index:1; }
 div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
 div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:500px; height:250px; padding:20px 10px; background:#fff; border:2px solid #666; }
 div.modalContent textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:200px; }
 div.modalContent button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 div.modalContent button.modal_cancel { margin-left:20px; }
 div.replyModal {display: none;}
</style>
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
				<form role="form" method="post">
				 <input type="hidden" name="gdsNum" value="${view.gdsNum}" />
				</form>
				
				<div class="goods">
				 <div class="goodsImg">
				  <img src="${view.gdsImg}">
				 </div>
				 
				 <div class="goodsInfo">
				  <p class="gdsName"><span>상품명</span>${view.gdsName}</p>
				  
				  <p class="cateName"><span>카테고리</span>${view.cateName}</p>
				  
				  <p class="gdsPrice">
				   <span>가격 </span><fmt:formatNumber pattern="###,###,###" value="${view.gdsPrice}" /> 원
				  </p>
				  
				  <p class="gdsStock">
				   <span>재고 </span><fmt:formatNumber pattern="###,###,###" value="${view.gdsStock}" /> EA
				  </p>
				  
				  <p class="cartStock">
				   <span>구입 수량</span>
				  
				   <button type="button" class="minus">-</button>
				   <input type="number" min="1" max="${view.gdsStock}" value="1" class="numBox" readonly/>  
				    <button type="button" class="plus">+</button>
				   
				   <script>
					  $(".plus").click(function(){
						  console.log("plus");
					   var num = $(".numBox").val();
					   var plusNum = Number(num) + 1;
					   
					   if(plusNum >= ${view.gdsStock}) {
					    $(".numBox").val(num);
					   } else {
					    $(".numBox").val(plusNum);          
					   }
					  });
					  
					  $(".minus").click(function(){
						  console.log("minus");
					   var num = $(".numBox").val();
					   var minusNum = Number(num) - 1;
					   
					   if(minusNum <= 0) {
					    $(".numBox").val(num);
					   } else {
					    $(".numBox").val(minusNum);          
					   }
					  });
					 </script>
					 
					</p>
				  
				  <p class="addToCart">
				   <button type="button">카트에 담기</button>
				  </p>
				 </div>
				 
				 <div class="gdsDes">${view.gdsDes}</div>
				</div>
				
				<div id="reply">
				
				 <c:if test="${member == null }">
				 	<p> 댓글을 남기시려면 <a href="/member/signin">로그인</a>해주세요</p>
				 </c:if>
				 <c:if test="${member != null }">	
					<section class="replyForm">
						<form role="form" method="post" autocomplete="off">
							
							<input type="hidden" class="gdsNum" value="${view.gdsNum }">
						
							<div class="input_area">
								<textarea name="repCon" id="repCon"></textarea>
							</div>
							
							<div class="input_area">
								<button type="button" id="reply_btn">댓글 남기기</button>
								
							<script>
								 $("#reply_btn").click(function(){
								  
								  console.log("ajax 댓글남기기");	 
									 
								  var formObj = $(".replyForm form[role='form']");
								  var gdsNum = $(".gdsNum").val();
								  
								  console.log(gdsNum);
								  
								  var repCon = $("#repCon").val();
								  
								  var data = {
								    gdsNum : gdsNum,
								    repCon : repCon
								    };
								  
								  $.ajax({
								   url : "/shop/view/registReply",
								   type : "post",
								   data : data,
								   success : function(){
									   replyList();  // 리스트 새로고침
									   $("#repCon").val("");  // 텍스트에어리어를 초기화
								   }
								  
								  });
								  
								 });
								 
							</script>
							</div>						
						</form>
					</section>
				</c:if>
					<section class="replyList">
					 <ol>
					 <%-- <c:forEach items="${reply}" var="reply">
					
					  <li>
					      <div class="userInfo">
					       <span class="userName">${reply.userName}</span>
					       <span class="date"><fmt:formatDate value="${reply.repDate}" pattern="yyyy-MM-dd" /></span>
					      </div>
					      <div class="replyContent">${reply.repCon}</div>
					    </li>
					   </c:forEach> --%>
					  </ol>    
					  
					  <script>
					  	replyList();
					  </script>
					  
					  <script>
					   $(document).on("click", ".modify", function(){
						   /* $(".replyModal").attr("style" , "display:block"); */
						   $(".replyModal").fadeIn(200);
						   
						   var repNum = $(this).attr("data-repNum");
						   var repCon = $(this).parent().parent().children(".replyContent").text();
						   
						   $(".modal_repCon").val(repCon);
						   $(".modal_modify_btn").attr("data-repNum", repNum);
					   });
					  </script>
					  
					 
					  
					  
					
					  <script type="text/javascript">
					  $(document).on("click", ".delete", function(){
						  
						 var deleteConfirm = confirm("정말로 삭제하시겠습니까?");
						 
						 if(deleteConfirm){
						  
						 var data = {repNum : $(this).attr("data-repNum")};
						 
						 $.ajax({
							url : "/shop/view/deleteReply",
							type : "post",
							data : data,
							success : function(result){
								
								if(result == 1){
									replyList();
								} else {
									alert("작성자 본인만 삭제할 수 있습니다")
								}
							},
							error : function(){
								alert("로그인이 필요한 서비스 입니다")
							}
						 });
					    }
					  });
					  
					  </script>
					 
					</section>
	
				<footer id="footer">
					<div id="footer_box">
						<%@ include file="../include/footer.jsp" %>
					</div>		
				</footer>

</div>
<div class="replyModal">

	<div class="modalContent">
		<div>
			<textarea class="modal_repCon" name="modal_repCon"></textarea>
		</div>
		
		<div>
			<button type="button" class="modal_modify_btn">수정</button>
			<button type="button" class="modal_cancel">취소</button>
			
		</div>
		
		<div class="modalBackground"></div>
	</div>

<script>
$(".modal_cancel").click(function(){
	/* $(".replyModal").attr("style", "display: none;"); */
	$(".replyModal").fadeOut(200);
});
</script>

 <script>
					  $(".modal_modify_btn").click(function(){
						 var modifyConfirm = confirm("수정하시겠습니까?");
						 
						  if(modifyConfirm){
							  var data = {
									  repNum : $(this).attr("data-repNum"),
									  repCon : $(".modal_repCon").val()
							  	};
							  
							  $.ajax({
								  url : "/shop/view/modifyReply",
								  type : "post",
								  data : data,
								  success : function(result){
									  if(resut == 1){
										  replyList();
										  $(".replyModal").fadeout(200);
									  } else {
										  alert("작성자 본인만 할 수 있습니다.")
									  }
								  },
								  error : function(){
									  alert("로그인이 필요합니다")
								  }
							  });
						  }
					  });
					  </script>

</div>

</body>
</html>