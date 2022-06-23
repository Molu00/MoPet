<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #e3f2fd; position: sticky; top: 0px;">
		<a class="navbar-brand" href="${contextRoot}/">毛胚</a>
		<a class="nav-link" href="${contextRoot}/">Home <span
					class="sr-only">(current)</span></a> 
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<div class="dropdown">
					<button class="btn btn-outline-dark dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-expanded="false">會員</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="${contextRoot}/members/all">全部會員</a>
						<a class="dropdown-item" href="${contextRoot}/member">新增會員</a>
					</div>
				</div>
				
				<a class="nav-link"
					href="${contextRoot}/message/all">員工資料</a>
			</div>
		</div>
		<a href="${contextRoot}/logout"><button type="button" class="btn btn-secondary">登出</button></a>
	</nav>


	<script src="${contextRoot}/js/jquery-3.6.0.js"></script>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</body>
</html>