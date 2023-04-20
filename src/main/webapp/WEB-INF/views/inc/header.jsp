<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<header>
    <div class="gnb bg-secondary">
        <div class="gnb-left">
            <div class="logo-wrap">
                <h5><a class="logo" href="${ctx}">LOGO</a></h5>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                  회원관리
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                  <li><a class="dropdown-item" href="memberJoinPage.do">회원가입</a></li>
                  <li><a class="dropdown-item" href="memberLoginPage.do">로그인</a></li>
                  <li><a class="dropdown-item" href="memberLogout.do">로그아웃</a></li>
                  <li><a class="dropdown-item" href="memberListPage.do">회원정보조회</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                  게시판
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                  <li><a class="dropdown-item" href="boardListPage.do">게시판보기</a></li>
                  <li><a class="dropdown-item" href="boardWritingPage.do">게시글작성</a></li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                  댓글관리
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                  <li><a class="dropdown-item" href="#">테스트1</a></li>
                  <li><a class="dropdown-item" href="#">테스트2</a></li>
                  <li><a class="dropdown-item" href="#">테스트3</a></li>
                  <li><a class="dropdown-item" href="#">테스트4</a></li>
                </ul>
            </div>
        </div>
        <div class="gnb-right">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                  실험실1
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                  <li><a class="dropdown-item" href="uploadTestPage.do">업로드테스트1</a></li>
                  <li><a class="dropdown-item" href="#">테스트2</a></li>
                  <li><a class="dropdown-item" href="#">테스트3</a></li>
                  <li><a class="dropdown-item" href="#">테스트4</a></li>
                </ul>
            </div>
            <div class="dropdown">
             	<c:if test="${isLogin eq null}">
	                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
	                  게스트
	                </button>
	            </c:if>               
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                  <li><a class="dropdown-item" href="memberInsertChk.do">나의정보</a></li>
                  <li><a class="dropdown-item" href="#">테스트2</a></li>
                  <li><a class="dropdown-item" href="#">테스트3</a></li>
                  <li><a class="dropdown-item" href="#">테스트4</a></li>
                </ul>
            </div>
            <div class="dropdown">
             	<c:if test="${isLogin eq 'yes'}">
	                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
	                  ${member_name}
	                </button>
	            </c:if>               
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                  <li><a class="dropdown-item" href="memberInsertChk.do">나의정보</a></li>
                  <li><a class="dropdown-item" href="#">테스트2</a></li>
                  <li><a class="dropdown-item" href="#">테스트3</a></li>
                  <li><a class="dropdown-item" href="#">테스트4</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>