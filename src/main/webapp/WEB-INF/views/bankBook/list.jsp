<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BANKING</title>
  	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
<div class="container-fluid my-5">	
	
	<div class="row mb-4 border-bottom border-dark col-md-7 mx-auto">
		<h1 class="h4 pb-2 mb-4 col-md-12 fw-bold text-primary border-bottom border-primary">BankBook List Page</h1>
	</div>
		
		<div class="row col-md-7 mx-auto">
			<table class="table table-hover">
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
			
			
			<!-- Paging -->
			<div class="row">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  	 <li class="page-item ${pager.before? 'disabled':''}">
				      <a class="page-link " href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				  	 </li>
				  	<li class="page-item">
				      <a class="page-link " href="./list?page=${pager.page-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
				        <span aria-hidden="true">&lsaquo;</span>
				      </a>
				    </li>
				  	
				    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
				    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				    </c:forEach>
				    <li class="page-item" >
				      <a class="page-link" href="./list?page=${pager.totalPage}" aria-label="Next">
				        <span aria-hidden="true">&rsaquo;</span>
				      </a>
				    </li>
				    
				    
				    <li class="page-item" ${pager.after eq false ? 'disabled':''} >
				      <a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div>	
			
		<!-- 검색창 -->	
			<div class="row">
				<form class="row g-3" action="./list", method="get">
				  	<div class="col-auto">
						<label for="kind" class="visually-hidden">Kind</label>
						<select class="form-select" name="kind" id="kind" aria-label="Default select example">
							<option value="title">상품명</option>
							<option value="contents">상품내용</option>
							
						</select>
					</div>
				  <div class="col-auto">
						<label for="search" class="visually-hidden">Search</label>
						<input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력하세요">
				  </div>
				  <div class="col-auto">
				  	  <button type="submit" class="btn btn-primary mb-3">검색</button>
				  </div>
				</form>
						
			</div>		
		
			
<!-- 					
	 items = "" 배열, 리스트 등의 collection을 담는  
		<c:forEach items=""></c:forEach>
		 for(int i=1;i<=??; i++){i}                       step : 역순으로는 안됨, 1씩 증가하는 경우 생략가능 
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
				<a href="./list?page=${i}">${i}</a>
			</c:forEach>
			</div> -->
		
		<div class="row col-md-2 mx-auto">
			<a href="./add" class ="btn btn-primary">상품등록</a>
		</div>
</div>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>