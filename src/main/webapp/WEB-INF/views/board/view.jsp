<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/mod.jsp" %>

<!-- 현재파일의CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/board/view.css?after"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/board/reply.css?after"> 
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
                    <h2 class="contents-title">{○○○게시판}</h2><!--타이틀명만 수정-->
                    <form action="boardListPage.do" method="POST" class="m-0">
                        <input type="hidden" name="current_page" value="${bp.current_page}"/>
                        <input type="hidden" name="page_rows" value="${bp.page_rows}"/>
                        <input type="hidden" name="search_type" value="${bDto.search_type}"/>
                        <input type="hidden" name="keyword" value="${bDto.keyword}"/>
                        <input type="hidden" name="board_idx" value="${bDto.board_idx}"/>
                        <button class="btn btn-outline-dark">목록</button>
                     </form>
                </section>
                
                

                <!-- 컨텐츠메인 -->
                <section class="contents-main">
                    <hr class="section-line-bold">
                    <h5>${bDto.board_title}</h5>
                    <div class="row-space-between">
                        <div class="row-left">
                            <span class="text-thin">${bDto.board_writer}</span>  
                            <span class="text-thin">
                            	<fmt:formatDate value="${bDto.board_regdate}" pattern="yyyy.MM.dd hh:mm"/>
							</span>
                        </div>
                        <div class="row-right">
                            <span class="text-thin">조회 ${bDto.board_hit}</span>
                        </div>
                    </div>
                    <hr class="section-line">
                    <div class="view-contents">
                        <p>${bDto.board_contents}</p>
                        <p>컨텐츠2</p>
                        <p>컨텐츠3</p>
                        <p>컨텐츠4</p>
                        <p>컨텐츠5</p>
                        <p>컨텐츠6</p>
                        <p>컨텐츠7</p>
                        <p>컨텐츠8</p>
                        <p>컨텐츠9</p>
                        <p>컨텐츠10</p>
                        <p>컨텐츠11</p>
                        <p>컨텐츠12</p>
                        <p>컨텐츠13</p>
                        <p>컨텐츠14</p>
                        <p>컨텐츠15</p>
                        <p>컨텐츠16</p>
                        <p>컨텐츠17</p>
                        <p>컨텐츠18</p>
                        <p>컨텐츠19</p>
                        <p>컨텐츠20</p>
                    </div>
                    <br>
                    <div class="row-space-between">
                        <div class="row-left">
                            <h6>전체댓글 {60}개</h6>
                        </div>
                        <div class="row-right">
                            <h6>조회 {103}</h6>
                        </div>
                    </div>
                    <hr class="section-line-bold">
                </section>
                
                
                <!-- 컨텐츠 두번째 -->
                	<%@ include file="../board/reply.jsp" %>
                <!-- 컨텐츠 두번째 -->
                
                
                <!-- 컨텐츠 하단 -->
				<section>
					<div class="row-space-between">
						<div class="row-left">
							<button class="btn btn-outline-secondary">전체글</button>
						</div>
						<div class="row-right">
							<button class="row-item btn btn-outline-success">수정</button>
							<form action="delPosting.do" method="POST" name="delPosting">
                                <button class="row-item btn btn-outline-danger" onclick="javascript:document.delPosting.submit();">삭제</button>
                                <input type="hidden" name="board_idx" value="${bDto.board_idx}">
                            </form>
							<button class="row-item btn btn-outline-dark">글쓰기</button>
						</div>
					</div>					
				</section>
                <!-- 컨텐츠 하단 -->
                
                
                
                
                
                
             
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
	
	// 댓글 자동 행높이 조절
	function autoResize(textarea) {
		  textarea.style.height = 'auto';
		  textarea.style.height = textarea.scrollHeight + 'px';
		}
</script>

<!-- 댓글의 JS파일 -->
<script src="${ctx}/resourses/js/reply.js"></script> 


<!-- ----------------------------- 자바스크립트 :  END ------------------------------------------ -->
</html>