<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section class="contents-bottom">
    <div>
        <form action="boardViewPage.do" method="POST" class="replyFrm">
            <h6>{작성자명}</h6>
            <textarea id="reply_textarea" class="textarea-none reply-textarea" 
            onkeyup="autoResize(this)" onkeydown="autoResize(this)" 
            rows="2" placeholder="댓글을 남겨보세요"></textarea>
            
            <div class="row-space-between">
                <a href=""><i class="fa fa-camera"></i></a>
                <a href="#">등록</a>
            </div>
        </form>
    </div>
    <hr class="section-line-bold">
</section>


