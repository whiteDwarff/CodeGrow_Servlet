<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>CodeGrow || Q&A</title>
<!-- ##### SUMMER NOTE ##### -->
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<!--  jQuery, bootstrap -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js?after"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<!-- ##### SUMMER NOTE ##### -->
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/border/boardInsert.css">
<link rel="stylesheet" href="./css/ohter/header.css">
</head>
<body>
	<%@include file="../common/header.jsp"%>
	
	<section>
		<c:if test="${ not empty  content }">
			<form id="insert-form" method="post" action="/boardUpdate">
				<div class="flex border-bottom padding">
					<span class="input-label">NAME</span>
					<span class="input">${ sessionScope.name }</span>
				</div>
				<div class="flex border-bottom padding">
					<span class="input-label">DATE</span>
					<span class="input">${ content.created_at }</span>
				</div>
				<div class="flex border-bottom align padding">
					<span class="input-label">TITLE</span>
					<input value="${ content.title }" type="text" id="title" name="title" class="input">
					<input value="${ content.id }" type="text" name="id" class="none">
				</div>
				<div class="flex border-bottom align-top padding">
					<span class="input-label">CONTENT</span>
					<textarea th:field="*{content}" class="summernote input" id="content" name="content">${ content.content }</textarea>
				</div>
				<input type="text" value="${ pm }" name="param" class="none">
				<input type="submit" id="submit-button" class="pointer block bold" value="UPDATE">
			</form>
		</c:if>
		
		<c:if test="${ empty content }">
			<form id="insert-form" method="post" action="/boardInsert">
				<div class="flex border-bottom padding">
					<span class="input-label">NAME</span>
					<span class="input">${ sessionScope.name }</span>
				</div>
				<div class="flex border-bottom padding">
					<span class="input-label">TITLE</span>
					<input type="text" id="title" name="title" class="input">
				</div>
				<div class="flex border-bottom align-top padding">
					<span class="input-label">CONTENT</span>
					<textarea th:field="*{content}" class="summernote input" id="content" name="content"></textarea>
				</div>
				<input type="text" value="${ pm }" name="param" class="none">
				<input type="submit" id="submit-button" class="pointer block bold" value="SUBMIT">	
			</form>
		</c:if>
	</section>

	<%@include file="../common/footer.jsp"%>
	
<script src="./script/ohter/header.js"></script>
<script type="module">
import {
	insertBoard,
	summerNote,
} from './script/board/boardInsert.js';
insertBoard();
summerNote();
</script>	
</body>
</html>