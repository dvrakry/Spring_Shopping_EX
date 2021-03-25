# Spring_Shopping_EX
스프링 프레임워크 쇼핑몰 연습
---------------------------
[메인화면]
---------------------------
![메인2](https://user-images.githubusercontent.com/74029610/112427119-6aab3b80-8d7c-11eb-936a-c113afe31773.PNG)

[카테고리]
----------------------------
![카테고리](https://user-images.githubusercontent.com/74029610/112427569-24a2a780-8d7d-11eb-8bbc-a9dfbb77e24e.PNG)

[카테고리 관련 table]
----------------------------
![goodsCate](https://user-images.githubusercontent.com/74029610/112428200-2325af00-8d7e-11eb-9f68-54ff603de589.PNG)
![tbl_goods](https://user-images.githubusercontent.com/74029610/112428245-39336f80-8d7e-11eb-81f7-26b2c01af9f7.PNG)

>Goods_category 테이블에서 1차 카테고리인 음료/푸드가 cateCode 컬럼에 100, 200 의 값을 가지고 
>그 하위 카테고리인 에스프레소, 브레드 등이 catecodeRef 로 1차 카테고리의 칼럼값을 가지면서 분류가 되고 있음 
>(예를들어 아메리카노의 경우 1차 분류인 음료(100)을 cateCodeRef 값으로 가지고 있음)
>그리고 tbl_goods 에서 아이스 아메리카노가 cateCode로 101 을 가지면서 음료 > 에스프레소 카테고리 분류가 완성됨

[회원가입 & 로그인]
------------------

[Spring Security]

-회원가입
```java
  String inputPass = vo.getUserPass();
  String pass = passEncoder.encode(inputPass);
  vo.setUserPass(pass);
```

-로그인
```java
  boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
```


![password](https://user-images.githubusercontent.com/74029610/112431554-063faa80-8d83-11eb-8c9c-ade6fba12a19.PNG)

Spring security 를 이용해서 비밀번호를 DB에 변경시켜 저장했습니다.


[상세페이지]
--------------

![상세페이지](https://user-images.githubusercontent.com/74029610/112432221-ebba0100-8d83-11eb-93b3-73044666592a.PNG)

[장바구니 담기]
-------------


```java
<p class="addToCart">
   <button type="button" class="addCart_btn">장바구니 담기</button>

   <script>
	$(".addCart_btn").click(function(){
		var gdsNum = $(".gdsNum").val();
		var cartStock = $(".numBox").val();

		console.log("gdsNum : " + gdsNum);
		console.log("cartStock : " + cartStock);
		
		//ReplyVO 형태로 데이터 생성
		var data = {
		 gdsNum : gdsNum,
		 cartStock : cartStock
		};

	$.ajax({
		url : "/shop/view/addCart",
		type : "post",
		data : data,
		success : function(result){
			if(result == 1){
			alert("장바구니에 담겼습니다");
			$(".numBox").val("1");
			} else {
				alert("회원만 사용할 수 있습니다.")
				$(".numBox").val("1");
			}
		},
		error : function(){
			alert("장바구니에 담기 실패");
		}
	   });

	});
</script>
</p>
```

장바구니 목록은 gdsNum 칼럼을 inner join해서 불러옴

```xml
	<select id="cartList" resultType="clvo">
	 select
	     row_number() over(order by c.cartNum desc) as num,
	     c.cartNum, c.userId, c.gdsNum, c.cartStock, c.addDate,
	     g.gdsName, g.gdsPrice, g.gdsThumbImg
	 from tbl_cart c
	     inner join tbl_goods g
		 on c.gdsNum = g.gdsNum   
	     where c.userId = #{userId}
	</select>	
```
[장바구니 목록]

![장바구니 목록](https://user-images.githubusercontent.com/74029610/112434728-3f7a1980-8d87-11eb-828e-134e2ff5ee44.PNG)


[댓글 작성]
------------

![댓글1](https://user-images.githubusercontent.com/74029610/112435403-05f5de00-8d88-11eb-8632-b6f77ea62dc5.PNG)

댓글 작성시 로그인이 필요함

![댓글2](https://user-images.githubusercontent.com/74029610/112435714-74d33700-8d88-11eb-8654-35cfb9e8f3f5.PNG)

댓글 기능은 AJAX (비동기 방식)을 사용함

함수 replyList() (아래 AJAX 에서 사용됨)

```java
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
  
[댓글 AJAX]
  
```java

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

```
















