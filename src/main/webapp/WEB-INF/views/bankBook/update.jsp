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
<c:import url="../template/header.jsp"></c:import>
<body>
	<!-- 수정할 수 있는 것과 수정하면 안되는 항목을 선정 bookNumber:수정불가, bookName,bookRate,bookSale,bookDetail -->
<div class="container-fluid">	
	<div class = "row justify-content-center my-4">
		<h1 class="col-md-7 text-center">상품 수정 페이지</h1>
	</div>	
	<div class="row justify-content-center my-4">
		<form class="col-md-7" action="./update" method="post">
			<!-- 숨기자!! "hidden" -->
			<input type="hidden" name="bookNumber" value="${dto.bookNumber}">
		
		<!-- disabled -->
		<div class="mb-3">
			<label for="bookName" class="form-label">상품명</label>
			<input type="text" name="bookName" class="form-control" value="${dto.bookName}" id="bookName" placeholder="수정할 제품명 입력"> <!-- 단순한 제목 type="text" / **name** -->
		</div>
		<div class="mb-3">
			<label for="bookRate" class="form-label">이자율</label>
			<input type="text" name="bookRate" class="form-control" value="${dto.bookRate}" id="bookRate" placeholder="이자율 입력"> <!-- 단순한 제목 type="text" / **name** -->
		</div>
		<div class="mb-3">
			<label for="bookDetail" class="form-label">상세설명</label>
			<input type="text" name="bookDetail" class="form-control" value="${dto.bookDetail}" id="bookDetail" placeholder="상세설명 입력"> <!-- 단순한 제목 type="text" / **name** -->
		</div>
		
		
		<%-- <fieldset>
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
		</fieldset> --%>
		
		<div class="mb-3 form-check form-switch">
			<label class="form-check-label" for="bookSale">판매여부</label>
			<input name="bookSale" class="form-check-input" ${dto.bookSale==1?'checked':''} value="1" type="checkbox" role="switch" id="bookSale">
		</div>	
		
		<div class="mb-3">
			<button class="my btn btn-danger" type="submit">수정</button>
		</div>
	
	</form>
<c:import url="../template/common_js.jsp"></c:import>	
</body>
</html>