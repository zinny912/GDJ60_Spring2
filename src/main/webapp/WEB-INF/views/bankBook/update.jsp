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
		
		<input type="text" name="bookName" value="${dto.bookName}" placeholder="수정할 제품명 입력"><br> <!-- 단순한 제목 type="text" / **name** -->
		<input type="text" name="bookRate" value="${dto.bookRate}"><br>
		
		<textarea rows="" cols="" name="bookDetail">${dto.bookDetail}</textarea><br> <!-- 긴 글입력 -->
		
		<input type="text" name="bookSale" value="${dto.bookSale}"><br>
		<input type="submit" value="수정">
		<button type="submit">수정</button>
	
	
	</form>
	
</body>
</html>