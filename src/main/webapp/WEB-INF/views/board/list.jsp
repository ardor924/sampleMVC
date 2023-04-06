<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/mod.jsp" %>

<!-- 현재파일의CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/board/list.css"> 
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
                    <h2 class="contents-title">회원목록</h2><!--타이틀명만 수정-->
                    <hr class="section-line">
                </section>
                

                <!-- 컨텐츠메인 -->
                <section class="contents-main">
                    <table class="table table-striped table-hover">
                        <thead>
                        	<tr>
	                            <th scope="col">번호</th>
	                            <th scope="col">제목</th>
	                            <th scope="col">작성자</th>
	                            <th scope="col">조회수</th>
	                            <th scope="col">작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="bList" items="${board_list}">
                            <tr>
                                <td scope="row">${bList.board_idx}</td>
                                <td>${bList.board_title}</td>
                                <td>${bList.board_writer}</td>
                                <td>${bList.board_hit}</td>
                                <td>
									<fmt:formatDate value="${bList.board_regdate}" pattern="yyyy.MM.dd"/>
								</td>
                            </tr>
                        	</c:forEach>
                        </tbody>
                    </table>
                </section>
                
                
                <!-- 컨텐츠하단 -->
                <section class="contents-bottom">
                
                    <div class="row-space-between">
                        <div class="contents-bottom-left">
                            <select class="form-select" name="" id="">
                                <option value="" selected>선택</option>
                                <option value="">10개씩</option>
                                <option value="">15개씩</option>
                                <option value="">20개씩</option>
                            </select>
                        </div>
                        <div class="contents-bottom-right">
                            <a href="dummy.do"class="btn btn-outline-warning">더미데이터</a>
                            <a href="boardListPage.do"class="btn btn-outline-secondary">목록</a>
                            <a href="boardWritingPage.do"class="btn btn-primary">글쓰기</a>
                        </div>
                    </div>
                    
                    <div class="row-center">
                        <ul class="pagingBlock pagination">                              
                            <c:if test="${bp.prevPage > 0}">
                              <li class="page-item"><!--이전 페이징 블럭이 0이하 일 경우, 이전 버튼 비활성화-->
                                 <a class="page-link" href="#">
                                     <i class="fa-solid fa-angle-left"></i>이전
                                 </a>
                              </li>
                            </c:if>

                            <c:forEach var="i" begin="${bp.blockStart}" end="${bp.blockEnd}">	  
                                <li class="page-item ${bp.currentPage == i ? 'active':''}"><!-- 현재 페이지가 i일 경우 active(현재위치표시역할) -->
                                    <a class="page-link" href="#">${i}</a><!-- i로 페이지 이동 -->
                                </li>
                            </c:forEach>

                            <c:if test="${bp.blockEnd < bp.totalPage}">
                                <li class="page-item"><!-- 전체게시글 수가 페이징 블럭의 끝번호 보다 작을 경우 disabled(버튼 비활성화) -->
                                    <a class="page-link" href="#">
                                        다음<i class="fa-solid fa-angle-right"></i>
                                    </a>
                                </li>
                            </c:if>
                        </ul> 
                    </div>
                    
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