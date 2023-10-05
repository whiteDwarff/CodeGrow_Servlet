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
	
	<h3 id="title">Uploade Lecture</h3>
	
		<div id="description">
			<p class="grey">- 빈 칸을 모두 입력해주세요.</p>
			<p class="grey">- TITLE은 최대 30자까지 입력할 수 있습니다.</p>
			<p class="grey">- DESCRIPTION은 최대 50자까지 입력할 수 있습니다.</p>
			<p class="grey">- LINK 입력 후 Youtube 버튼을 클릭하면 Youtube 링크와 연결됩니다.</p>
		</div>
	
		<form id="update-form" method="post" action="/lectureInsert">
			<div class="border-bottom flex align">
				<label>TITLE</label>
				<input type="text" name="title" class="content-input input">
				<small class="content-count block grey">0 / 30</small>
			</div>
				<div class="border-bottom flex align-top">
				<label>DESCRIPTION</label>
				<textarea name="description" class="content-input input"></textarea>
				<!-- 글자 수 제한 -->
				<small class="content-count block grey">0 / 50</small>
			</div>
			<div class="border-bottom flex align">
				<label>LINK</label>
				<input type="text" id="link" placeholder="https://youtu.be/" class="input" name="link">
			</div>
			<div class="border-bottom flex align">
				<label>CATEGORY</label>
				<select name="url">
					<option value="1">HTML/CSS</option>
					<option value="2">JavaScript</option>
					<option value="3">DataBase</option>
					<option value="4">Jsp</option>
					<option value="5">Spring</option>
				</select>
				<i class="fa-brands fa-youtube fa-bounce pointer" id="add-button"></i>
			<button id="submit" class="block pointer bold">SUBMIT</button>
			</div>
		</form>
		<!-- 동영상 썸네일 -->
		<embed controls=0 id="video" class="wrap block"
		 src="https://cdn.cwn.kr/news/photo/202204/9492_10476_851.jpg" allowfullscreen></embed>
	</section>
	
	<script type="module">
	import {
			addVideoLink,
			inputLengthHandler,
			submit,
		} from './script/lecture/lectureInsert.js'
	
	addVideoLink();
	inputLengthHandler();
	submit();
	</script>
</body>
</html>