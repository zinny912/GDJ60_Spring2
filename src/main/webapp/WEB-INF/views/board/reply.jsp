<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> '답글' </title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<div class="container fluid my-5">	
	<div class="row justify-content-center my-4">
		<h1 class="h4 pb-2 mb-4 fw-bold text-warning border-bottom border-warning">${boardName} REPLY PAGE</h1>
	</div>
	
		<%-- 서버로 전송하고 싶은 정보들은 form 태그안에 넣어서 작성 --%>
		<div class="row justify-content-center my-4">
			<form class="col-md-7" action="./reply" method="POST" enctype="multipart/form-data"> <%-- 같은 위치의 add로 POST 메서드 형식으로 보낼거임 --%>
		 		<input type="hidden" name="num" value="${boardDTO.num}">
				<div class="input-group mb-3">
				  <label class="form-label" for="writer">작성자</label>
				  <input type="text" name="writer" class="form-control" id="writer">
				</div>	
		
				 <div class="mb-3">
					<label class="form-label" for="title">제목</label>
				  	<input type="text" name="title" class="form-control" id="title">
	 			</div>
	 			<div class="mb-3">
					<label class="form-label" for="contents">내용</label>
				  	<textarea name="contents" class="form-control" id="contents" placeholder="내용입력" rows="7"></textarea>
	 			</div>

			<div id="fileList" class="my-5">
		 			
					<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
			</div>
					 
				<div class ="mb-3 ">
					<button type="submit" class="btn btn-warning col-3 fw-bold text-white">글쓰기</button>
				</div>	
			</form>
	</div>

</div>	


<script src="../resources/js/fileManager.js"></script>
<script>
	setMax(5);
	setParam('files');
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>