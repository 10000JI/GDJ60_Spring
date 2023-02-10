<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>

	<h1 class="pr">ProductList Page</h1>
	<% 
		List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list");
	
		 for(ProductDTO pro:ar){
	%>
		<h3><%=pro.getProductName() %></h3>
		<h3><%=pro.getProductJumsu() %></h3>

	<%}%>
	
	<hr>
	

	<table class="tbl2">
		<thead>
			<tr>
				<th>상품명</th><th>평점</th>
			</tr>
		</thead>

		<tbody>


			<c:forEach items="${list}" var="dto"> <!--  dto는 page영역(현재 jsp페이지에서만 사용 가능한 것)에 담김 -->
				<tr>
					<td><a href="./detail?productNum=${dto.productNum}"> ${pageScope.dto.productName}</a></td>
					<td>${dto.productJumsu}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	

</body>
</html>