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

<div class="my-5">
	<h1>회원정보 수정</h1>
		<form class="row col-6" action="./memberUpdate" method="post"> 
			
							
				<div class="input-group mb-3">
				  <span class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" id="name">이름</span>
				  <input type="text" name="name" class="form-control border border-3 border border-danger text-body-tertiary" value="${member.name}" placeholder="이름입력" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" id="phone">휴대폰번호</span>
				  <input type="text" name="phone" class="form-control border border-3 border border-danger text-body-tertiary" value="${member.phone}" placeholder="연락처입력" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" id="email">이메일주소</span>
				  <input type="text" name="email" class="form-control border border-3 border border-danger text-body-tertiary" value="${member.email}" placeholder="E-mail입력" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" id="address">주소</span>
				  <input type="text" name="address" class="form-control border border-3 border border-danger text-body-tertiary" value="${member.address}" placeholder="주소지입력" aria-label="Username" aria-describedby="basic-addon1">
				</div>
							
			  <div class="col-12">
			    <button type="submit" class="btn btn-danger col-3 text-white fw-bold border border-3 border border-danger">정보수정</button>
			  </div>
		</form>
</div>

<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>