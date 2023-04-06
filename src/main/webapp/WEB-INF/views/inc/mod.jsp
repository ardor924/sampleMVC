<!DOCTYPE html>
<html lang="kr">
<!----------------------------- head시작 ------------------------------------->
<head>
<!-- 0 head설정 -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>샘플연습</title>


<!-- 1 JSP인코딩 -->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!-- 2 taglib-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 3 contextPath-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!-- 4 부트스트랩 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- 5 폰트어썸 xi-icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

<!-- 6.CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/common/font.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/inc/mod.css"> 


</head>
<!----------------------------- head끝 ------------------------------------->
