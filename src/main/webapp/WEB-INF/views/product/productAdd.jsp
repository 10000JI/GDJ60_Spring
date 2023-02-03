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
	<div class="col-6">
		<!--  메소드 post로 서버 내부에서 실행, productAdd 페이지로 넘어간다 (ProductController를 다시 확인하고 수행) -->
		<form action="./productAdd" method="post">
			<!-- 상품명과 상품정보 text입력 -->
			<!-- 파라미터 이름 = set메소드의 set지우고 첫글자 소문자 // 꼭 지정해줘야 함 -->
			<!-- values의 내용 (입력한 내용) 이 버튼 누르면 서버로 넘어감 -->
			상품명
			<input type="text" name="productName" values="">
			상품정보
			<textarea name="productDetail" rows="" cols=""></textarea>
			
			<!-- 전송버튼  -->
			<Button type="submit">등록</Button>
		</form>	
	</div>
</body>
</html>