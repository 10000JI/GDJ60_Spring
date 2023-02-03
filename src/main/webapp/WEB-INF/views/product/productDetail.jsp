<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ProdcutDetail Page</h1>
	<!-- JSP는 ModelAndView 정보를 모름, request로 받는 것과 같은 개념이므로 Attribute로 받는다 -->
	<% ProductDTO productDTO = (ProductDTO)request.getAttribute("dto"); %>
	
	<h3><%=productDTO.getProductName() %></h3>
	<h3><%=productDTO.getProductDetail() %></h3>
	
	<hr>
	<h3>${requestScope.dto.productName}</h3>
	<h3>${dto.productDetail}</h3>
	<h3>${dto.productJumsu * dto.productNum}</h3>
	
</body>
</html>