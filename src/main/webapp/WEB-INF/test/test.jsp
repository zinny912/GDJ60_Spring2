<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Remove Test</h1>
	
	<c:forEach begin="0" end="4" var="i">
		<div>
		
		<h3>${i}</h3>
		<button>DELETE</button>
		</div>
	</c:forEach>
		
	<script>
		
	
	
	</script>
	
	
</body>
</html>