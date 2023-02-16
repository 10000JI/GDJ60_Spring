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
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<h1 class="title">ProductList Page</h1>
	
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
	
	<div class="row">
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li class="page-item ${pager.before?'disabled':''}">
		    	<a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		    	 <span aria-hidden="true">&lsaquo;</span>
		   		</a>
		   	</li>
		   	
		   	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i" >
		   		<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
		   	</c:forEach>
		   	
		   	
		    <li class="page-item ${pager.after eq false ? 'disabled' : ''}">
		    	<a class="page-link" href="./list?page=${pager.startNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		    	 <span aria-hidden="true">&rsaquo;</span>
		   		</a> 
		   	</li>	
		   	<li class="page-item">
		    	<a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		    	 <span aria-hidden="true">&raquo;</span>
		   		</a> 
		   	</li>	
		  </ul>
		</nav>
	</div>
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>