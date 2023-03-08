<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container-fluid">
	<div class="row justify-content-center">
		<h1 class="col-md-7 text-center">${boardName} Add PAGE</h1>
	</div>	
	
	<div class="row justify-content-center">
		<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="writer" class="form-label">작성자</label> 
				<c:if test="${not empty member}">
					<input type="text" name="writer" class="form-control" id="writer" value="${member.id}" readonly>
				</c:if>
				<c:if test="${empty member}">
					<input type="text" name="writer" class="form-control" id="writer" value="${member.id}" disabled>
				</c:if>
			</div>
			
			<div class="mb-3">
				<label for="title" class="form-label">제목</label> 
				<input type="text" name="title" class="form-control" id="title" placeholder="제목 입력">
			</div>
	
			<div class="mb-3">
				<label for="contents" class="form-label">상세내용</label>
				<textarea name="contents" class="form-control" id="contents" placeholder="설명입력" rows="7"></textarea>
			</div>
			
			<div id="fileList">
<!-- 				<div class="input-group mb-3", id="f'+idx+'">
						<input type="file" class="form-control" name="'+param+'">
						<button type="button class="btn btn-outline-danger dels" data-dels-id="f'+idx+'">X</button>
					</div> -->
				<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
			</div>
		
			<div class="mb-3">
				<button class="btn btn-outline-success" type="submit">글쓰기</button> 
			</div>
		</form>
	</div>
</div>

	<script type="text/javascript" src="../resources/js/fileManager.js"></script>
	<script>
		setMax(5);
		setParam('addFiles');
		$('#contents').summernote();
	</script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>