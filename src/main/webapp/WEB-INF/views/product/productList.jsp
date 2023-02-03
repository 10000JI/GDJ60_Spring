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
</head>
<body>

	<h1>ProductList Page</h1>
	<% 
		List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list");
	
		 for(ProductDTO pro:ar){
	%>
			
		<h3><%=pro.getProductJumsu() %></h3>
<hr>
	<%}%>
	
	<hr>
	
	<c:forEach items="${list}" var="dto"> <!--  dto는 page영역(현재 jsp페이지에서만 사용 가능한 것)에 담김 -->
		<h3>${pageScope.dto.productName}</h3>
		<h3>${dto.productJumsu}</h3>
	</c:forEach>
	
	<!-- requestScope 속성명은 생략 가능 -->
	<h3>${list}</h3>
	<hr>
	<a href="./detail?productNum=11">productDetail</a>
	
</body>
</html>