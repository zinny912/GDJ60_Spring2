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

<script type="text/javascript">
	/* alert창 띄우고 해당 주소로 이동하기 */
	let message = "${result}";
	if(message != ''){
		alert(message);
	}
	location.href="${url}"; 
	/* 약관동의하는 js 만들때 썼던거.. 문자열로 보내줄때는 위의 형태로 보내줘야한다!!! */
	
</script>
</body>
</html>