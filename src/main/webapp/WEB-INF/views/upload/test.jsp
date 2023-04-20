<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/mod.jsp" %>

<html>
	<div class="container">
		<form class="text-center" action="uploadTest.do" method="POST" enctype="multiPart/form-data">
		
			<div>
				<input type="file" multiple="multiple" name="imgFiles">
			</div>

			<button class="btn btn-primary">제출</button>	
			<img src="/image/${imgFile.getStoreFileName()}">
		</form>
	</div>
</html>