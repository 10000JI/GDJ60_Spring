<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="" href="">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>MemberJoin Page</h1>
	<div class = "col-6">
		<form action="./memberJoin" method="post">
		아이디: <input type="text" name="id" values=""> <br> <br>
		비밀번호: <input type="text" name="pw" values=""> <br> <br>
		이름: <input type="text" name="name" values=""> <br> <br>
		전화번호: <input type="text" name="phone" values=""> <br> <br>
		이메일: <input type="text" name="email" values=""> <br> <br>
		
		<Button type="submit">등록</Button>
		</form>
	</div>
</body>
</html>