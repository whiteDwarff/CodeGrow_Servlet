function insertBoard() {
	const submitFrom = document.getElementById('insert-form');
	const title = document.getElementById('title');
	const content = document.getElementById('content');
	
	submitFrom.addEventListener('submit', e => {
		console.log(content.value)
		if(!title.value) {
			e.preventDefault();
			alert('제목을 입력해주새요.');
			title.focus();
		} else if(!content.value || content.value == '') {
			e.preventDefault();
			alert('내용을 입력해주세요.');
			content.focus();
		}
	})
}
function summerNote() {
		$('.summernote').summernote({
        // 에디터 높이
        height: 500,
        minHeight: 500,             // 최소 높이
        maxHeight: 500,             // 최대 높이
        // 이미지 크기 제한 설정
         imageMaxSize: [400, 350], // 이미지 최대 가로 및 세로 크기
         imageResizeToOriginal: false, // 이미지 원본 크기 유지 여부
        // 에디터 한글 설정
        lang: "ko-KR",
        // 에디터에 커서 이동 (input창의 autofocus라고 생각하시면 됩니다.)
        focus : true,
        toolbar: [
             // 글꼴 설정
             ['fontname', ['fontname']],
             // 글자 크기 설정
             ['fontsize', ['fontsize']],
             // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
             ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
             // 글자색
             ['color', ['forecolor','color']],
             // 표만들기
             ['table', ['table']],
             // 글머리 기호, 번호매기기, 문단정렬
             ['para', ['ul', 'ol', 'paragraph']],
             // 줄간격
             ['height', ['height']],
             // 그림첨부, 링크만들기, 동영상첨부
             ['insert',['picture','link','video']],
           ],
           // 추가한 글꼴
         fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
          // 추가한 폰트사이즈
         fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
      });
}
export {
	insertBoard,
	summerNote,
}