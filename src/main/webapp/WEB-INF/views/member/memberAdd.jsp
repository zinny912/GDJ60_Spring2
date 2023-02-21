<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
	
	<style>
		.redResult{
			color : red;

		}

		.blueResult{
			color : blue;
		}

	</style>


</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container fluid my-5">	
	<div class = "row col-6">
		<h1 class ="h4 pb-2 mb-4 fw-bold text-danger border-bottom border-danger">회원가입 PAGE</h1>
	
			<form id = "frm" class="row" action="./memberAdd" method="post"> 
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger">ID</label>
						<input type="text" id="id" name="id" class="form-control border-danger" placeholder="아이디">
						<div id = "idResult" class="redResult"></div>
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger">PASSWORD</label>
						<input type="password" id="pwd1" name="pwd1" class="form-control border-danger" placeholder="비밀번호입력">
						<div id="pwResult" class="redResult"></div>
					</div>		

					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger">PASSWORD</label>
						<input type="password" id="pwd2" name="pwd2" class="form-control border-danger" placeholder="비밀번호입력">
						<div id="pwCheck" class="redResult"></div>
					</div>

					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger">이름</label>
						<input type="text" id="name1" name="name1" class="form-control border-danger text-body-tertiary" placeholder="이름입력">
						<div id="nameCheck" class="redResult"></div>
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" >휴대폰번호</label>
						<input type="text" id="phone" name="phone" class="form-control border-danger text-body-tertiary" placeholder="연락처입력">
						<div id="phoneCheck" class="redResult"></div>
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger">이메일주소</label>
						<input type="text" id="email" name="email" class="form-control border-danger text-body-tertiary" placeholder="E-mail입력">
					<div id = "emailCheck" class="redResult"></div>
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" >주소</label>
						<input type="text" id="address" name="address" class="form-control border-danger text-body-tertiary" placeholder="주소지입력">
					<div id = "addressCheck" class="redResult"></div>
					</div>
								
				<div class="col-12">
					<button type="submit" class="btn btn-danger col-3 text-white fw-bold border border-3 border border-danger">등록</button>
				</div>
			</form>
			
		</div>
		
</div>			
	<script type="text/javascript" src="../resources/js/memberAdd.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>