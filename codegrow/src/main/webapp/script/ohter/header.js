const headerImage = document.getElementsByClassName('header-image'),
			headerWrap = document.getElementsByClassName('header-slide-wrap'),
			section = document.getElementsByTagName('section'),
			headerSerachFrom = document.getElementById('header-search-form'),
			header = document.getElementsByTagName('header')[0],
			headerSearchInput = document.getElementById('header-search-input');
let isHeaderState = true;

for(let i=0; i<headerImage.length; i++) {
	headerImage[i].addEventListener('click', () => {
		
		for(let item of headerWrap) item.classList.remove('block')
		
		if(isHeaderState) {
			headerWrap[i].classList.add('block');
			for(let item of section) item.style.filter = 'blur(7px)';
		} else {
			headerWrap[i].classList.remove('block');
			isHeaderState = false;
			for(let item of section) item.style.filter = 'none';
		}
		isHeaderState = !isHeaderState;
	})
}
const logout = document.getElementById('logout');
if(logout)
	logout.addEventListener('click', e => {
		return confirm('로그아웃 하시겠습니까?') ? alert('로그아웃 되었습니다.') : e.preventDefault();
	})