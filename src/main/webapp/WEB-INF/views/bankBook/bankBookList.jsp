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
	<h1>BankBook List page</h1>
	<table border = 1>
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
					<td>${dto.bookRate}</td>
					<td>
						<!-- Switch case 문 -->
						<c:choose>
							<c:when test="${dto.bookSale eq 1}">판매중</c:when>
							<c:otherwise>판매중단</c:otherwise>
						</c:choose>
					
<%-- 						<c:if test="${dto.bookSale eq 1}">판매중</c:if>
						<c:if test="${dto.bookSale eq 0}">판매중단</c:if> --%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- URL 요청하면 DS가 Controller로 이동 -->
	<a href="./add">상품등록</a>
</body>
</html>