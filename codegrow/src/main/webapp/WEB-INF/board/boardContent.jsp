<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>CodeGrow || Q&A</title>
<script src="https://kit.fontawesome.com/08a7424104.js"
	crossorigin="anonymous"></script>
<!--  jQuery, bootstrap -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js?after"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/border/boardContent.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<script type="module">
import { failedLoginInfo } from "./script/member/index.js";
failedLoginInfo("${msg}");
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<!-- 게시글 상세 내용 -->
	<section id="main-content">
		<div class="main-wrap">
			<div id="title-wrap" class="flex between align">
				<p id="content-title">❗ ${ content.title }</p>
				<c:if test="${ sessionScope.name == content.name }">
					<div>
						<a href="/boardInsert?id=${ content.id }">
							<i class="fa-solid fa-pen pointer"></i>
						</a>
						<a href="/boardDelete?id=${ content.id }">
							<i class="fa-solid fa-trash pointer"></i>
						</a>
					</div>
				</c:if>
			</div>
			<div class="qna-wrap flex">
				<span class="guide grey">
					<i class="fa-solid fa-user grey"></i>작성자
				</span>
				<span class="grey"> ${ content.name }</span>
			</div>
			<div class="qna-wrap flex">
				<span class="guide grey">
					<i class="fa-solid fa-calendar-days grey"></i>작성일
				</span>
				 <span class="grey">${ content.created_at }</span>
			</div>
			<div class="qna-wrap flex">
				<span class="guide grey">
					<i class="fa-solid fa-play grey"></i>조회수
				</span>
				<span class="grey">${content.hit }</span>
			</div>
			<div id="last-wrap" class="qna-wrap flex">
				<span class="guide grey">
					<i class="fa-solid fa-check grey"></i>댓글수
				</span> 
				<span class="grey">${ count }</span>
			</div>
			<div id="content">
				<p class="content">
					<span id="note" th:utext>${content.content}</span>
				</p>
			</div>
		</div>
		<!-- qna-wrap -->
	</section>

	<!--  댓글 작성 -->
	<section id="add-content">
		<div class="add-content-wrap flex">
			<span class="guide grey">COMMENT</span>
			<form class="flex align-top" method="post" action="/insertComment">
				<c:if test="${ empty sessionScope.name }">
					<textarea disabled class="grey bold">로그인 후 댓글을 작성할 수 있습니다.</textarea>
				</c:if>
				<c:if test="${ not empty sessionScope.name }">
					<textarea name="comment"></textarea>
				</c:if>
				<input value="${ content.id }" name="post_id" class="none" />
				<button class="submit-button pointer block bold">SUBMIT</button>
			</form>
		</div>
	</section>

	<!-- 댓글 -->
	<c:if test="${ not empty comment }">
		<section id="comment-content">
			<c:forEach var="list" items="${ comment }">
				<div class="comment-card ">
					<div class="flex align margin-bottom">
						<!--  date, i 버튼 box -->
						<small class="comment-date guide">${ list.created_at }</small>
						<c:if test="${ sessionScope.name == list.name }">
							<div class="comment-button-wrap">
								<!-- 댓글 수정 버튼 -->
								<i class="fa-solid fa-pen pointer update-button"></i>
								<!-- 댓글 삭제 버튼 -->
								<a
									href="/updateComment?comment_id=${list.id }&board_id=${ content.id  }">
									<i class="fa-solid fa-trash pointer"></i>
								</a>
							</div>
						</c:if>
					</div>

					<div class="flex align-top">
						<!-- comment content (이름, 내용, hidden-form -->
						<span class="comment-author guide grey">${ list.name }</span>
						<c:if test="${ sessionScope.name == list.name}">
						<p class="comment-content author-content">${ list.content }</p>
						<form class="flex align-top update-form none" method="post"
							action="/updateComment">
							<textarea name="comment">${ list.content }</textarea>
							<!-- 댓글의 ID -->
							<input value="${ list.id }" name="comment_id" class="none" />
							<!-- 게시글의 ID -->
							<input value="${ content.id }" name="board_id" class="none" />
							<button class="submit-button bold block pointer">UPDATE</button>
						</form>
						</c:if>
						<!-- 댓글의 작성자와 현재 로그인한 회원의 이름이 다른 경우 -->
						<c:if test="${ sessionScope.name != list.name }">
							<p class="comment-content">${ list.content }</p>
						</c:if>
					</div>
				</div>
	</c:forEach>
	</section>
	</c:if>

	<script src="./script/ohter/header.js"></script>
	<script type="module">
import { updateComment } from "./script/board/boardContent.js"
updateComment();

</script>
</body>
</html>