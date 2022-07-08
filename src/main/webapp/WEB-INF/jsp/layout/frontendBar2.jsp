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
	width: 100%;
	height: 200px;
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

	<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color:#FFFFFF;">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#"> <img src="${contextRoot}/img/icon2.png" width="90"
			height="20" alt="">
		</a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mx-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="navbar-brand" href="${contextRoot}/comments/all2"><img src="${contextRoot}/img/論壇字體2.png" width="90"
			height="30" alt=""></a></li>
				<li class="nav-item"><a class="navbar-brand"
					href="${contextRoot}/shop/products"><img src="${contextRoot}/img/寵物商城2.png" width="90"
			height="25" alt=""></a></li>
				<li class="nav-item"><a class="navbar-brand" href="#"><img src="${contextRoot}/img/寵物美容2.png" width="90"
			height="22" alt=""></a></li>
				<li class="nav-item"><a class="navbar-brand" href="${contextRoot}/question"><img src="${contextRoot}/img/聯絡我們2.png" width="90"
			height="23" alt=""></a></li>
			</ul>
<div class="btn-group dropleft"">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown"
					aria-expanded="false">你好 Cindy Liang</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="${contextRoot}/member/196">我的帳號</a> 
					<a class="dropdown-item" href="${contextRoot}/member/order">我的訂單</a>
					<a  class="dropdown-item" style="color:#642100" href="${contextRoot}/shop/logout">登出</a>
				</div>
			</div>
					<div>
			  <a href="${contextRoot}/into/cart"><button type="button" class="btn btn-outline-secondary">購物車<span class="badge badge-danger badge-pill">${listSize}</span>
  </button></a>	
			</div>
		</div>
	</nav>

</body>
</html>