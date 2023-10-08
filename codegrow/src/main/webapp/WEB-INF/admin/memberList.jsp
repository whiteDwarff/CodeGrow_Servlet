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
<link rel="stylesheet" href="./css/admin/memberList.css">
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<section id="board-section">
		<article class="board-list">
			<!-- 게시판 정렬 옵션 -->
			<form method="get" action="/memberList" id="align-option">
				<select name="select" onchange="this.form.submit()">
					<option value="DESC" selected class="align-option">최신순</option>
					<option value="ASC" class="align-option">오래된순</option>
				</select>
			</form>
		
			<table class="table table-hover">
				<tr class="post-item">
					<th class="user-number">번호</th>
					<th class="user-name">이름</th>
					<th class="user-email">이메일</th>
					<th class="user-tel">휴대폰번호</th>
					<th class="user-reg">가입일</th>
					<th class="user-rank">등급</th>
				</tr>

				<c:forEach var="user" items="${ users }">
					<tr>
						<td class="user-number">${ user.id }</td>
						<td class="user-name">${ user.name }</td>
						<td class="user-email">${ user.email }</td>
						<td class="user-tel">${ user.tel }</td>
						<td class="user-reg">${ user.regDate }</td>
						<td class="user-rank">
							<c:if test="${ user.rank ne 'O' }">
							<div class="flex center align">
								<select name="rank" class="rank-option">
									<c:choose>
										<c:when test="${ user.rank == 'B' }">
											<option value="${ user.rank }">Student</option>
										</c:when>
										<c:when test="${ user.rank == 'T' }">
											<option value="${ user.rank }">Teacher</option>
										</c:when>
										<c:otherwise>
											<option value="${ user.rank }">Owner</option>
										</c:otherwise>
									</c:choose>

									<optgroup label="--선택옵션--">
										<option value="B">Student</option>
										<option value="T">Teacher</option>
										<option value="O">Owner</option>
									</optgroup>
								</select>
								<a href="#">탈퇴</a>
							</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</article>
	</section>

	<section id="ohter">
		<c:if test="${ not empty startNum && not empty numOfPages}">
			<!-- #### pageNation #### -->
			<div id="page-nation" class="flex center">
				<ul class="flex">
					<a href="/memberList?p=${p - 1}" id="prev"> <i
						class="fa-solid fa-chevron-left"></i>
					</a>
					<c:forEach var="i" begin="${startNum}"
						end="${startNum + numOfPages - 1}" step="1">
						<c:if test="${i <= lastNum}">
							<a href="/memberList?select=${ option }&p=${i}" class="page-num">${i}</a>
						</c:if>
					</c:forEach>
					<a href="/memberList?p=${p+1}" id="next"> <i
						class="fa-solid fa-chevron-right"></i>
					</a>
				</ul>
			</div>
			<!-- ########## -->
		</c:if>

		<form method="post" action="/memberList" id="search-form" class="flex">
			<input type="text" name="content" id="form-value"
				placeholder="회원명을 입력하세요">
			<button id="search-button" class="none">검색</button>
		</form>
	</section>
	<%@include file="../common/footer.jsp"%>

	<script type="module">
  import { 
		currentPaging,
		hiddenPrevButton,
		searchBoardList,
		hiddenNextButton,
		selectOptionHandelr,
} from "./script/board/boardList.js";	

		const pageValue = ${p};
		const lastValue = '${lastNum}';
		const option = '${option}';	
		if(lastValue) {
  		currentPaging(pageValue); 
			hiddenPrevButton(pageValue);
			searchBoardList();
			hiddenNextButton(pageValue, lastValue)
			selectOptionHandelr(option);
		}
</script>
</body>
</html>