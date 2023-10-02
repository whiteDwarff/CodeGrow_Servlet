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
}
export {
	updateComment,
}