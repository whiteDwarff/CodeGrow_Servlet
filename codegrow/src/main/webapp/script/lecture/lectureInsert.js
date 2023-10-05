function addVideoLink() {
		const link = document.getElementById('link');
		const video = document.getElementById('video');
		const addBtn = document.getElementById('add-button');
		addBtn.addEventListener('click', () => {
			video.src = "https://img.youtube.com/vi/"+link.value+"/maxresdefault.jpg";
		})
}		

function charControl(content, length, msg) {
	if(content.value.trim().length > length) {
		content.value = content.value.slice(0, -1);
		alert(msg)
	}
}

function inputLengthHandler(){
	const input = document.getElementsByClassName('content-input');
	const count = document.getElementsByClassName('content-count');
		
	for(let i=0; i<input.length; i++) {
		let length = [30, 50]
		input[i].addEventListener('keydown', e => {
			if(!i)
				charControl(input[0], length[i], '최대 30글자까지 입력할 수 있습니다.')
			else 
				charControl(input[i], length[i], '최대 50글자까지 입력할 수 있습니다.')
					
			count[i].innerText = '';
			count[i].innerText = `${e.target.value.length} / ${length[i]}`
			})
		}
}

function submit() {
	const updateForm = document.getElementById('update-form');
	const content = document.getElementsByClassName('input');
	let isEmptyContent = false;
		
	updateForm.addEventListener('submit', e => {		
		for(let i=0; i<content.length; i++) {
			if(!content[i].value) {
				e.preventDefault();
				content[i].focus();
				isEmptyContent = false
				} else isEmptyContent = true;
				
		}
		if(!isEmptyContent) {
			alert('빈칸을 모두 입력해주세요.');
			isEmptyContent = false
			}	
		})
}
export {
	addVideoLink,
	inputLengthHandler,
	submit,
}