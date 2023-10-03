<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
  <c:when test="${ not empty sessionScope.name }">
		<h6 class="title">UPDATE INFO</h6>
		<form method="post" action="/updateInfo" id="join-form">
		<div class="border-box flex align">
			<label for="accound-id">EMAIL</label>
			<span class="input block grey">${ sessionScope.email }</span>
		</div>
		<div class="border-box flex align">
			<label for="accound-pwd">PW</label>
			<input id="accound-pwd" type="password" name="pwd" class="input">
		</div>
		<div class="border-box flex align">
			<label for="accound-pwd-chk">PW CHECK</label>
			<input id="accound-pwd-chk" type="password" class="input">
		</div>
		<div class="border-box flex align">
			<label for="name" >NAME</label>
				<span class="input block grey">${ sessionScope.name }</span>
		</div>
		<div class="border-box flex align">
			<label for="tel">TEL</label>
			<input id="tel" value="${ sessionScope.tel }" type="text" name="tel" class="input">
		</div>
		<input type="submit" value="SUBMIT" id="join-submit" class="pointer block">
		</form>
	</c:when>
	<c:otherwise>
		<h6 class="title">CREATE ACCOUNT</h6>
		<form method="post" action="/updateInfo" id="join-form">
		<div class="border-box">
			<label for="accound-id">EMAIL</label>
			<input id="accound-id" type="text" name="email">
		</div>
		<div class="border-box">
			<label for="accound-pwd">PW</label>
			<input id="accound-pwd" type="password" name="pwd">
		</div>
		<div class="border-box">
			<label for="accound-pwd-chk">PW CHECK</label> <input
				id="accound-pwd-chk" type="password">
		</div>
		<div class="border-box">
			<label for="name" >NAME</label>
			<input id="name" type="text" name="name">
		</div>
		<div class="border-box">
			<label for="tel">TEL</label>
			<input id="tel" type="text" name="tel">
		</div>
		<input type="submit" value="JOIN US" id="join-submit" class="pointer">
		</form>
	</c:otherwise>
</c:choose>