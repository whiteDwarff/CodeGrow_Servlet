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
<link rel="stylesheet" href="./css/border/boardContent.css">
</head>
<body>
	<%@include file="../common/header.jsp"%>
	
	<section id="main-content">
		<div class="main-wrap">
			<h3>❗ ${ content.title }</h3>
			<div class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-user grey"></i> 작성자</span>
				<span class="grey"> ${ content.name }</span>
			</div>
			<div class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-calendar-days grey"></i> 작성일</span>
				<span class="grey">${ content.created_at }</span>
			</div>
			<div id="last-wrap"class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-play grey"></i> 조회수</span>
				<span class="grey">${content.hit }</span>
			</div>
			<div id="content">
				<p class="content">			<span id="note">🗒</span> ${ content.content }</p>
			</div>
		</div><!-- qna-wrap -->
	</section>
	<!-- main-content -->

</body>
</html>