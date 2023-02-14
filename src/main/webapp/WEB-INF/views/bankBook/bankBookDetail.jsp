 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품의 상세정보</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid my-5">
	<div class="row justify-content-center">
		<h1 class="col-md-8 text-center">BankBook Detail Page</h1>
	</div>
	<div class="row justify-content-center ">
		<div class="col-md-7">
			<c:if test="${not empty dto.bookNum }">	
				<div class="shadow-sm p-3 mb-5 bg-body-tertiary rounded">
					<h3>Num : ${dto.bookNum}</h3>
					<h3>Title : ${dto.bookName}</h3>
					<h3>Detail : ${dto.bookDetail}</h3>
					<h3>Rate : ${dto.bookRate}</h3>
					<h3>Sale : ${dto.bookSale}</h3>
				</div>
				<a href="./delete?bookNum=${dto.bookNum}">상품삭제</a> 
			</c:if>
			<c:if test="${empty dto.bookNum}">	
				<h3>존재하지 않는 상품입니다.</h3> 
			</c:if>
			<a href="./update?bookNum=${dto.bookNum}">상품수정</a>
			<a href="./list">목록으로</a>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
	
</div>
</body>
</html>