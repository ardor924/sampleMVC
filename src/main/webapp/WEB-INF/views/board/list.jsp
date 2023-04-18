<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/mod.jsp" %>

<!-- 현재파일의CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/board/list.css?after"> 
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
                <section class="contents-headline-space-between">
                    <h2 class="contents-title">게시판</h2><!--타이틀명만 수정-->
                    <div class="search-row">
                        <form class="search-frm" action="boardListPage.do" method="POST" name="searchFrm">
                        
                            <select class="search-type form-select" name="search_type">
                                <option value="select_none" ${option eq 'select_none' ? 'selected' : '' }>선택</option>
                                <option value="select_title" ${option eq 'select_title' ? 'selected' : ''}>제목</option>
                                <option value="select_contents" ${option eq 'select_contents' ? 'selected' : ''}>내용</option>
                                <option value="select_writer" ${option eq 'select_writer' ? 'selected' : ''}>글쓴이</option>
                            </select>
                            
                            <input type="text"   name="keyword" class="search-input form-control rounded-0 rounded-start" placeholder="검색어를 입력 하세요" value="${bDto.keyword}">
                        	<input type="hidden" name="page_rows" value="${bp.page_rows}">
                        	<input type="hidden" name="order_by" value="${order_by}">
                        	
                            <button type="button" class="search-btn btn btn-primary btn-lg rounded-0 rounded-end" onclick="searchBtnClick()">
                                <i class="fa fa-search"></i>
                            </button>
                        </form>
                    </div>                    
                </section>
                
                

                <!-- 컨텐츠메인 -->
                <section class="contents-main">
                    <hr class="section-line">
                    <table class="table table-striped table-hover">
                        <thead>
                        	<tr>
 							<c:choose>
 								<c:when test="${order_by eq 'idx_asc'}">
	                            <th scope="col">
									<form name="idxDesc" action="boardListPage.do" method="POST">
										<input type="hidden"name="page_rows" value="${bp.page_rows}">
										<input type="hidden"name="order_by" value="idx_desc">
										<a onclick="javascrit:document.idxDesc.submit();">번호</a>
										<i class='fa-solid fa-sort-up'></i>
									</form>
								</th>
 								</c:when>
 								<c:otherwise><!-- 최초 표시되는값 -->
	                            <th scope="col">
									<form name="idxAsc" action="boardListPage.do" method="POST">
										<input type="hidden"name="page_rows" value="${bp.page_rows}">
										<input type="hidden"name="order_by" value="idx_asc">
										<a onclick="javascrit:document.idxAsc.submit();">번호</a>
										<i class='fa-solid fa-sort-down'></i>
									</form>
								</th>
 								</c:otherwise>
 							</c:choose>

	                            <th scope="col">제목</th>
	                            <th scope="col">작성자</th>
	                            
 							<c:choose>
 								<c:when test="${order_by eq 'hit_asc'}">
	                            <th scope="col">
									<form name="hitDesc" action="boardListPage.do" method="POST">
										<input type="hidden"name="page_rows" value="${bp.page_rows}">
										<input type="hidden"name="order_by" value="hit_desc">
										<a onclick="javascrit:document.hitDesc.submit();">조회수</a>
										<i class='fa-solid fa-sort-up'></i>
									</form>
								</th>
 								</c:when>
 								<c:otherwise><!-- 최초 표시되는값 -->
	                            <th scope="col">
									<form name="hitAsc" action="boardListPage.do" method="POST">
										<input type="hidden"name="page_rows" value="${bp.page_rows}">
										<input type="hidden"name="order_by" value="hit_asc">
										<a onclick="javascrit:document.hitAsc.submit();">조회수</a>
										<i class='fa-solid fa-sort-down'></i>
									</form>
								</th>
 								</c:otherwise>
 							</c:choose>			
 							                            
 							<c:choose>
 								<c:when test="${order_by eq 'regdate_asc'}">
	                            <th scope="col">
									<form name="regdateDesc" action="boardListPage.do" method="POST">
										<input type="hidden"name="page_rows" value="${bp.page_rows}">
										<input type="hidden"name="order_by" value="regdate_desc">
										<a onclick="javascrit:document.regdateDesc.submit();">작성일</a>
										<i class='fa-solid fa-sort-up'></i>
									</form>
								</th>
 								</c:when>
 								<c:otherwise><!-- 최초 표시되는값 -->
	                            <th scope="col">
									<form name="regdateAsc" action="boardListPage.do" method="POST">
										<input type="hidden"name="page_rows" value="${bp.page_rows}">
										<input type="hidden"name="order_by" value="regdate_asc">
										<a onclick="javascrit:document.regdateAsc.submit();">작성일</a>
										<i class='fa-solid fa-sort-down'></i>
									</form>
								</th>
 								</c:otherwise>
 							</c:choose>									
                            </tr>
                            
                        </thead>
                        <tbody>
	                        <tr>
                        	<c:if test="${board_list == null}">
	                            <td class="text-center" colspan="5">
	                                <h2>현재 게시판에 게시글이 없습니다.</h2>
	                            </td>                                
                       		</c:if>                        
	                        </tr>
                        	
                        
                        
                        	<c:forEach var="bList" items="${board_list}">
                            <tr>
                                <td scope="row">${bList.board_idx}</td>
                                <td>
					                <form id="goViewFrm+${bList.board_idx}"  action="boardViewPage.do" method="POST">
						                <input type="hidden" name="current_page" value="${bp.current_page}"/>
						                <input type="hidden" name="page_rows" value="${bp.page_rows}"/>
						                <input type="hidden" name="search_type" value="${bDto.search_type}"/>
						                <input type="hidden" name="keyword" value="${bDto.keyword}"/>
						                <input type="hidden" name="board_idx" value="${bList.board_idx}"/>
										<a onclick="javascript:document.getElementById('goViewFrm+${bList.board_idx}').submit()">${bList.board_title}</a>									
					                </form>                                
                                </td>
                                <td>${bList.board_writer}</td>
                                <td>${bList.board_hit}</td>
                                <td>
									<fmt:formatDate value="${bList.board_regdate}" pattern="yyyy.MM.dd"/>
								</td>
                            </tr>
                        	</c:forEach>
                        </tbody>
                    </table>
                    <hr class="section-line">
                </section>
                
                
                <!-- 컨텐츠하단 -->
                <section class="contents-bottom">
                	
                    <div class="row-space-between">
                        <div class="contents-bottom-left">
                            <form action="boardListPage.do" method="POST">
	                            <select class="form-select" name="page_rows" onchange="this.form.submit()">
	                                <option value="10" ${bp.page_rows eq 10 ? 'selected' : ''}>10개씩</option>
	                                <option value="15" ${bp.page_rows eq 15 ? 'selected' : ''}>15개씩</option>
	                                <option value="20" ${bp.page_rows eq 20 ? 'selected' : ''}>20개씩</option>
	                            </select>  
	                            <input type="hidden" name="order_by" value="${order_by}">                          	
	                            <input type="hidden" name="current_page" value="${bp.current_page}">                          	
                            </form>
                        </div>
                        <div class="contents-bottom-right">
                            <a href="dummy.do"class="btn btn-outline-warning">더미데이터</a>
                            <a href="boardListPage.do"class="btn btn-outline-secondary">목록</a>
                            <c:choose>
                            <c:when test="${isLogin == null}">
                            	<a class="btn btn-primary" onclick="javascript:alert('글쓰기 기능을 사용하기 위해서는 로그인이 필요합니다.')">글쓰기</a>                            
                            </c:when>
                            <c:otherwise>                           
                            	<a href="boardWritingPage.do"class="btn btn-primary">글쓰기</a>
                            </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    
                    <div class="row-center">
                        <ul class="pagination">                              
                            <c:if test="${bp.block_prev_page > 0}">
                              <li class="page-item">
                                 <a class="page-link" href="boardListPage.do?current_page=${bp.block_prev_page}&page_rows=${bp.page_rows}&order_by=${order_by}">
                                     <i class="fa-solid fa-angle-left"></i>이전
                                 </a>
                              </li>
                            </c:if>

                            <c:forEach var="i" begin="${bp.block_start_page}" end="${bp.block_end_page}">	  
                                <li class="page-item ${bp.current_page == i ? 'active':''}"><!-- 현재 페이지가 i일 경우 active(현재위치표시역할) -->
                                    <a class="page-link" href="boardListPage.do?current_page=${i}&page_rows=${bp.page_rows}&order_by=${order_by}">${i}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${bp.block_end_page < bp.total_page}">
                                <li class="page-item">
                                    <a class="page-link" href="boardListPage.do?current_page=${bp.block_next_page}&page_rows=${bp.page_rows}&order_by=${order_by}">
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


<script type="text/javascript">

	function searchBtnClick(){
		
		var searchType = searchFrm.search_type.value;
		
		   if(!searchFrm.keyword.value){
			      alert("검색어를 입력하세요!!");
			      searchFrm.keyword.focus();
			      return false;
			   }
			   
			   
			if (searchType=="select_none") {
				  alert("검색 타입을 선택해 주세요");
				  searchFrm.search_type.focus();
				  return false;
			}
			
			document.searchFrm.submit();
	}
	

	
	
	
</script>



<!-- ----------------------------- 자바스크립트 :  END ------------------------------------------ -->
</html>