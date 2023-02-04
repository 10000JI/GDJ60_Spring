<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ProductAdd Page</h1>
	<div class = "col-6">
		<form action="./productAdd" method="post">
			상품명: <input type="text" name="productName" values="">
			상품정보: <textarea name="productDetail" rows="" cols=""></textarea>
			
			<Button type="submit">등록</Button>		
		</form>
	</div>
</body>
</html>