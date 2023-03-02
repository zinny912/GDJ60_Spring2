<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 답글 </title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<div class="container fluid my-5">	
	<h1 class="h4 pb-2 mb-4 fw-bold text-warning border-bottom border-warning">${boardName} REPLY PAGE</h1>
	
	<!-- 서버로 전송하고 싶은 정보들은 form 태그안에 넣어서 작성 -->
	<form action="./reply" method="POST" enctype="multipart/form-data"> <!-- 같은 위치의 add로 POST 메서드 형식으로 보낼거임 -->
	
	<div class="row col-6">
	 <div class="input-group mb-3">
	  
	  <input type="hidden" name="num" value="${boardDTO.num}" id="num" class="form-control border border-3 border border-warning text-body-tertiary" aria-label="Username" aria-describedby="basic-addon1">
	</div>
	<div class="input-group mb-3">
		  <span class="input-group-text col-3 fw-bold bg-warning text-white border border-3 border border-warning" for="writer">작성자</span>
		  <input type="text" name="writer" class="form-control border border-3 border border-warning text-body-tertiary" id="writer" aria-label="Username" aria-describedby="basic-addon1" >
	 </div>	
		
	  <div class="input-group mb-3">
		  <span class="input-group-text col-3 fw-bold bg-warning text-white border border-3 border border-warning" for="title">제목</span>
		  <input type="text" name="title" class="form-control border border-3 border border-warning text-body-tertiary" id="title" placeholder="제목입력" aria-label="Username" aria-describedby="basic-addon1" >
	 </div>
	 
	 <div class="input-group mb-3">
		  <span class="input-group-text col-3 fw-bold bg-warning text-white border border-3 border border-warning" for="contents">상세내용</span>
		  <textarea type="text" name="contents" class="form-control border border-3 border border-warning text-body-tertiary" id="contents" placeholder="상세내용입력" aria-label="Username" aria-describedby="basic-addon1" ></textarea>
	 </div>
	 

	<div id="fileList" class="my-5">
 				 <!-- <div class="input-group mb-3">
					<input type="file" class="form-control" id="files" name="files">
					<button type="button" class="btn btn-outline-danger">X</button>
				</div>  -->
			<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
	</div>
	 
		<div class ="my-3 ">
		<button type="submit" class="btn btn-warning col-3 fw-bold text-white">글쓰기</button>
		</div>	

	</div>
					
	</form>
</div>	


<script src="../resources/js/fileManager.js"></script>

<script>
	setMax(5);
	setParam('files');
</script>


</body>
</html>
	
	
	
<!-- 	<fieldset>
			<legend class="fw-bold">상품명</legend>
			<input type="text" name="bookName" placeholder="제품명 입력"> -->
			 <!-- 단순한 제목 type="text" / **name** -->
<!--  	</fieldset>
		<fieldset>
			<legend class="fw-bold">이자율</legend>
			<input type="text" name="bookRate" placeholder="이자율 입력">
		</fieldset>
		<fieldset>
			<legend class="fw-bold">상세정보</legend>
			<textarea rows="" cols="" name="bookDetail" placeholder="상품정보 입력"></textarea>--> 
			<!-- 긴 글입력 -->
<!--		</fieldset>  -->
<!--	radio 선택선택 : 선택한게 넘어감 / 입력하는 것이 아니라 선택하는 경우에는 꼭 value를 미리 설정을 해줘야함	-->
		
<!--  	<fieldset>
		<legend>판매여부</legend>
			<label for="bs1">판매</label>
			<input id="bs1" type="radio" checked name="bookSale" value="1">
			
			<label for="bs2">판매중단</label>
			<input id="bs2" type="radio" name="bookSale" value="0">
		</fieldset>
-->			
		<!-- check box 여러개 중에 여러개 선택 -->
		<!-- select :여러개 중에 하나 선택 -->
