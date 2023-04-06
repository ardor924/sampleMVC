<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/mod.jsp" %>

<!-- 현재파일의CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/membership/join.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/footer.css"> 


<body>
    <div class="wrapper container">
        <!-- 헤더 -->
			<%@ include file="../inc/header.jsp" %>
        <!-- 헤더 -->
        
        <!-- 컨텐츠 : START-->
        <div class="contents">
        <!-- -------------------------------------------- 여기부터 Include : START ----------------------------------------------------------------------- -->

                <!-- 컨텐츠헤드 -->
                <section class="contents-headline">
                    <h2 class="contents-title">회원가입</h2><!--타이틀명만 수정-->
                    <hr class="section-line">
                </section>
                

                <!-- 컨텐츠메인 -->
                <section class="contents-main">
                    <form class="join-form" action="memberInsert.do" method="post">
                        <div class="row-group">
                            <div class="join-row">
                                <h5>
                                    <label for="member_id">아이디</label>
                                </h5>                               
                                <input class="form-control" type="text" name="member_id" placeholder="아이디를 입력하세요">
                                <!-- <span class="error-msg text-danger">
                                    5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.
                                </span> -->
                            </div>
                            <div class="join-row">
                                <h5>
                                    <label for="member_pw">비밀번호</label>
                                </h5>
                                <span>
                                    <input class="form-control" type="text" name="member_pw" placeholder="비밀번호를 입력하세요">
                                </span>
                                <!-- <span class="error-msg text-danger">
                                    필수 정보입니다.
                                </span> -->
                            </div>
                            <div class="join-row">
                                <h5>
                                    <label for="confirm_member_pw">비밀번호 재확인</label>
                                </h5>
                                <span>
                                    <input class="form-control" type="text" name="confirm_member_pw" placeholder="비밀번호를 다시 입력하세요">
                                </span>
                                <!-- <span class="error-msg text-danger">
                                    필수 정보입니다.
                                </span> -->
                            </div>
                            <div class="join-row">
                                <h5>
                                    <label for="member_name">이름</label>
                                </h5>
                                <span>
                                    <input class="form-control" type="text" name="member_name" placeholder="이름을 입력하세요">
                                </span>
                                <!-- <span class="error-msg text-danger">
                                    필수 정보입니다.
                                </span> -->
                            </div>
                            <div class="join-row">
                                <h5>
                                    <label for="str_member_birth">생년월일</label>
                                </h5>
                                <span>
                                    <input class="form-control" type="text" name="str_member_birth" placeholder="ex) 19990101">
                                </span>
                                <!-- <span class="error-msg text-danger">
                                    필수 정보입니다.
                                </span> -->
                            </div>
                            <div class="join-row">
                                <h5>
                                    <label for="member_gender">성별</label>
                                </h5>
                                <span>
                                    <select class="form-select" name="member_gender">
                                        <option selected>성별</option>
                                        <option value="M">남자</option>
                                        <option value="F">여자</option>
                                        <option value="N">선택안함</option>
                                    </select>
                                </span>
                                <!-- <span class="error-msg text-danger">
                                    필수 정보입니다.
                                </span> -->
                            </div>
                            <div class="join-row">
                                <h5>
                                    <label for="member_email">본인 확인 이메일</label>
                                </h5>
                                <span>
                                    <input class="form-control" type="text" name="member_email" placeholder="이메일을 입력하세요">
                                </span>
                                <!-- <span class="error-msg text-danger">
                                    필수 정보입니다.
                                </span> -->
                            </div>
                            <div class="join-row">
                                <h5>
                                    <label for="member_tel">휴대전화('-'없이 번호만 입력해주세요)</label>
                                </h5>
                                <span>
                                    <input class="form-control" type="text" name="member_tel" placeholder="ex) 01012345678">
                                </span>
                                <!-- <span class="error-msg text-danger">
                                    필수 정보입니다.
                                </span> -->
                            </div>
                            
                            <div class="submit-row">
                                <button class="btn-item btn btn-primary">회원가입</button>
                            </div>
                            <!-- <div class="submit-row">
                                <button class="btn-item btn btn-primary">회원가입</button>
                                <a href="#" class="btn-item btn btn-danger">취소</a>
                            </div> -->
                        </div>
                    </form>
                </section>
                
        <!-- -------------------------------------------- 여기부터 Include : END ------------------------------------------------------------------------- -->
        </div>
        <!-- 컨텐츠 : END-->
        <!-- 푸터 -->
			<%@ include file="../inc/footer.jsp" %>
        <!-- 푸터 -->
    </div>
</body>
<!-- ----------------------------- body 끝 ------------------------------------------ -->








<!-- ----------------------------- 자바스크립트 :  START ------------------------------------------ -->


<!-- 공통 JS파일 -->
<%@ include file="../inc/commonJS.jsp" %><!-- ◀- 스프링 JS파일 로드 에러로 인해 임시로 JSP파일로 대체 -->

<!-- 현재JSP의 JS파일 -->
<%-- <script src="${ctx}/resourses/js/"></script>  --%>



<!-- ----------------------------- 자바스크립트 :  END ------------------------------------------ -->
</html>