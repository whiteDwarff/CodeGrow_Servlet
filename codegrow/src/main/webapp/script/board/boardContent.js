function updateComment() {
	const updateButton = document.getElementsByClassName('update-button');
	const updateForm = document.getElementsByClassName('update-form');
	const content = document.getElementsByClassName('author-content');
	
	if(updateButton) {
		for(let i=0; i<updateButton.length; i++) {
			updateButton[i].addEventListener('click', () => {
				if (!updateForm[i].classList.contains('none')) {
					updateForm[i].classList.add('none');
					content[i].classList.remove('none');
				} else {
				updateForm[i].classList.remove('none');
				content[i].classList.add('none');
				}
			})
		}
	}
	for(let i=0; i<updateForm.length; i++) {
		let input = document.querySelectorAll('.update-form textarea');
		addComment(updateForm[i], input[i]);
	}
}
function deleteComment() {
	const deleteButton = document.getElementsByClassName('delete-button');
	for(let i=0; i<deleteButton.length; i++) {
		deleteButton[i].addEventListener('click', e => {
			if(!confirm('댓글을 삭제하시겠습니까?')) e.preventDefault();
		})
	}
}
function submitComment() {
	const addCommentForm = document.getElementById('add-comment');
	const input = document.querySelector('#add-comment textarea');
	addComment(addCommentForm, input);
}
function addComment(form, input) {
	form.addEventListener('submit', e => {
		if(!input.value) {
			e.preventDefault();
			alert('댓글을 입력해주세요');
			input.focus();
		}
	})
}
export {
	updateComment,
	deleteComment,
	submitComment,
}