<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 상품등록 </title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<div class="container fluid my-5">	
	<h1 class="h4 pb-2 mb-4 fw-bold text-warning border-bottom border-warning">상품등록 PAGE</h1>
	
	<!-- 서버로 전송하고 싶은 정보들은 form 태그안에 넣어서 작성 -->
	<form action="./add" method="POST" enctype="multipart/form-data"> <!-- 같은 위치의 add로 POST 메서드 형식으로 보낼거임 -->
	
	<div class="row col-6">
	 <div class="input-group mb-3">
	 	 <span class="input-group-text col-3 fw-bold bg-warning text-white border border-3 border border-warning" for="bookName">상품명</span>
	 	 <input type="text" id="bookName" name="bookName" class="form-control border border-3 border border-warning text-body-tertiary" placeholder="상품명입력" aria-label="Username" aria-describedby="basic-addon1">
	</div>
	
	  <div class="input-group mb-3">
		  <span class="input-group-text col-3 fw-bold bg-warning text-white border border-3 border border-warning" for="bookRate">이자율</span>
		  <input type="text" id="bookRate" name="bookRate" class="form-control border border-3 border border-warning text-body-tertiary" placeholder="이자율입력" aria-label="Username" aria-describedby="basic-addon1" >
	 </div>
	 
	 <div class="input-group mb-3">
		  <span class="input-group-text col-3 fw-bold bg-warning text-white border border-3 border border-warning" for="bookDetail">상세정보</span>
		  <textarea type="text" id="bookDetail" name="bookDetail" class="form-control border border-3 border border-warning text-body-tertiary" placeholder="상세정보입력" aria-label="Username" aria-describedby="basic-addon1" ></textarea>
	 </div>
	 

	 <div id="fileList" class="my-5">
		<div class="input-group mb-3">
			<label for="files" class="form-control">Image</label>
			<input type="file" class ="form-control" id ="files" name="pic">
		</div>
		<button type="button" id="fileAdd">ADD</button>
	</div>
		
		<div class="input-group mb-4 ">
		  <label class="input-group-text col-3 fw-bold text-white bg-warning border border-3 border border-warning" for="bookSale">판매여부</label>
		  <select class="form-select border border-3 border border-warning" name="bookSale" id="bookSale">
		    <option class="text-body-tertiary" value="1" selected>판매중</option>
		    <option class="text-body-tertiary" value="0">판매중단</option>
		   </select>
		</div>
		
		<div class ="my-3 ">
		<button type="submit" class="btn btn-warning col-3 fw-bold text-white">등록</button>
		</div>	

	</div>
					
	</form>
</div>	


<script src="../resources/js/fileManager.js"></script>

<script>
	setMax(3);
</script>


</body>
</html>