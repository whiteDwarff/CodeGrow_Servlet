<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code Grow</title>
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/main/index.css">
<script type="module">
import { failedLoginInfo } from "./script/member/index.js";
failedLoginInfo("${msg}");
</script>
</head>
<body>

<%@include file="./common/header.jsp"%>
<section>
	<!-- category -->
	<c:forEach var="category" items="${ category }">
	<article id=${ category.name } class="relative">
		<h2 class="h2-title">${ category.discription }</h2>
		<div class="scroll-box">
				<i class="fa-solid fa-chevron-left scroll-img left none"></i>
				<i class="fa-solid fa-chevron-right scroll-img right"></i>
				<div class="card-wrap">
					<div class="url-card background-none"></div>
						<!-- video -->
						<c:forEach var="video" items="${videos}">
						<c:if test="${ category.id == video.category_id }">
						<div class="url-card">
						<a href="/education?id=${ video.id }&group=${ video.category_id }">
							<span class="url-title">${ video.title }</span>
							<span class="url-content">${ video.description }</span>
							<embed controls=0
								src="https://img.youtube.com/vi/${ video.url }/maxresdefault.jpg"
								allowfullscreen></embed>
						</a>
					</div>
						</c:if>
						</c:forEach>
				</div>
			</div>
	</article>
	</c:forEach>
</section>

	<%@include file="./common/footer.jsp"%>

<script src="./script/ohter/header.js"></script>
<script src="./script/index.js"></script>

</body>
</html>