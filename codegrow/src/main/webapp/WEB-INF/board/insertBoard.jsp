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
	${ content }
		<c:if test="${ not empty  content }">
			<form method="post" action="/boardUpdate">
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
				<input type="text" value="${ pm }" name="param">
				<input type="submit" id="submit-button" class="pointer block bold" value="UPDATE">
			</form>
		</c:if>
		
		<c:if test="${ empty content }">
			<form method="post" action="/boardInsert">
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
				<!-- <div>
					<label for="file">FILE</label>
					<input type="file" id="file" name="file"></input>
				</div> -->
				<input type="submit" id="submit-button" class="pointer block bold" value="SUBMIT">	
			</form>
		</c:if>
	</section>

	<script src="./script/ohter/header.js"></script>
	<script>
	$('.summernote').summernote({
        // 에디터 높이
        height: 500,
        minHeight: 500,             // 최소 높이
        maxHeight: 500,             // 최대 높이
        // 이미지 크기 제한 설정
         imageMaxSize: [400, 350], // 이미지 최대 가로 및 세로 크기
         imageResizeToOriginal: false, // 이미지 원본 크기 유지 여부
        // 에디터 한글 설정
        lang: "ko-KR",
        // 에디터에 커서 이동 (input창의 autofocus라고 생각하시면 됩니다.)
        focus : true,
        toolbar: [
             // 글꼴 설정
             ['fontname', ['fontname']],
             // 글자 크기 설정
             ['fontsize', ['fontsize']],
             // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
             ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
             // 글자색
             ['color', ['forecolor','color']],
             // 표만들기
             ['table', ['table']],
             // 글머리 기호, 번호매기기, 문단정렬
             ['para', ['ul', 'ol', 'paragraph']],
             // 줄간격
             ['height', ['height']],
             // 그림첨부, 링크만들기, 동영상첨부
             ['insert',['picture','link','video']],
           ],
           // 추가한 글꼴
         fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
          // 추가한 폰트사이즈
         fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
      });
	</script>
</body>
</html>