import { 
	validateEmail,
	validatePwd } from './validation.js';
	
function submitLoginInfo() {
	document.getElementById('login-form').addEventListener('submit', e => {
		let id = document.getElementById('login-id');
		let pwd = document.getElementById('login-pwd');
		if(!validateEmail(id.value)) {
			e.preventDefault();
			alert('올바른 이메일 형식이 아닙니다.');
			id.focus();
		} else if(!validatePwd(pwd.value)) {
			e.preventDefault();
			alert('비밀번호는 대문자와 특수문자, 숫자를 포함한 8-15자 이내로 입력해주세요.');
			pwd.focus();
		}
	});
}
function submitAccountInfo() {
	document.getElementById('join-form').addEventListener('submit', e => {
		let id = document.getElementById('accound-id');
		let pwd = document.getElementById('accound-pwd');
		let check = document.getElementById('accound-pwd-chk');
		let name = document.getElementById('name');
		let tel = document.getElementById('tel');
		
		if(!validateEmail(id.value)) {
			e.preventDefault();
			alert('올바른 이메일 형식이 아닙니다.');
			id.focus();
		} else if(!validatePwd(pwd.value)) {
			e.preventDefault();
			alert('비밀번호는 대문자와 특수문자, 숫자를 포함한 8-15자 이내로 입력해주세요.');
			pwd.focus();
		} else if(pwd.value != check.value) {
			e.preventDefault();
			alert('비밀번호가 일치하지 않습니다.');
			check.focus();
		} else if(!name.value || name.value === '') {
			e.preventDefault();
			alert('이름을 입력해주세요.');
			name.focus();
		} else if(!tel.value || tel.value === '') {
			e.preventDefault();
			alert('비밀번호를 입력해주세요.');
			tel.focus();
		}
	})
}
function failedLoginInfo(msg) {
	return msg ? alert(msg) : '';
}
export {
	submitLoginInfo,
	submitAccountInfo,
	failedLoginInfo,
}
