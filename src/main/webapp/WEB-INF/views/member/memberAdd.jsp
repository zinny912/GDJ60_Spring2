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
	</div>
	
		<div class="input-group mb-3">
			<form id = "frm" class="col-md-6" action="./memberAdd" method="post"> 
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" for="id">ID</label>
						<input type="text" id="id" name="id" class="form-control border-danger" placeholder="아이디">
						<div id = "idResult" class=""></div>
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" for="pw">PASSWORD</label>
						<input type="password" id="pw" name="pw" class="form-control border-danger" placeholder="비밀번호입력">
						<div id="pwResult"></div>
					</div>		

					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" for="pw">PASSWORD</label>
						<input type="password" id="pwCheck" name="pwCheck" class="form-control border-danger" placeholder="비밀번호입력">
						<div id="pwCheckResult"></div>
					</div>

					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" for="names">이름</label>
						<input type="text" id="names" name="names" class="form-control border-danger text-body-tertiary" placeholder="이름입력">
						
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" for="phone">휴대폰번호</label>
						<input type="tel" id="phone" name="phone" class="form-control border-danger text-body-tertiary" placeholder="연락처입력">
						
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" for="email">이메일주소</label>
						<input type="email" id="email" name="email" class="form-control border-danger text-body-tertiary" placeholder="E-mail입력">
					
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text col-3 fw-bold bg-danger text-white border border-3 border border-danger" for="address">주소</label>
						<input type="text" id="address" name="address" class="form-control border-danger text-body-tertiary" placeholder="주소지입력">
					
					</div>
								
				<div class="col-12">
					<button type="button" id="btn" class="btn btn-danger col-3 text-white fw-bold border border-3 border border-danger">등록</button>
				</div>
			</form>
			
		</div>
		
</div>			
	<c:import url="../template/common_js.jsp"></c:import>
	<script src="../resources/js/memberAdd.js"></script>
</body>
</html>