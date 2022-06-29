<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>frontendBar2</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.6/examples/jumbotron/">

<!-- Bootstrap core CSS -->
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
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
 </style>
<!-- Custom styles for this template -->
<link href="${contextRoot}/css/jumbotron.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #FFF0AC;">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#"> <img src="${contextRoot}/img/icons.png"
			width="35" height="35" alt="">
		</a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="navbar-brand" href="#">論壇討論</a></li>
				<li class="nav-item"><a class="navbar-brand"
					href="${contextRoot}/shop/products">商品專區</a></li>
				<li class="nav-item"><a class="navbar-brand" href="#">寵物美容</a></li>
				<li class="nav-item"><a class="navbar-brand" href="${contextRoot}/question">聯絡我們</a></li>
			</ul>
			<a class="alert-link" style="color: #642100"
				href="${contextRoot}/logout">登出</a>
		</div>
	</nav>
	<!-- <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark"> -->
	<!--   <a class="navbar-brand" href="#">Navbar</a> -->
	<!--   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation"> -->
	<!--     <span class="navbar-toggler-icon"></span> -->
	<!--   </button> -->

	<!--   <div class="collapse navbar-collapse" id="navbarsExampleDefault"> -->
	<!--     <ul class="navbar-nav mr-auto"> -->
	<!--       <li class="nav-item active"> -->
	<!--         <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> -->
	<!--       </li> -->
	<!--       <li class="nav-item"> -->
	<!--         <a class="nav-link" href="#">Link</a> -->
	<!--       </li> -->
	<!--       <li class="nav-item"> -->
	<!--         <a class="nav-link disabled">Disabled</a> -->
	<!--       </li> -->
	<!--       <li class="nav-item dropdown"> -->
	<!--         <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">Dropdown</a> -->
	<!--         <div class="dropdown-menu" aria-labelledby="dropdown01"> -->
	<!--           <a class="dropdown-item" href="#">Action</a> -->
	<!--           <a class="dropdown-item" href="#">Another action</a> -->
	<!--           <a class="dropdown-item" href="#">Something else here</a> -->
	<!--         </div> -->
	<!--       </li> -->
	<!--     </ul> -->
	<!--     <form class="form-inline my-2 my-lg-0"> -->
	<!--       <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search"> -->
	<!--       <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
	<!--     </form> -->
	<%--     <a class="nav-link" href="${contextRoot}/logout">登出</a> --%>
	<!--   </div> -->
	<!-- </nav> -->

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="${contextRoot}/js/jquery.slim.min.js"><\/script>')
	</script>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>


</body>
</html>
