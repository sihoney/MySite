# MySite
•리스트(10점)
- 로그인 사용자, 비로그인 사용자 모두 리스트를 볼 수 있음 [✅]
- 리스트 출력(페이징 기능 없이 모든 게시물 출력) [✅]
- 최근글이 맨위로 [✅]
- 로그인 사용자만 글쓰기 버튼이 보임 [✅]
- 작성일은 18-01-25 13:23 형태로 출력 [✅]
- 자신이 작성한 글에만 삭제버튼(쓰레기통아이콘) 이 보임 [✅]
- 제목을 클릭하면 글보기로 이동 [✅]

•등록(10점)
- 로그인 사용자만 게시물 입력가능 [✅]
- 제목, 본문은 사용자 입력 [✅]
- 이름 로그인 정보로 자동 입력 [❌] --> no로 대체
- 등록시간은 DB에서 저장시점시간으로 등록 [✅]
- 최초조회수는 0 으로 등록 됨 [✅]
- 등록후 리스트로 이동 [✅]

•삭제(5점)
- 게시물 리스트에서 삭제버튼(쓰레기통아이콘) 클릭시 해당 게시물 삭제됨 [✅]
- 삭제 후 리스트로 이동 [✅]

•보기(15점)
- 로그인 사용자, 비로그인 사용자 모두 선택한 게시물을 볼 수 있음 [✅]
- 자신이 작성한 글인경우에만 글수정 버튼이 보임 (타인의 글인 경우 보이지 않음) [✅]
  - 자신이 작성한 글만 수정할 수 있음
- 게시물을 읽을 경우 조회수가 1 증가됨 [✅]

•수정(20점)
- 글보기 페이지에서 글수정 버튼을 클릭해서 이동 [✅]
- 글수정 후 글수정 버튼을 클릭하면 수정한 내용이 반영됨 [✅]
  - (등록일은 변경되지 않음최초등록일)
- 수정내용 반영 후 리스트로 이동 [✅]
- 취소버튼 클릭시 해당글의 보기 페이지로 이동 [✅]

•공통사항(10점)
- 적절한 Dao 와 Vo 를 사용
- 페이지이동의 올바른 사용(redirection, forword)
- 공통파일 include 여부(header.jsp aside.jsp footer.jsp) [✅]
- 로그인 성공, 실패에 따른 header 의 메뉴적용
- el, jstl 사용(스클립틀릿 사용금지)
- Dao 의 테스트 여부 DaoTest.java 파일을 만들어서 단위 테스트 여부 [✅]
