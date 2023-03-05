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
<div class="bg-white border rounded-5">

		<section class="w-100 p-4 d-flex justify-content-center pb-4">
			<form style="width: 22rem;">
				<!-- Email input -->
			<div class="form-outline mb-4">
				<input type="email" id="form1Example1" class="form-control">
				<label class="form-label" for="form1Example1" style="margin-left: 0px;">Email address</label>
			<div class="form-notch"><div class="form-notch-leading" style="width: 9px;"></div>
			<div class="form-notch-middle" style="width: 88.8px;"></div>
			<div class="form-notch-trailing"></div></div>	
			</div>
				<!-- Password input -->
			<div class="form-outline mb-4">
				<input type="password" id="form1Example2" class="form-control">
				<label class="form-label" for="form1Example2" style="margin-left: 0px;">Password</label>
			<div class="form-notch"><div class="form-notch-leading" style="width: 9px;"></div>
			<div class="form-notch-middle" style="width: 64.8px;"></div>
			<div class="form-notch-trailing"></div></div>	
			</div>
				<!-- 2 column grid layout for inline styling -->
				<div class="row mb-4">
					<div class="col d-flex justify-content-center">
						<!-- checkbox -->
						<div class="form-check" >
							<input class="form-check-input" type="checkbox" value="" id="form1Example3" checked="">
							<label class="form-check-label" for="form1Example3">Remember Me</label>
						</div>
					</div>
				
					<div class="col">
						<!-- simple link -->
						<a href="#!">Forgot password?</a>
					</div>
				</div>	
				
				<!-- Submit button -->
				<button type="button" class="btn btn-primary btn-block">Sign in</button>
			</form>
		
		</section>
		
		<div class="p-4 text-center border-top mobile-hidden">
			<a class="btn btn-link px-3" data-mdb-toggle="collapse" href="#example1" role="button" aria-expanded="false" aria-controls="example1" data-ripple-color="hs1(0, 0%,67%)">
				<i class="fas fa-code me-md-2"></i>
				<span class="d-none d-md-inline-block">
				Show code
				</span>
			</a>
		
			<a class="btn btn-link px-3" data-ripple-color="hs1(0, 0%, 67%)">
				<i class="fas fa-file-code me-md-2 pe-none"></i>
				<span class="d-none d-md-inline-block export-to-snippet pe-none">
					Edit in sandbox
				</span>
			</a>
		</div>
	</div>
	
			<h1>Product Add page</h1>
			<div class="col-6">
				<form action="./productAdd" method="post">
					상품명
					<input type="text" name="productName" value="test">
					상품정보
					<textarea name="productDetail" rows="" cols=""></textarea>
					
					<button type="submit">등록</button>
				</form>
				
			</div>
<script type="text/javascript" src="../template/common_js.jsp"></script>		
</body>
</html>