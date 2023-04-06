<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

document.addEventListener("DOMContentLoaded", function(){
 	if(${login_msg == 'success'}){
		alert("로그인 성공!");
		};
	if(${login_msg == 'fail'}){
		alert("로그인 실패!");
		};  

});	






</script>