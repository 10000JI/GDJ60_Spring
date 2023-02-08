<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<!-- 상대경로 -->

<!-- 절대경로 -->
<a href="/product/list">ProductList</a>
<a href="/member/list">ProductMember</a>
<a href="/bankBook/list">BankBook</a>
<a href="./bankBook/list">BankBook</a>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
