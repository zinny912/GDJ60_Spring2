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
		<fieldset>
			<legend>상품명</legend>
			<input type="text" name="bookName" placeholder="제품명 입력"> <!-- 단순한 제목 type="text" / **name** -->
		</fieldset>
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate" placeholder="이자율 입력">
		</fieldset>
		<fieldset>
			<legend>상세정보</legend>
			<textarea rows="" cols="" name="bookDetail" placeholder="상품정보 입력"></textarea> <!-- 긴 글입력 -->
		</fieldset>
<!--	radio 선택선택 : 선택한게 넘어감 / 입력하는 것이 아니라 선택하는 경우에는 꼭 value를 미리 설정을 해줘야함	-->
		
		<fieldset>
		<legend>판매여부</legend>
			<label for="bs1">판매</label>
			<input id="bs1" type="radio" checked name="bookSale" value="1">
			
			<label for="bs2">판매중단</label>
			<input id="bs2" type="radio" name="bookSale" value="0">
		</fieldset>
		
		<!-- check box 여러개 중에 여러개 선택 -->
		<!-- select :여러개 중에 하나 선택 -->
		<fieldset>
			<legend>판매여부</legend>
			<select name="bookSale" >
				<option value="1">판매</option>
				<option selected value="0">판매중단</option>
			</select>
		</fieldset>
		<fieldset>
			<input type="submit" value="등록">
			<button type="submit">등록</button>
		</fieldset>
	</form>
	
</body>
</html>