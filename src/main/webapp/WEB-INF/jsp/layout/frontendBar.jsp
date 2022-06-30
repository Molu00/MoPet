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

	<!-- 	<div class="card bg-dark text-white"> -->
	<%-- 		<img src="${contextRoot}/img/top.jpg" class="card-img" alt="topcat"> --%>
	<!-- 		<div class="card-img-overlay"></div> -->
	<!-- 	</div> -->
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
			<a class="alert-link"  style="color:#642100" href="${contextRoot}/logout">登出</a>
		</div>
	</nav>
	<div id="carouselExampleCaptions" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleCaptions" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="${contextRoot}/img/top.jpg" class="d-block w-100" 
			height="500"
					alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>MoPet Store</h5>
					<p>歡迎來到Mopet商城，您可以在這裡找到數百種商品，總有一種適合您心愛的寵物</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="${contextRoot}/img/top9.jpg" class="d-block w-100" height="500"
					alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>Second slide label</h5>
					<p>Some representative placeholder content for the second
						slide.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="${contextRoot}/img/top2.jpg" class="d-block w-100" height="500"
					alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>Third slide label</h5>
					<p>Some representative placeholder content for the third slide.</p>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-target="#carouselExampleCaptions" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-target="#carouselExampleCaptions" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
		</button>
	</div>
</body>
</html>