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

Goods_category 테이블에서 1차 카테고리인 음료/푸드가 cateCode 컬럼에 100, 200 의 값을 가지고 그 하위 카테고리인 에스프레소, 브레드 등이 catecodeRef 로 
1차 카테고리의 칼럼값을 가지면서 분류가 되고 있음 (예를들어 아메리카노의 경우 1차 분류인 음료(100)을 cateCodeRef 값으로 가지고 있음)
그리고 tbl_goods 에서 아이스 아메리카노가 cateCode로 101 을 가지면서 음료 > 에스프레소 카테고리 분류가 완성됨



