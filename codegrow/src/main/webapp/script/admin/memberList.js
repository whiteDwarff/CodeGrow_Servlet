function userLankhandelr() {
	// optgroup
	const opt = document.getElementsByClassName('optgroup');
	// 현재 사용자의 등급
	const selectOption = document.getElementsByClassName('selected-option');
	
	for(let i=0; i<opt.length; i++) {
		// option 태그 (HTML Collection으로 배열로 넘어옴)
		const option = opt[i].getElementsByTagName('option');
		
		for(let j=0; j<option.length; j++) 
			if(option[j].value == selectOption[i].value) option[j].remove();
	}
}

function deleteUserHandler() {
	const deleteBtn = document.getElementsByClassName('delete-user-btn');
	for(let i=0; i<deleteBtn.length; i++) {
		deleteBtn[i].addEventListener('click', e => {
			if(!confirm('회원을 탈퇴시키겠습니까?')) 
				e.preventDefault();
		})
	}
}
export {
	userLankhandelr,
	deleteUserHandler,
}