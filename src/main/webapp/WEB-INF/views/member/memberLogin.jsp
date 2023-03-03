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
	<div class="container-fluid">
		<div class = "my-5">
			<h1 class="h4 pb-2 mb-4 fw-bold text-danger border-bottom border-danger">로그인 PAGE</h1>
		</div>
			<form class="row col-6" action="./memberLogin" method="post"> 
				<div class="input-group mb-3">
				 	<span class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger">ID</span>
				 	<input type="text" id="id" name="id" class="form-control border border-3 border border-danger text-body-tertiary " placeholder="아이디입력" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" >PASSWORD</span>
				  	<input type="text" id="pw" name="pw" class="form-control border border-3 border border-danger text-body-tertiary" placeholder="비밀번호입력" aria-label="Username" aria-describedby="basic-addon1">
				</div>		
				<div class="my-3">
				    <button type="submit" class="btn btn-danger">로그인</button>
				</div>
		    </form>
		 
	</div>
		


<c:import url="../template/common_js.jsp"></c:import>		  
</body>
</html>