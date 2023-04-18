<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/mod.jsp" %>

<!-- 현재파일의CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/membership/list.css?after"> 
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
                <section class="contents-headline-center">
                    <h2 class="contents-title">회원목록</h2><!--타이틀명만 수정-->
                </section>
                

                <!-- 컨텐츠메인 -->
                <section class="contents-main">
                    <hr class="section-line">
                    <table class="table table-striped table-hover">
                        <thead>
                        	<tr>
	                            <th scope="col">번호</th>
	                            <th scope="col">아이디</th>
	                            <th scope="col">비밀번호</th>
	                            <th scope="col">이름</th>
	                            <th scope="col">생일</th>
	                            <th scope="col">성별</th>
	                            <th scope="col">이메일</th>
	                            <th scope="col">휴대전화</th>
	                            <th scope="col">가입일</th>
                            </tr>
                        </thead>
                        <tbody>                   
                        	<c:forEach var="mList" items="${member_list}">
                            <tr>
                                <td scope="row">${mList.member_idx}</td>
                                <td>${mList.member_id}</td>
                                <td>${mList.member_pw}</td>
                                <td>${mList.member_name}</td>
                                <td>
									<fmt:formatDate value="${mList.member_birth}" pattern="yyyy.MM.dd"/>
								</td>
                                <td>
									<c:if test="${mList.member_gender eq 'M'}">
										남자
									</c:if>
									<c:if test="${mList.member_gender eq 'F'}">
										여자
									</c:if>
									<c:if test="${mList.member_gender eq 'N'}">
										없음
									</c:if>
								</td>
                                <td>${mList.member_email}</td>
                                <td>${mList.member_tel}</td>
                                <td>
									<fmt:formatDate value="${mList.member_regdate}" pattern="yyyy.MM.dd"/>
								</td>
                            </tr>
                        	</c:forEach>
                        </tbody>
                    </table>
                    <hr class="section-line">
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