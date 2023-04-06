<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./inc/mod.jsp" %>

<!-- 현재파일의CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/header.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/home.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/footer.css"> 

<!-- ----------------------------- body 시작 ------------------------------------------ -->
<body>
    <div class="wrapper container">
        <!-- 헤더 -->
			<%@ include file="./inc/header.jsp" %>
        <!-- 헤더 -->
        
        <!-- 컨텐츠 : START-->
        <div class="contents">
        <!-- -------------------------------------------- 여기부터 Include : START ----------------------------------------------------------------------- -->

            <!-- 컨텐츠명 -->
            <div class="article-head">
                <h3 class="article-title">Lorem Ipsum</h3>
                <p class="article-text">
                    "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
                </p>
                <p class="article-text">
                    "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."
                </p>
                <br>
                <hr>
            </div>
            <!-- 컨텐츠 본문 -->
            <div class="article-twoside">
                <div class="article-left">
                    <div class="article-group">
                        <h5 class="article-title">What is Lorem Ipsum?</h5>
                        <p class="article-text">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                    </div>
                    <div class="article-group">
                        <h5 class="article-title">Where does it come from?</h5>
                        <p class="article-text">
                            Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.
                        </p>
                    </div>
                </div>
                <div class="article-right">              
                    <div class="article-group">
                        <h5 class="article-title">Why do we use it?</h5>
                        <p class="article-text">
                            It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                        </p>
                    </div>
                    <div class="article-group">
                        <h5 class="article-title">Where can I get some?</h5>
                        <p class="article-text">
                            There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.
                        </p>
                    </div>
                </div>
            </div>

        <!-- -------------------------------------------- 여기부터 Include : END ------------------------------------------------------------------------- -->
        </div>
        <!-- 컨텐츠 : END-->
        <!-- 푸터 -->
			<%@ include file="./inc/footer.jsp" %>
        <!-- 푸터 -->
    </div>
</body>
<!-- ----------------------------- body 끝 ------------------------------------------ -->








<!-- ----------------------------- 자바스크립트 :  START ------------------------------------------ -->


<!-- 공통 JS파일 -->
<%@ include file="./inc/commonJS.jsp" %><!-- ◀- 스프링 JS파일 로드 에러로 인해 임시로 JSP파일로 대체 -->

<!-- 현재JSP의 JS파일 -->
<%-- <script src="${ctx}/resourses/js/"></script>  --%>



<!-- ----------------------------- 자바스크립트 :  END ------------------------------------------ -->
</html>



