![header](https://capsule-render.vercel.app/api?type=waving&color=timeGradient&text=웹개발자%20성장을%20위한%20동영상%20RoadMap%20프로그램%20설계%20및%20구현🚀&animation=twinkling&fontSize=23&fontAlignY=40&fontAlign=60&height=250&width=1325&align=center)

<br>
<br>
 <div align="center">
  <img src="https://img.shields.io/badge/Java-4B4B77?style=flat&logo=java&logoColor=white"/>
   <img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=flat&logo=Apache Tomcat&logoColor=black"/>
  <img src="https://img.shields.io/badge/MariaDB-003545?style=flat&logo=MariaDB&logoColor=white"/>
  <img src="https://img.shields.io/badge/html-E34F26?style=flat&logo=html5&logoColor=white"/>
  <img src="https://img.shields.io/badge/css-1572B6?style=flat&logo=css3&logoColor=white"/>
 </div>
<br><br>

## 🙇🏻‍♂️ 프로젝트 소개
CodeGrow는 웹 개발자들의 성장을 위해 제작된 온라인 학습 플렛폼 입니다.<br>
*해당 프로젝트는 2023년 2학년 1학기 MVC1으로 구현한 CodeGrow를 MVC2 디자인 패턴으로 리펙토링하며 다양한 기능을 추가하여 제작하였습니다.*

<br><br>

## 🙋🏻 개요
저는 예술고등학교 미술과에 입학한 후 대학에서 의상디자인을 전공하였고 긴 시간 직장 생활을 하며 지내던 중
웹 개발에 흥미가 생겨 컴퓨터학과로 다시 입학하게 되었습니다. <br>그러나 새로운 전공 공부가 어려워서 여러 번이나 포기하고 싶다는 생각을 했던 적이 있습니다.<br>
지금 돌아보면, 웹 개발자로 나아가기 위한 명확한 로드맵과 소통공간이 부족해서 방황한 경험이 큰 역할을 했던 것 같습니다.<br>
다양한 사람들이 기초부터 천천히 배우며 조금씩 습득하고, 어려운 부분이나 이해가 가지 않는 문제를 도움을 구하며 소통할 수 있는 장소가 필요하다고 느껴서, 이 프로젝트를 기획하게 되었습니다.

<br><br>

## 🛠️ Tech
**1. MVC2 Design Pattern**<br>
**2. MariaDB**<br>
**3. Tomcat**<br>
**4. HTML / CSS**<br>
**5. JavaScript**<br>
**6. fontAssome**<br>
**7. fetchAPI**<br>
**8. SummerNote**<br>



<br><br>

## ❗️ Function
**1. 회원가입 및 로그인**<br>
 >*사용자는 회원가입을 통해 CodeGrow에 가입하고, 로그인하여 자신의 계정으로 접속할 수 있습니다* <br>
 
**2. 강의 컨텐츠**<br>
 >*다양한 웹 개발 관련 강의를 제공하며, 사용자는 강의를 선택하여 수강할 수 있습니다.* <br>
 
**3. 질문과 답변**<br>
 >*사용자들은 질문과 답변 게시판을 통해 서로 도움을 주고 받을 수 있으며, 지식을 공유할 수 있습니다.* <br>
 
**4. 공지사항**<br>
 >*운영자는 공지사항 게시판을 통해 학습자들에게 중요한 정보와 업데이트 사항을 공지할 수 있습니다.*<br>

**5. 강의관리**<br>
 >*사용자의 등급이 Teacher인 경우 강의를 등록 및 수정할 수 있습니다.*<br>

**6. 회원관리**<br>
 >*사용자의 등급이 Owner인 경우 회원등급 관리 및 탈퇴시킬 수 있습니다.*<br>

<br><br>

## 💿 Database
**1. Member**<br> 
>*사용자의 정보가 저장된 테이블*<br>

| Column     | DataType            | NotNull | Default           | Description        | Key    |
|------------|---------------------|---------|-------------------|--------------------|--------|
| id         | int(11)             |   O     |         X         | 사용자의 고유 값  | Primary     |
| name       | varchar(15)         |   O     |         X         | 사용자의 이름    | |
| email      | varchar(30)         |   O     |         X         | 사용자의 이메일    | |
| password   | varchar(255)        |   O     |         X         | 사용자의 비밀번호   |  |
| phone_number | int(15)           |   X     |         X          | 사용자의 휴대폰 번호 |  |
| created_at | timestamp           |   O     |  current_timestamp | 가입일     | |
| rank      | varchar(1)           |   O     |       B       | 사용자의 등급    |  |

<br>

**2. Board**<br> 
>*사용자의 문의사항이 저장된 테이블*<br>

| Column     | DataType            | NotNull | Default           | Description        | Key    |
|------------|---------------------|---------|-------------------|--------------------|--------|
| id         | int(11)             |   O     |         X         | 게시글의 고유 값  | Primary     |
| title      | varchar(255)        |   O     |         X         | 게시글의 제목    | |
| content    | longtext            |   O     |         X         | 게시글의 내용    | |
| created_at | timestamp           |   X     | current_timestamp | 작성일         |  |
| hit        | int(4)              |   O     |       0           | 게시글의 조회수  |  |
| author_id  | int(11)             |   O     |         X         | 게시글 작성자    | Foreign |

<br>

**3. Notice**<br> 
>*관리자의 공지사항이 저장된 테이블*<br>

| Column     | DataType            | NotNull | Default           | Description        | Key    |
|------------|---------------------|---------|-------------------|--------------------|--------|
| id         | int(11)             |   O     |         X         | 게시글의 고유 값  | Primary     |
| title      | varchar(255)        |   O     |         X         | 게시글의 제목    | |
| content    | longtext            |   O     |         X         | 게시글의 내용    | |
| created_at | timestamp           |   X     | current_timestamp | 작성일         |  |
| hit        | int(4)              |   O     |       0           | 게시글의 조회수  |  |
| author_id  | int(11)             |   O     |         X         | 게시글 작성자    | Foreign |

<br>

**4. Comment**<br> 
>*게시글의 댓글이 저장된 테이블*<br>

| Column     | DataType            | NotNull | Default           | Description        | Key    |
|------------|---------------------|---------|-------------------|--------------------|--------|
| id         | int(11)             |   O     |         X         | 댓글의 고유 값  | Primary     |
| content    | longtext            |   O     |         X         | 댓글의 내용    | |
| created_at | timestamp           |   X     | current_timestamp | 작성일         |  |
| post       | int(11)             |   O     |         X         | 게시글의 고유 값 | Foreign |
| author_id  | int(11)             |   O     |         X         | 댓글 작성자     | Foreign |

<br>

**5. category**<br> 
>*동영상의 카테고리 정보가 저장된 테이블*<br>

| Column     | DataType            | NotNull | Default           | Description        | Key    |
|------------|---------------------|---------|-------------------|--------------------|--------|
| id         | int(11)             |   O     |         X         | 카테고리의 고유 값 | Primary     |
| discription | varchar(50)        |   O     |         X         | 카테고리의 설명   | |
| created_at | timestamp           |   X     | current_timestamp | 생성일         |  |

<br>

**6. video**<br> 
>*동영상의 정보가 저장된 테이블*<br>

| Column     | DataType            | NotNull | Default           | Description        | Key    |
|------------|---------------------|---------|-------------------|--------------------|--------|
| id         | int(11)             |   O     |         X         | 동영상의 고유 값  | Primary     |
| title      | varchar(60)         |   O     |         X         | 동영상의 내용     | |
| description |  varchar(150)      |   O     |         X         | 작성일          |  |
| url        | varchar(50)         |   O     |         X         | 동영상의 url 정보 |  |
| hit  | int(4)                    |   O     |         0         | 동영상의 조회수    |  |
| uploader_id  | int(11)           |   O     |         X         | 작성자         | Foreign |
| uploaded_at  | timestamp         |   O     |  current_timestamp| 작성일         | Foreign |
| category_id  | int(11)           |   O     |         X         | 카테고리 정보    | Foreign |

<br>

**7. wish**<br> 
>*사용자가 관심목록으로 저장한 동영상 정보가 저장된 테이블*<br>

| Column     | DataType            | NotNull | Default           | Description        | Key    |
|------------|---------------------|---------|-------------------|--------------------|--------|
| id         | int(11)             |   O     |         X         | 관심목록의 고유 값      |Primary|
| video_id   | int(11)             |   O     |         X         | 비디오의 고유값        |Foreign|
| member_id  | int(11)             |   O     |         X         | 사용자의 고유값        |Foreign|

<br><br>

## 🖥️ Views
**1. index**<br> 
 - 프로젝트의 메인화면입니다. 헤더의 사람 아이콘을 클릭하여 로그인 및 회원가입 할 수 있습니다.
 - 동영상은 카테고리별로 분류되어 있으며, 슬라이드 형식으로 배치하였습니다.
 - 동영상을 클릭하면 education 페이지로 이동할 수 있습니다.
<img width="1446" alt="index" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/0d7b144a-8883-4982-9712-0bd8d2a8e080">




<br><br>

 **2. Login / Join**<br> 
 - 로그인 및 회원가입 화면입니다.
 - 로그인 및 회원가입을 완료하려면 유효성 검사를 통과해야 합니다.
 - 회원가입 폼을 재사용 가능하도록 사용자 정보 수정 시에도 활용하며, @include를 활용하여 불러왔습니다.<br>
<img width="1446" alt="join-db" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/2b35adc8-a343-4188-9e0c-71aa52e61b98">

  - password는 SHA256 알고리즘을 사용하여 암호화하여 저장하였습니다.
 
 ```ruby
  String sql = "INSERT INTO member (name, email, password, phone_number) VALUES(?,?,SHA2(?, 256),?)";
 ```
<img width="1446" alt="login" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/ea26c040-6a28-4932-8fe0-bf8001779e2c">

  - 로그인 후 Index로 이동됩니다.
<img width="1446" alt="logined" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/0f2f72df-574b-4fc3-b615-07df9c9dd98d">


<br><br>

 **3. UpdateInfo**<br> 
 - 회원가입 시 사용한 파일을 분기처리하여 사용합니다.
 - 수정한 password 또한 SHA256 알고리즘을 사용하여 저장됩니다.
<img width="1027" alt="update-info" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/5ceb23b0-c8d9-4a1b-a4aa-f7595c914ac1">

<br><br>

 **4. Education**<br> 
 - 강의를 시청할 수 있는 페이지 입니다.
 - 강의 우측에는 동일한 카테고리를 가진 강의가 슬라이드 형식으로 배치됩니다.
<img width="1438" alt="education" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/2d05b8f5-6100-46cd-b5de-ab0d6e2c4589">

 - 강의를 관심목록에 추가하거나 삭제할 수 있습니다.
 - 해당 기능은 ES6의 FetchAPI를 사용하였으며, ajax를 통해 JSON 데이터가 서버로 전달되어 wish 테이블에서 추가되거나 삭제됩니다.<br>
 - 🔗 [FetchAPI]  ([https://main--clinquant-twilight-679959.netlify.app/](https://developer.mozilla.org/ko/docs/Web/API/Fetch_API/Using_Fetch))
```ruby
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
 				if(!finalState) {
 					finalState = 1;
 					wishBtn.innerHTML = '관심목록 제거 <i class="fa-solid fa-minus add"></i>';
 					if(confirm('관심목록으로 이동하겠습니까?')) location.href='/search';
 				} else {
 						finalState = 0;
 						wishBtn.innerHTML = '관심목록 추가 <i class="fa-solid fa-plus add"></i>';
 						alert('관심목록에서 제거되었습니다');
 				} 
 			})
 			.catch(err => {
 				alert('잠시 후 다시 시도해주세요.');
 				console.log(err.message);
 			})
 		} catch (err) {
 			alert('서버와의 통신이 원활하지 않습니다.');
 		}
 	})
}
```

 - 동영상을 클릭하여 페이지에 들어오면 해당 동영상의 조회수가 증가하며, 클릭 후 24시간 이내에 다시 클릭하더라도 조회수가 중복으로 증가하지 않습니다.
 ```ruby
    public void videoCookie(HttpServletRequest req, HttpServletResponse resp, String id) {
     Cookie[] cookies = req.getCookies();
     if (cookies != null) {
       boolean cookieExists = false;
       for (Cookie c : cookies) 
         if (c.getName().equals("video" + id)) {
           cookieExists = true;
           break;
       }
        if (!cookieExists || cookies == null) this.addCookie(req, resp, id);
     }
    }
    public void addCookie(HttpServletRequest req, HttpServletResponse resp, String id) {
      VideoDao dao = VideoDao.getInstance();
      dao.updateHit(Integer.parseInt(id));
      Cookie cookie = new Cookie("video" + id, id);
      cookie.setMaxAge(24 * 60 * 60);
      resp.addCookie(cookie);
    }
  ```
 
<br><br>

 **5. Q&A Insert**<br> 
 - 게시글을 등록하는 페이지 입니다.
 - 게시글을 작성하려면 유효성 검사를 통과해야 합니다.
 - Q&A 작성 폼은 썸머노트로 구현되었으며 다양한 텍스트 에디터의 기능 및 이미지, 동영상 삽입이 가능합니다.
 - 🔗 [SummerNote]  (https://summernote.org/)
<img width="1446" alt="qna" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/d50a6e61-c257-4af2-b838-0336e7b04dfd">

<br><br>

 **6. Q&A Content**<br> 
 - 게시글을 등록하거나 클릭하면 해당 페이지로 이동합니다.
 - session에 저장된 ID와 문의사항 작성자의 ID가 동일하다면 수정 및 삭제 기능을 이용할 수 있습니다.
 - 해당 페이지에서도 썸머노트가 사용됩니다.
<img width="1446" alt="boardContent" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/2ab59458-cb7d-4bcd-8b77-2a1ba5ea1b18">

 - 게시글을 클릭하여 해당페이지에 들어오면 해당 게시글의 조회수가 증가하며, 클릭 후 24시간 이내에 다시 클릭하더라도 조회수가 중복으로 증가하지 않습니다.
   
 ```ruby
 public void boardCookie(HttpServletRequest req, HttpServletResponse resp, String param, String id) {
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      boolean cookieExists = false;
      for (Cookie c : cookies) 
        if (c.getName().equals(param + id)) {
          cookieExists = true;
          break;
      }
       if (!cookieExists || cookies == null) addCookie(req, resp, param, id);
    }
  }
  public void addCookie(HttpServletRequest req, HttpServletResponse resp, String param, String id) {
    BoardAuthDao dao = BoardAuthDao.getInstance();
    dao.updateHit(param, Integer.parseInt(id));
    Cookie cookie = new Cookie(param + id, id);
    cookie.setMaxAge(24 * 60 * 60);
    resp.addCookie(cookie);
  }
 ```

<br><br>

 **7. Q&A Update**<br> 
 - 게시글을 수정하는 페이지 입니다.
 - 게시글을 작성할 때 사용한 파일을 분기처리하여 사용합니다.
<img width="1446" alt="boardUpdate" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/d069eff9-dc3d-421b-a26f-bb69ec252fde">

<br><br>

 **8. Q&A / Notice**<br> 
 - 사용자가 작성한 게시글 및 운영자가 작성한 공지사항을 확인할 수 있습니다.
 - 상단의 select 태그를 통해 최신순, 오래된순, 조회수높은순, 조회수 낮은순으로 정렬옵션을 선택할 수 있습니다.
 - 하단의 input을 통해 제목 및 작성자를 검색할 수 있습니다.
 - 해당 페이지는 페이지네이션을 사용하였습니다.
 - 사용자가 작성한 게시글과 운영자가 작성한 공지사항은 모두 한 파일에서 구현되었으며, 파라미터를 통해 분기처리 하였습니다.
 - 사용자가 작성한 게시글을 확인할 수 있는 화면입니다.

<img width="1446" alt="board" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/ba9eae89-7ac2-412a-a697-72bc259cf2d3">

 - 운영자가 작성한 공지사항을 확인할 수 있는 화면입니다.

<img width="1446" alt="notice" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/a8447ee4-d58a-4490-9ecb-bf1cc08f15a8">

<br><br>

 **9. LectureInsert**<br> 
 - 강의를 등록하는 페이지 입니다.
 - 사용자의 등급이 Teacher이거나 Owner인 경우 강의를 등록할 수 있습니다.
 - 강의를 등록하려면 유효성 검사를 통과해야 합니다.
 - 강의의 URL을 입력 후 유튜브 아이콘을 클릭하면 하단의 썸네일이 변경됩니다.
<img width="1446" alt="lecture_insert" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/77a80be2-2617-4283-b66a-4958f6ed89c7">

 - 강의가 정상적으로 등록되면 education 페이지로 이동합니다.
<img width="1446" alt="lecture_suceess" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/e20b1135-80b3-4fef-b792-93ddf92583c9">

<br><br>

 **10. LectureList**<br> 
 - 등록한 강의를 볼 수 있는 화면입니다.
 - 강의를 수정하거나 삭제할 수 있습니다.
 - 강의수정은 강의를 등록할 때 사용한 파일을 분기처리하여 사용합니다.
 - 상단의 select 태그를 통해 최신순, 오래된순, 조회수높은순, 조회수 낮은순으로 정렬옵션을 선택할 수 있습니다.
 - 하단의 input을 통해 제목을 검색할 수 있습니다.
<img width="1446" alt="lecture_list" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/d7d9ee5a-6f27-4411-926a-2ce80c001fee">

   
<br><br>

 **11. Member**<br> 
 - 사용자의 가입 정보를 확인할 수 있는 페이지 입니다.
 - 등급이 Owner인 사용자만 접근 할 수 있습니다.
 - 회원의 등급을 조정하거나 탈퇴시킬 수 있습니다.
 <img width="1206" alt="owner" src="https://github.com/whiteDwarff/CodeGrow_Servlet/assets/115057117/b752dca7-4d8f-4613-8850-1fb326d7376e">

 <br><br>

 ## 😄 프로젝트를 구현하면서 느낀 점
취업 전 포트폴리오를 준비한다고 급하게 준비했던 프로젝트였고, 평소에 JAVA 언어에 대한 거부감도 있었는데 평소에 쌓아온 프론트엔드의 지식이 도움이 많이 되었습니다.<br>
이 과정에서 MVC2 디자인 패턴과 서블릿을 조금씩 이해할 수 있었고, 시간이 흐를수록 욕심이 생겨 다양한 기능을 찾아보고 구현할 수 있었습니다.<br>
잘 동작하여 만족하며 지나간 코드도 조금만 시간이 흘러도 부족하고 더 보완해야 할 부분이 많이 보여서 욕심이 생겼고 아쉬운 프로젝트 였습니다.<br>
<br>
시간은 모두에게 공평하지만, 모두에게 주어지는 똑같은 시간을 어떻게 사용하는지에 따라 성공과 만족을 결정한다고 생각합니다.<br>
앞으로도 더 큰 성공과 만족을 위해 열심히 달려가겠습니다. 시간은 내편!!
