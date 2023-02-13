<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<h1 class="title">BankBook List page</h1>
	<div class="image">
		<img alt="" src="../resources/images/iu.jpg">
	</div>

	<table class="tbl2">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>
			<!-- items의 ${list}는 RequestScope, var의 dto는 PageScope -->
			<c:forEach items="${list}" var="dto">
				<tr>
					<!-- ${pageScope.dto.bookName}=${dto.bookName} -->
					<!-- ?이후는 파라미터임을 명시 -->
					<td><a href="./detail?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td class="tbl_td">${dto.bookRate}</td>
					<td class="tbl_td">
						<!-- Switch case 문 -->
						<c:choose>
							<c:when test="${dto.bookSale eq 1}">판매중</c:when>
							<c:otherwise>판매중단</c:otherwise>
						</c:choose>
					
<%-- 						<c:if test="${dto.bookSale eq 1}">판매중</c:if>
						<c:if test="${dto.bookSale eq 0}">판매중단</c:if> 
--%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- URL 요청하면 DS가 Controller로 이동 -->
	<a href="./add">상품등록</a>
</body>
</html>