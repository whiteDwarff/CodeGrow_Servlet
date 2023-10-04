		const link = document.getElementById('link');
		const video = document.getElementById('video');
		const addBtn = document.getElementById('add-button');
		addBtn.addEventListener('click', () => {
			video.src = "https://img.youtube.com/vi/"+link.value+"/maxresdefault.jpg";
		})
		
		
		
		const description = document.getElementById('description');
		const count = document.getElementById('count');
		description.addEventListener('keydown', e => {
			if(e.target.value.trim().length > 50) {
				 e.target.value = e.target.value.slice(0, -1);
				 alert('최대 50글자까지 입력할 수 있습니다.')
			}
			count.innerText = "";
			count.innerText = e.target.value.length + " / 50";
		})