<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>navbar</title>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${contextRoot}/js/jquery-3.6.0.js"></script>
<script type="text/javascript"
	src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${contextRoot}/js/sweetalert2@11.js"></script>

<link rel="stylesheet" href="${contextRoot}/css/bootstrap.css">
<link rel="stylesheet" href="${contextRoot}/css/style.css">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

img.card-img {
	width: 130%;
	height: 270px;
	object-fit: cover;
}
</style>

<!-- Custom styles for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${contextRoot}/css/blog.css" rel="stylesheet">
<link href="${contextRoot}/css/album.css" rel="stylesheet">

</head>

<body>

	<div class="card bg-dark text-white">
		<img src="${contextRoot}/img/top.jpg" class="card-img" alt="topcat">
		<div class="card-img-overlay"></div>
	</div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#">Mopet
		</a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="navbar-brand" href="#">論壇討論</a></li>
				<li class="nav-item"><a class="navbar-brand" href="${contextRoot}/shop/products">商品專區</a></li>
				<li class="nav-item"><a class="navbar-brand" href="#">寵物美容</a></li>
				<li class="nav-item"><a class="navbar-brand" href="#">聯絡我們</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>


</body>
</html>