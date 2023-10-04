<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/lecture/lectureInsert.css">
</head>
<body>
	
	<%@include file="../common/header.jsp"%>
	<section class="wrap">
	
	<h3>Uploade Lecture</h3>
	
		<form id="update-form">
			<div class="border-bottom flex align">
				<label>TITLE</label>
				<input type="text" name="title">
			</div>
				<div class="border-bottom flex align-top">
				<label>DESCRIPTION</label>
				<textarea name="description" id="description"></textarea>
				<!-- 글자 수 제한 -->
				<small id="count">0 / 50</small>
			</div>
			<div class="border-bottom flex align">
				<label>LINK</label>
				<input type="text" id="link" placeholder="https://youtu.be/">
			</div>
			<div class="border-bottom flex align">
				<label>CATEGORY</label>
				<select name="category">
					<option value="html">HTML/CSS</option>
					<option value="JavaScript">JavaScript</option>
					<option value="DataBase">DataBase</option>
					<option value="Jsp">Jsp</option>
					<option value="Spring">Spring</option>
				</select>
				<i class="fa-brands fa-youtube fa-bounce pointer" id="add-button"></i>
			</div>
		</form>
		<!-- 동영상 썸네일 -->
		<embed controls=0 id="video" class="wrap block"
		 src="https://cdn.cwn.kr/news/photo/202204/9492_10476_851.jpg" allowfullscreen></embed>
	</section>
	
	<script src="./script/lecture/lectureInsert.js">
	
	</script>
</body>
</html>