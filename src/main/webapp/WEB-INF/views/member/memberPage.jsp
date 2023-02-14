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

	<div class="contanier-fluid">
		<div class="row">
			<h1>Member Page</h1>
		</div>
		<div class="row">
			<h3>Name : ${member.name}</h3>
			<h3>Phone : ${member.phone}</h3>
			<h3>Email : ${member.email}</h3>
			<a href="./memberUpdate" class="btn btn-info">정보수정</a>
		</div>
	
	</div>


<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>