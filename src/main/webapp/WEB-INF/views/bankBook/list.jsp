<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<h1 class="title">BankBook List Page</h1>
	
	<div class="image">
	<img alt="석구이미지" src="../resources/images/se1.jpg">
	</div>
	<table class="tbl2">
		<thead> <!-- 제목을 모아놓을 Row -->
			<tr>
				<th>상품명</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>

			<!-- 출력용도는 EL인데, 반복문이 없어서 사용하려면 JSTL 사용해야함 -->
		
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="./detail?bookNumber=${dto.bookNumber}">${pageScope.dto.bookName}</a></td>
					<td class="tbl2_td">${dto.bookRate}</td>
					
					<td class="tbl2_td">
					<!-- if/else문 switch/case -->
						<c:choose>
							<c:when test="${dto.bookSale eq 1}">판매중</c:when>
							<c:otherwise>판매중단</c:otherwise>
						</c:choose>
					
					<!-- 단일 if문  
					<c:if test="${dto.bookSale eq 1}">판매중</c:if>
					<c:if test="${dto.bookSale ne 1}">판매중단</c:if>
					-->
					</td>
				</tr>
			</c:forEach>	
			
		</tbody>
	</table>
	
	<a href="./add">상품등록</a>
</body>
</html>