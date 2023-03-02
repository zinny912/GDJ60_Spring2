<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 추가 </title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<div class="container fluid">	
	<div class ="row justify-content-center my-4">
		<h1 class="h4 pb-2 mb-4 fw-bold text-warning border-bottom border-warning">${boardName} Add PAGE</h1>
	</div>
	<!-- 서버로 전송하고 싶은 정보들은 form 태그안에 넣어서 작성 -->
	
	<div class="row justify-content-center my-4">
		<form action="./add" method="POST" enctype="multipart/form-data"> <!-- 같은 위치의 add로 POST 메서드 형식으로 보낼거임 -->
		
		 <div class="input-group mb-3">
		  <span class="input-group-text col-3 fw-bold bg-warning text-white border border-3 border border-warning" for="writer">작성자</span>
		  <input type="text" name="writer" class="form-control border border-3 border border-warning text-body-tertiary" id="writer" aria-label="Username" aria-describedby="basic-addon1">
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
	</div>
	 
		<div class ="my-3 ">
		<button type="submit" class="btn btn-warning col-3 fw-bold text-white">글쓰기</button>
		</div>	
	
	</form>
</div>
	
<script src="../resources/js/fileManager.js"></script>

<script>
	setMax(5);
	setParam('files');
</script>
<c:import url="../template/common_js.jsp"></c:import>

</body>
</html>
