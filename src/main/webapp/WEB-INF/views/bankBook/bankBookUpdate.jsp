<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Update Page</h1>
	
	<form action="./add" method="post">
			<!-- name은 dto의 setter의 이름(set빼고 첫글자 소문자)과 동일 -->
			상품명: <input type="text" name="bookName" value="${dto.bookName}" placeholder="제품명 입력"> <br>
			이자율: <input type="text" name="bookRate" value="${dto.bookRate}" > <br>
			상세정보: <textarea rows="" cols="" name="bookDetail">${dto.bookDetail}</textarea> <br>
			판매여부: <input type="text" name="bookSale" value="${dto.bookSale}">
			<input type="submit" value="수정">
			<button type="submit">수정</button>
					 
		</form>	
</body>
</html>