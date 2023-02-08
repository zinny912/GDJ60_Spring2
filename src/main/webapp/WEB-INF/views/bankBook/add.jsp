<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품등록하시게</h1>
	
	<!-- 서버로 전송하고 싶은 정보들은 form 태그안에 넣어서 작성 -->
	<form action="./add" method="POST"> <!-- 같은 위치의 add로 POST 메서드 형식으로 보낼거임 -->
		
		<input type="text" name="bookName" placeholder="제품명 입력"><br> <!-- 단순한 제목 type="text" / **name** -->
		<input type="text" name="bookRate" placeholder="이자율 입력"><br>
		<textarea rows="" cols="" name="bookDetail" placeholder="상품정보 입력"></textarea><br> <!-- 긴 글입력 -->
		<input type="text" name="bookSale" placeholder="판매여부"><br>
		<input type="submit" value="등록">
		<button type="submit">등록</button>
	
	</form>
	
</body>
</html>