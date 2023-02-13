<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<c:import url="./template/common_css.jsp"></c:import>
</head>
<body>
<!-- 서버 내부 주소, 상대경로 -->
<c:import url="./template/header.jsp"></c:import>

<section class="container border border-danger">
	<article class="row">
		<div class="col border border-danger">1</div>
		<div class="col border border-primary">2</div>
		<div class="col border border-danger">3</div>
	</article>
</section>


<section class="container-fluid border border-primary">
	<article class="row">
		<div class="col-2 border border-danger">1</div>
		<div class="col-7 border border-primary">2</div>
		<div class="col-3 border border-danger">3</div>
	</article>
</section>

<section class="container-md border border-danger">
	<article class="row">
		<div class="col-md-3 col-lg-6 border border-danger">1</div>
		<div class="col-md-3 col-lg-6 border border-primary">2</div>
		<div class="col-md-6 col-lg-12 border border-danger">3</div>
	</article>
</section>

</body>
</html>
