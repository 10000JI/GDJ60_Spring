<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>

<!-- 상대경로 -->

<!-- 절대경로 -->
<a class="c1" href="/product/list">ProductList</a>
<a class="c1" href="/member/list">ProductMemberList</a>
<a class="c1" href="/bankBook/list">BankBookList</a>
<a class="c1" href="./bankBook/list">BankBookList</a>
<P>  The time on the server is ${serverTime}. </P>

<img alt="아이유이미지?" src="/resources/images/iu.jpg">
<img alt="아이유이미지!" src="./resources/images/iu2.jpg">

</body>
</html>
