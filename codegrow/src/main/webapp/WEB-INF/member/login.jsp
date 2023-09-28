<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMUNITY || LOGIN</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
${loginGuide}
${createAccount}
	<h3><a href="index.jsp">LOGO</a></h3>
	<section>
		<div class="wrapper">
	
		<article id="login">
			<div class="form-wrapper">
				<span class="title">LOGIN</span>
				<form method="post" action="/user/login">
					<div class="border-box">
						<label for="login-id">EMAIL</label>
						<input id="login-id" type="text" name="email">
					</div>
					<div class="border-box">
						<label for="login-pwd">PW</label>
						<input id="login-pwd" type="password" name="pwd">
					</div>
					<div class="flex-box">
					<div id="submit-box">
						<p>
							<input id="cookie" type="checkbox" name="cookie">
							<label for="cookie" class="inline">REMEMBER ME</label>
						</p>
						<input type="submit" id="login-button" value="SIGN IN">
					</div>
				</div>
				</form>
				<div id="find-member-info">
					<a href="#">Did You Forget Your Id</a> 
					<span class="bold inline">Or</span>
					<a href="#">Password?</a> 
				</div>
			</div>
		</article>
		
		
		<article id="account">
			<div class="form-wrapper">
			<h6 class="title">CREATE ACCOUNT</h6>
				<form method="post" action="/member/signUp">
					<div class="border-box">
						<label for="accound-id">EMAIL</label>
						<input id="accound-id" type="text" name="email">
					</div>
					<div class="border-box">
						<label for="accound-pwd">PW</label>
						<input id="accound-pwd" type="password" name="pwd">
					</div>
					<div class="border-box">
						<label for="accound-pwd-chk">PW CHECK</label>
						<input id="accound-pwd-chk" type="password">
					</div>
					<div class="border-box">
						<label for="name">NAME</label>
						<input id="name" type="text" name="name">
					</div>
					<div class="border-box" id="tel">
						<label>TEL</label>
						<input type="text" name="tel">
					</div>
					<input type="submit" value="JOIN US">
				</form>
			</div>
		</article>
		</div>
		
	</section>
	<h1><a href="index.jsp">LOGO</a></h1>
</body>
</html>