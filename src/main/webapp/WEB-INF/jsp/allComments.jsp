<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${empty backloginOK}">
	<c:set var='target' value='${pageContext.request.requestURI}'
		scope='session' />
	<c:redirect url="/login" />
</c:if>
<jsp:include page="layout/navbar2.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.myMOUSE {
	cursor: pointer
}

.back-to-top {
	display: none;
	position: fixed;
	bottom: 20px;
	right: 30px;
	z-index: 99;
	border: 1px solid #5cb85c;
	outline: none;
	background-color: #fff;
	color: #5cb85c;
	cursor: pointer;
	padding: 10px 15px 15px 15px;
	border-radius: 10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<h1 class="h2">貼文管理</h1>
			<div class="btn-toolbar mb-2 mb-md-0">
				<a href="${contextRoot}/comments/add"><button type="button"
						class="btn btn-sm btn-outline-secondary">
						<span data-feather="calendar"></span> 新增公告
					</button></a>
			</div>
		</div>
	</main>
	<div
		class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom ">


		<div class="container">

			<button class="js-back-to-top back-to-top" title="回到頭部">&#65085;</button>

			<script src="https://cdn.staticfile.org/jquery/2.2.4/jquery.min.js"></script>

			<script>
				$(function() {
					var $win = $(window);
					var $backToTop = $('.js-back-to-top');
					$win.scroll(function() {
						if ($win.scrollTop() > 600) {
							$backToTop.show();
						} else {
							$backToTop.hide();
						}
					});
					$backToTop.click(function() {
						$('html, body').animate({
							scrollTop : 0
						}, 200);
					});
				});
			</script>

			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown"
					aria-expanded="false">篩選</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="${contextRoot}/comments/all">最新</a>
					<a class="dropdown-item" href="${contextRoot}/comments/all4">最舊</a>
<!-- 					<a class="dropdown-item" href="#">最熱門</a> -->
				</div>
			</div>

			<c:forEach var="page" items="${page.content}">

				<%-- 				<form:form modelAttribute="count"> --%>
				<%-- 					<c:out value="${count.count}"></c:out> --%>
				<%-- 				</form:form> --%>

				<div class="row justify-content-center ">
					<div class="col-9">
						<div class="card text-center shadow-lg">
							<div class="myMOUSE"
								onclick="window.location.href='${contextRoot}/comments/page?id=${page.id}'">
								
								<div class="card-header text-white bg-secondary ">
									<c:out value="${page.name}"></c:out>
<%-- 									<img src="${member.memberProfile}" width="5%" height="5%"/> --%>
								</div>

								<div class="card-body">
									<h1 class="display-5">
										<c:out value="${page.title}"></c:out>
									</h1>
								</div>
								<div class="card-body">
									<div
										style="padding: 10px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis; font-size: 18px;">
										<c:out value="${page.content}"></c:out>
									</div>
								</div>

								<div class="card-body">
									<h1 class="display-5">
										<%-- 										<img alt="avatar" src="${page.com_img}" width="50%" --%>
										<!-- 											height="50%"> -->
									</h1>
									<c:choose>
										<c:when test="${page.com_img !=null }">
											<img alt="avatar" src="${page.com_img}" width="40%"
												height="35%">
										</c:when>
										<c:otherwise>

										</c:otherwise>
									</c:choose>
								</div>


								<div class="card-body">
									<fmt:formatDate pattern="yyyy 年 MM 月 dd 日 hh:mm:ss a EEEE"
										value="${page.createondate}" />
								</div>

							</div>
							<c:forEach var="current" items="${map}">

								<c:if test="${page.id == current.key}">
										 留言數 <c:out value="${current.value}" />

								</c:if>

							</c:forEach>
							<br /> <br/>
							

							<div class="edit-link">
								<a href="${contextRoot}/comments/edit?id=${page.id}"><button
										class="btn btn-info">編輯</button></a> <a
									onclick="return confirm('刪除')"
									href="${contextRoot}/comments/delete?id=${page.id}"><button
										class="btn btn-danger">刪除</button></a>
							</div>
							<br />
							<!-- 							<div> -->
							<!-- 							<br /> <br /> -->
							<%-- 								<a href="${contextRoot}/comments/page?id=${page.id}"><button --%>
							<!-- 										class="btn btn-danger">內文</button></a> <br /> <br /> -->

							<!-- 							</div> -->

						</div>

					</div>
				</div>
<br /> <br />
			</c:forEach>



			<div class="row justify-content-center">
				<div class="col-9">

					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<!-- 							<li class="page-item"><a class="page-link" -->
							<%-- 								href="${contextRoot}/comments/all?p=${pageNumber}" --%>
							<!-- 								aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
							<!-- 							</a></li> -->

							<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">

								<c:choose>
									<c:when test="${page.number != pageNumber-1}">
										<li class="page-item"><a class="page-link"
											href="${contextRoot}/comments/all?p=${pageNumber}"><c:out
													value="${pageNumber}" /></a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"><c:out
													value="${pageNumber}" /></a></li>
									</c:otherwise>
								</c:choose>

								<%-- 								<c:if test="${pageNumber != page.totalPages}"> --%>
								<!-- 										| -->
								<%-- 								</c:if> --%>
							</c:forEach>
							<!-- 							<li class="page-item"><a class="page-link" href="#" -->
							<!-- 								aria-label="Next"> <span aria-hidden="true">&raquo;</span> -->
							<!-- 							</a></li> -->

						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>