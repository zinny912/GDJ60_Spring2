<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 추가 </title>
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<div class="container fluid">	
	<div class ="row justify-content-center my-4">
		<h1 class="h4 pb-2 mb-4 fw-bold text-warning border-bottom border-warning">${boardName} Update PAGE</h1>
	</div>
	<%-- 서버로 전송하고 싶은 정보들은 form 태그안에 넣어서 작성 --%>
	
	<div class="row justify-content-center my-4">
		<form class="col-md-7" action="./update" method="POST" enctype="multipart/form-data"> <%-- 같은 위치의 add로 POST 메서드 형식으로 보낼거임 --%>
		<input type="hidden" name="num" value="${dto.num}">
		 <div class="mb-3">
		  <label class="form-label" for="writer">작성자</label>
		  <input type="text" name="writer" class="form-control" id="writer" readonly value="${dto.writer}">
		</div>
	
		 <div class="mb-3">
			  <label class="form-label" for="title">제목</label>
			  <input type="text" name="title" class="form-control" id="title" value="${dto.title}" placeholder="제목입력">
		</div>
		 
		 <div class="mb-3">
			  <label class="form-label" for="contents">내용</label>
			  <textarea name="contents" class="form-control" id="contents" placeholder="내용입력" rows="7">${dto.contents}</textarea>
		 </div>
		 <div id="fileList" class="mb-3 my-5">
	            
	            <button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
			      <c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
					   <div class="input-group mb-3">
					     <div class="input-group-text">
					   		 <input class="form-check-input mt-0 deleteCheck" type="checkbox" value="${fileDTO.fileNum}" name="fileNum" aria-label="Checkbox for following text input">
					     </div>
			     		<input type="text" class="form-control" disabled value="${fileDTO.oriName}" aria-label="Text input with checkbox">
			   		   </div>
	       		</c:forEach>
	     </div>
	 
		<div class ="mb-3 ">
			<button type="submit" class="my btn btn-danger">글쓰기</button>
		</div>	
	
		</form>
	</div>
</div>
	
<script src="../resources/js/fileManager.js"></script>

<script>
	setMax(5);
	setParam('addfile');
	setCount('${dto.boardFileDTOs.size()}');
	$("#contents").summernote();
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>
