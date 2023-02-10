<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 수정할 수 있는 것과 수정하면 안되는 항목을 선정 bookNumber:수정불가, bookName,bookRate,bookSale,bookDetail -->
	<h1>수정하라우</h1>
		
	<form action="./update" method="post">
		<!-- 숨기자!! "hidden" -->
		
			<input type="hidden" name="bookNumber" readonly="readonly" value="${dto.bookNumber}">
		
		<!-- disabled -->
		<fieldset>
			<legend>상품명</legend>
		<input type="text" name="bookName" value="${dto.bookName}" placeholder="수정할 제품명 입력"> <!-- 단순한 제목 type="text" / **name** -->
		</fieldset>
		<fieldset>
			<legend>이자율</legend>
		<input type="text" name="bookRate" value="${dto.bookRate}">
		</fieldset>
		<fieldset>
			<legend>상세정보</legend>
			<textarea rows="" cols="" name="bookDetail">${dto.bookDetail}</textarea> <!-- 긴 글입력 -->
		</fieldset>
		<fieldset>
			<legend>판매여부</legend>
				<label for="bs1">판매</label>
				<input id="bs1" type="radio" ${dto.bookSale eq '1' ? 'checked':''} name="bookSale" value="1">
			<label for="bs2">판매중단</label>
		<input id="bs2" type="radio" ${dto.bookSale eq '0' ? 'checked':''} name="bookSale" value="0">
		</fieldset>
		
		<fieldset>
			<legend>판매여부</legend>
			<select name="bookSale" >
				<option ${dto.bookSale eq '1' ? 'selected':'' } value="1">판매</option>
				<option ${dto.bookSale eq '0' ? 'selected':'' } value="0">판매중단</option>
			</select>
		</fieldset>
		
		
		
		
		
		<input type="submit" value="수정">
		<button type="submit">수정</button>
	
	
	</form>
	
</body>
</html>