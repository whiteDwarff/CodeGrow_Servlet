function currentVideo() {
	const mainTitle = document.getElementsByClassName('url-title')[0];
	const subTitle = document.getElementsByClassName('sub-url-title');

	for (let i = 0; i < subTitle.length; i++) {
		let subList = document.getElementsByClassName('sub-list');
		if (subTitle[i].innerText == mainTitle.innerText) {
			subList[i].style.backgroundColor = 'rgb(235 235 235)';
			break;
		}
	}
}
function addWishList(value, state) {
	const wishBtn = document.getElementById('addToFavoritesBtn');
	let finalState = state;
	wishBtn.addEventListener('click', function() {
		try {
			let id = value.toString();
				fetch('/wish', {
					method: 'POST',
					headers: {
						'Content-Type': 'application/json;charset=utf-8'
					},
					body: JSON.stringify({id}),
			})
			.then(() => {
				// 관심목록에 해당 강의가 없는 경우 ( 관심목록 추가 )
				if(!finalState) {
					finalState = 1;
					wishBtn.innerHTML = '관심목록 제거 <i class="fa-solid fa-minus add"></i>';
					if(confirm('관심목록으로 이동하겠습니까?')) location.href='/search';
				// 관심목록에 해당 강의가 있는 경우 ( 관심목록 제거 )
				} else if(state) {
						finalState = 0;
						wishBtn.innerHTML = '관심목록 추가 <i class="fa-solid fa-plus add"></i>';
						alert('관심목록에서 제거되었습니다');
				} 
			})
			// 실패한 경우
			.catch(err => {
				alert('잠시 후 다시 시도해주세요.');
				console.log(err.message);
			})
			// 관심목록을 추가했을 때
			/*
			if(!finalState) {
				finalState = 1;
				wishBtn.innerHTML = '관심목록 제거 <i class="fa-solid fa-minus add"></i>';
				if(confirm('관심목록으로 이동하겠습니까?')) location.href='/search';
			// 관심목록을 제거했을 때 
			} else if(state) {
					finalState = 0;
					wishBtn.innerHTML = '관심목록 추가 <i class="fa-solid fa-plus add"></i>';
					alert('관심목록에서 제거되었습니다');
			// 실패한 경우
			} else alert('잠시 후 다시 시도해주세요');
			*/
			
		} catch (err) {
			alert('서버와의 통신이 원활하지 않습니다.');
		}
	})
}
export {
	currentVideo,
	addWishList,
}