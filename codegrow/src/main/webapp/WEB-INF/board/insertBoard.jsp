<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CodeGrow || Q&A</title>
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/border/boardInsert.css">
</head>
<body>
	<%@include file="../common/header.jsp"%>
	
	<section>
		<c:if test="${ not empty  content }">
			<form method="post" action="/boardUpdate">
				<div class="flex border-bottom">
					<span class="label">NAME</span>
					<span class="input">${ sessionScope.name }</span>
				</div>
				<div class="flex border-bottom">
					<span class="label">DATE</span>
					<span class="input">${ content.created_at }</span>
				</div>
				<div class="flex border-bottom align">
					<label for="title" class="label">TITLE</label>
					<input value="${ content.title }" type="text" id="title" name="title" class="input">
					<input value="${ content.id }" type="text" name="id" class="none">
				</div>
				<div class="flex border-bottom align-top">
					<label for="content" class="label">CONTENT</label>
					<textarea id="content" name="content" class="input">${ content.content }</textarea>
				</div>
				<button id="submit-button" class="pointer block bold">UPDATE</button>		
			</form>
		</c:if>
		
		<c:if test="${ empty content }">
			<form method="post" action="/boardInsert">
				<div class="flex border-bottom">
					<span class="label">NAME</span>
					<span class="input">${ sessionScope.name }</span>
				</div>
				<div class="flex border-bottom">
					<label for="title" class="label">TITLE</label>
					<input type="text" id="title" name="title" class="input">
				</div>
				<div class="flex border-bottom  align-top">
					<label for="content" class="label">CONTENT</label>
					<textarea id="content" name="content" class="input"></textarea>
				</div>
				<!-- <div>
					<label for="file">FILE</label>
					<input type="file" id="file" name="file"></input>
				</div> -->
				<button id="submit-button" class="pointer block bold">SUBMIT</button>		
			</form>
		</c:if>
	</section>

	<script src="./script/ohter/header.js"></script>
</body>
</html>