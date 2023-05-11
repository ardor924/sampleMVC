<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/mod.jsp" %>

<!-- 현재파일의CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/board/writing.css"> 
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
                    <h2 class="contents-title">글쓰기</h2><!--타이틀명만 수정-->
                    <hr class="section-line">
                </section>
                

                <!-- 컨텐츠메인 -->
                <section class="contents-main">
                    <form class="writing-form" id="editForm" name="editForm"  action="writingInsert.do" method="post">
                    	<input type="hidden" name="board_writer" value="${member_name}" >
                        <div class="textarea-wrap form-group border">
                            <input class="textara-input form-text" name="board_title" placeholder="제목을 입력해 주세요."></input>
                        </div>
                        
                         <div>
                            <textarea class="textarea-none" id="editor" name="board_contents"></textarea>
                         </div>

                        <div class="btn-wrap">
                            <button type="submit"  class="btn-item btn btn-primary" >
                                <i class="fa-solid fa-check"></i> 등록
                            </button>
                            <a type="button" class="btn-item btn btn-danger" href='boardListPage.do'><i class="fa-solid fa-x"></i> 취소</a>
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
<%@ include file="../inc/commonJS.jsp"%><!-- ◀- 스프링 JS파일 로드 에러로 인해 임시로 JSP파일로 대체 -->

<!-- 현재JSP의 JS파일 -->
<script src="${ctx}/resources/js/ckeditor5/build/ckeditor.js"></script><!-- ckEditor5 Full npm 빌드-->
<script src="${ctx}/resources/js/ckeditor5/editor_setting.js"></script><!-- ckEditor5 설정파일-->


<!-- ----------------------------- 자바스크립트 :  END ------------------------------------------ -->
</html>





