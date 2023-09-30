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
<link rel="stylesheet" href="./css/border/boardContent.css">
</head>
<body>
	<%@include file="../common/header.jsp"%>
	
	<section id="main-content">
		<div class="main-wrap">
			<div id="title-wrap" class="flex between align">
			<h3>❗ ${ content.title }</h3>
				<c:if test="${ sessionScope.name == content.name }">
				<div>
					<a href="/boardInsert?id=${ content.id }"><i class="fa-solid fa-pen pointer"></i></a>
					<i class="fa-solid fa-trash pointer"></i>
				</div>			
				</c:if>
			</div>
			<div class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-user grey"></i> 작성자</span>
				<span class="grey"> ${ content.name }</span>
			</div>
			<div class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-calendar-days grey"></i> 작성일</span>
				<span class="grey">${ content.created_at }</span>
			</div>
			<div class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-play grey"></i> 조회수</span>
				<span class="grey">${content.hit }</span>
			</div>
			<div id="last-wrap"class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-check grey"></i> 댓글수</span>
				<span class="grey">${ count }</span>
			</div>
			<div id="content">
				<p class="content">
				<span id="note">🗒</span>
				${ content.content }</p>
			</div>
		</div><!-- qna-wrap -->
	</section> <!-- main-content -->
	
	<c:if test="${ not empty comment }">
		<section id="comment-content">
		<!-- #### 댓글 #### -->
			<c:forEach var="list" items="${ comment }">
			<div class="comment-card">
		 <c:if test="${ sessionScope.name == list.name}">
				<div class="comment-button-wrap">
					<i class="fa-solid fa-pen pointer"></i>
					<i class="fa-solid fa-trash pointer"></i>
				</div>			
		 </c:if> 
			<div class="flex align">
				<span class="comment-author">${ list.name }</span>
				<div>
					<small class="comment-date">${ list.created_at }</small>
					<p class="comment-content">${ list.content }</p>
				</div>
				</div>
				</div>
			</c:forEach>
		</section>
	</c:if>
	
<script src="./script/ohter/header.js"></script>
</body>
</html>