<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  

</h1>
<div>
		<a href="./product/list?num=1&num2$num3" class="menu">ProductList</a>
		<a href="/product/list" class="menu">ProductList</a>
		<a href="./member/list?num1&num2&num3" class="menu">MemberList</a>
		<a href="/bankBook/list" class="menu">BankBookList</a><!-- 절대경로 -->
		<a href="./bankBook/list" class="menu">BankBookList</a><!-- 상대경로 -->
</div>
<!-- src속성이 중요 -->
<!-- alt속성 : 여기에 어떤 이미지가 있다고 알려주는 역할 / web접근성(누구나 사용할수있게)음성으로 여기에 있다고 알려주는 용도  -->
<img alt="손석구이미지" src="/resources/images/se1.jpg">
<img alt="석구이미지" src="./resources/images/se2.jpg">
<iframe width="560" height="315" src="https://www.youtube.com/embed/7poSN5FABZA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
