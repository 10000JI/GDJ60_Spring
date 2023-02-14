<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 페이지</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="row justify-content-center">
			<h1 class="col text-center fw-bold">Member Page</h1>
		</div>
		
		<div class="row">
			<h3>Name : ${member.name}</h3>
			<h3>Phone : ${member.phone}</h3>
			<h3>Email : ${member.email}</h3>
			<a href="./memberUpdate" class="btn btn-info"> 정보수정</a>
		</div>
	</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>