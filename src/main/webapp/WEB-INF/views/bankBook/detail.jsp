<%@page import="com.iu.s1.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>BankBook Detail Page</h1>

	<c:if test="${not empty dto}">
	<h3>Num : ${dto.bookNumber}</h3>
	<h3>Title : ${dto.bookName}</h3>
	<h3>Detail : ${dto.bookDetail}</h3>
	<h3>Rate : ${dto.bookRate}</h3>
	<h3>Sale : ${dto.bookSale}</h3>
	<%-- <c:if test="${dto.bookSale eq 1}">판매중</c:if>
			   <c:if test="${dto.bookSale ne 1}">판매중단</c:if> --%>
			   
	<div>
		<c:if test="${not empty dto.bankBookImgDTO}">
			<img src="../resources/upload/bankBook/${dto.bankBookImgDTO.fileName}">
		</c:if>
	</div>
	
	
	<a href="./delete?bookNumber=${dto.bookNumber}">상품삭제</a>		  
	</c:if>
	
	
	<c:if test="${empty dto}">
		<h3>존재하지 않는 상품입니다.</h3>
	</c:if>

	<a href="./update?bookNumber=${dto.bookNumber}">상품수정</a>
	<a href="./list">목록으로</a>

	<div class="my-5" id="commentListResult">
	
	</div>

		<div class="my-5">
		  	<div class="mb-3">
				<textarea class="form-control" rows="3" id="replyContents"></textarea>
		  	</div>
		  <div class="mb-3">
				<button type="button" class="btn btn-primary" id="replyAdd" data-book-bookNumber="${dto.bookNumber}">댓글작성</button>
		  </div>

		</div>


<c:import url="../template/common_js.jsp"></c:import>
<script src="/resources/js/bankBookReply.js"></script>
</body>
</html>
