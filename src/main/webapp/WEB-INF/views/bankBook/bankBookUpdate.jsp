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
	<div class="col-6"></div>
		<form action="./update" method="post">
				<!-- name은 dto의 setter의 이름(set빼고 첫글자 소문자)과 동일 -->
				<!-- name은 파라미터 이름이 되므로, 동일하게 꼭 설정 -->
				<input type="hidden" name="bookNum" value="${dto.bookNum}">
			<fieldset>
				<legend>상품명</legend>
				<input type="text" name="bookName" value="${dto.bookName}" placeholder="제품명 입력"> <br>
			</fieldset>
			
			<fieldset>
				<legend>상품정보</legend>
				<textarea rows="" cols="" name="bookDetail">${dto.bookDetail}</textarea> <br>
			</fieldset>
			
			<fieldset>
				<legend>이자율</legend>
				<input type="text" name="bookRate" value="${dto.bookRate}" > <br>
			</fieldset>
			
			<fieldset>
				<legend>판매여부</legend>
				<label for="bs1">판매</label>
				<!-- checked를 삼항연산자로 본래 값이었던걸 디폴트로 선택되게 함 -->
				<input id="bs1" type="radio" ${dto.bookSale eq '1' ? 'checked':''} name="bookSale" value="0">
				
				<label for="bs2">판매중단</label>
					<input id="bs2" type="radio" ${dto.bookSale eq '0' ? 'checked':''} name="bookSale" value="1">
			</fieldset>
			
			<fieldset>
				<legend>판매여부</legend>	
				<select name="bookSale">
					<option ${dto.bookSale eq '1' ? 'selected':''} value="1">판매</option>
					<option ${dto.bookSale eq '0' ? 'selected':''} value="0">판매중단</option>
				</select>
			</fieldset>	
			
			<fieldset>
				<input type="submit" value="수정">
				<button type="submit">수정</button>	 
			</fieldset>
		</form>	
</body>
</html>