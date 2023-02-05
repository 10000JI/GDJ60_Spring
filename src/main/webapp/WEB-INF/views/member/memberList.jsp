<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<h1>MmeberList Page</h1>

	<div class="col-6">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>핸드폰번호</th>
					<th>이메일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dtoList">
					<tr>
						<td>${pageScope.dtoList.id}</td>
						<td>${dtoList.name}</td>
						<td>${dtoList.phone}</td>
						<td>${dtoList.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-danger" href="./memberJoin">회원가입</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	</body>
</body>
</html>