<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
footer {
	height: 10rem;
  background-color: rgb(244, 244, 244);;
}
.footer-wrap {
	width: 60%;
	margin: 0 auto;
}
#main-logo {
	width: 1.5rem;
	height: 1.5rem;
	 margin-right: 1rem; 
}

#admin-info {
	width: 50%;
	margin-top: 2.5rem;
}
#admin-info p {
margin-top: 5px;
}
#footer-logo-wrap {
	margin-top: 4rem;
}
#footer-logo-wrap a{
	margin-left: 2rem;
	padding: 1rem;
	background-color: #333;
	border-radius: 50%;
}
#footer-logo-wrap a i {
	display: inline-block;
	margin: auto 0;
	font-size: 1rem;
	color: #fff;
	font-weight: bold;
}
#admin-info p {
	margin-bottom: 0;
}
</style>
<footer id="footer">
	<div class="footer-wrap flex between font">
		<div id="admin-info" class="">
			<div class="flex align" id="footer-main">
				<a href="/index"> <img id="main-logo"
					src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Circle-icons-dev.svg/1024px-Circle-icons-dev.svg.png">
				</a> <span>Welcome to CodeGrow !</span>
			</div>
			<p>제작 및 기획: 강문호 | 전화번호: 010-8637-1685</p>
			<p>이메일: rkdans113@naver.com | 깃허브: https://github.com/whiteDwarff</p>
			<p>주소: 부산광역시 부산진구 부전동</p>
		</div>
		<div id="footer-logo-wrap" class="flex align">
			<a href=""> <i class="fa-solid fa-phone"></i>
			</a> <a href=""> <i class="fa-regular fa-envelope"></i>
			</a> <a href="https://github.com/whiteDwarff"> <i
				class="fa-brands fa-github"></i>
			</a> <a href=""> <i class="fa-brands fa-instagram"></i>
			</a>
		</div>
	</div>
</footer>
