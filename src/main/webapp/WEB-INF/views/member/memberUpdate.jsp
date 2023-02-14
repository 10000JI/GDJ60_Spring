<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보 수정</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row">
			<h1>MemberUpdate Page</h1>
		</div>
		
		<div class="row">
			<form action="./memberUpdate" method="post">
				<input type="hidden" name="id" value="${member.id}">
				
				<div class="mb-3">
					<label for="name" class="form-label fw-bold">이름</label> 
					<input type="text" name="name" class="form-control" id="name" value="${member.name}">
				</div>
			
				<div class="mb-3">
					<label for="phone" class="form-label fw-bold">전화번호</label> 
					<input type="tel" name="phone" class="form-control" id="phone" value="${member.phone}">
				</div>
				
				<div class="mb-3">
					<label for="email" class="form-label fw-bold ">이메일</label> 
					<input type="email" name="email" class="form-control" id="email" value="${member.email}">
				</div>
				
				<div class="mb-3">
				<button class="btn btn-outline-success fw-bold" type="submit">확인</button> 
			</div>
				
			</form>		
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>