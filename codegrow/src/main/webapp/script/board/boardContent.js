function updateComment() {
	const updateButton = document.getElementsByClassName('update-button');
	const updateForm = document.getElementsByClassName('update-form');
	
	if(updateButton) {
		
		for(let i=0; i<updateButton.length; i++) {
			console.log(updateButton[i])
			console.log(updateForm[i])
			updateButton[i].addEventListener('click', () => {
				updateForm[i].classList.remove('none');
			})
		}
	}
}
export {
	updateComment,
}