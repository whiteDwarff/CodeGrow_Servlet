<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CodeGrow || LOGIN</title>
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<script type="module">
import { failedLoginInfo } from "./script/member/index.js";
failedLoginInfo("${msg}");
</script>
</head>
<body>
<%@include file="../common/header.jsp"%>
	<section>
		<div class="wrapper">
	
		<article id="login">
			<div class="form-wrapper">
				<span class="title">LOGIN</span>
				<form method="post" action="/login" id="login-form">
					<div class="border-box">
						<label for="login-id">EMAIL</label>
						<input id="login-id" type="text" name="email">
					</div>
					<div class="border-box">
						<label for="login-pwd">PW</label>
						<input id="login-pwd" type="password" name="pwd">
					</div>
						<input type="submit" id="login-button" value="SIGN IN">
				</form>
			</div>
		</article>
		
		<article id="account">
			<div class="form-wrapper">
			<h6 class="title">CREATE ACCOUNT</h6>
				<form method="post" action="/join" id="join-form">
					<%@include file="./account.jsp"%>
					<input type="submit" value="JOIN US" id="join-submit" class="pointer">
				</form>
			</div>
		</article>
		
		</div>
	</section>
<script src="./script/ohter/header.js"></script>
<script type="module">
import { submitLoginInfo, submitAccountInfo } from "./script/member/index.js";
submitLoginInfo();
submitAccountInfo();
</script>
</body>
</html>