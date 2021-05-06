<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script src="http://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
	/* 11f7c2eec090164a076a7510d6b444c9 */
		window.Kakao.init("11f7c2eec090164a076a7510d6b444c9");
	
		function kakaoLogin() {
			window.Kakao.Auth.login({
				scope
			});
		}
	</script>
</body>
</html>




