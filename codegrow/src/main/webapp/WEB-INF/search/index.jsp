<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/search/index.css">
</head>
<body>
<!-- search -->
<%@include file="../common/header.jsp"%>

<section id="card-box">
		<article class="wrap">
		<c:forEach var="video" items="${ videos }">
			<div class="url-card">
					<a href="/education?id=${ video.id }&group=${ video.category_id }">
						<span class="url-title">${ video.title }</span>
						<span class="url-content">${ video.description }</span>
						<embed controls=0
						src="https://img.youtube.com/vi/${ video.url }/maxresdefault.jpg"
						allowfullscreen></embed>
				</a>
			</div>
			</c:forEach>
		</article>
	</section>
	
<script src="./script/ohter/header.js"></script>
</body>
</html>