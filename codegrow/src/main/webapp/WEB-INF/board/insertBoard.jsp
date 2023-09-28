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
</head>
<body>
	<%@include file="../common/header.jsp"%>
	
	<section>
		<form method="post" action="/boardInsert">
			<div>
				<label for="title">TITLE</label>
				<input type="text" id="title" name="title">
			</div>
			<div>
				<label for="content">CONTENT</label>
				<textarea id="content" name="content"></textarea>
			</div>
			<!-- <div>
				<label for="file">FILE</label>
				<input type="file" id="file" name="file"></input>
			</div> -->
			<button id="submit-button">SUBMIT</button>		
		</form>
	
	
	</section>




	<script src="./script/ohter/header.js"></script>
</body>
</html>