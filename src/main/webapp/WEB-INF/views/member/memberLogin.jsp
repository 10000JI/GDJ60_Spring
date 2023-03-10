<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">

	<div class="row justify-content-center">
		<h1 class="col-md-6 text-center fw-bold">MemberLogin Page</h1>
	</div>
	
	<div class = "row justify-content-center">
		<form class="col-md-6" action="./memberLogin", method="post">
			<div class="mb-3">
				<label for="id" class="form-label fw-bold">아이디</label> 
				<input type="text" value="${cookie.rememberId.value}" name="id" class="form-control" id="id" placeholder="아이디 입력">
			</div>
			
			<div class="mb-3">
				<label for="pw" class="form-label fw-bold">비밀번호</label> 
				<input type="password" name="pw" class="form-control" id="pw" placeholder="비밀번호 입력">
			</div>
			
			<div class="mb-3">
				<button class="btn btn-outline-success fw-bold" type="submit">확인</button> 
			</div>
				<input type="checkbox" name="remember" value="remember" class="form-check-input"> 
		</form>
	</div>
</div>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>