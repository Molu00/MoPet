<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
<c:when test="${empty loginOK}">
<jsp:include page="layout/frontendBar3.jsp" />
</c:when>
<c:otherwise>
<jsp:include page="layout/frontendBar.jsp" />
</c:otherwise>
</c:choose>
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
<body><br/>


	<div>


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
				<button class="btn btn-info dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown"
					aria-expanded="false">篩選</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="${contextRoot}/comments/all2">最新</a> <a
						class="dropdown-item" href="${contextRoot}/comments/all3">最舊</a> <a
						class="dropdown-item" href="#">最熱門</a>
				</div>
			</div><br/><br/>
			
			<div class="btn-toolbar mb-2 mb-md-0">
				<a href="${contextRoot}/comments/add2"><button type="button"
						class="btn btn-sm btn-outline-secondary">
						<span data-feather="calendar"></span> 新增貼文
					</button></a>
			</div>

			<c:forEach var="page" items="${page.content}">

				<form:form modelAttribute="count">
					<c:out value="${count.count}"></c:out>
				</form:form>



				<div class="row justify-content-center ">
					<div class="col-9">
						<div class="card text-center ">
							<div class="myMOUSE"
								onclick="window.open('${contextRoot}/comments/page2?id=${page.id}')">
								<div class="card-header text-white bg-info ">
									<c:out value="${page.name}"></c:out>
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
								<span>留言數 <c:out value="${count}"></c:out>
								</span>

								<div class="card-body">
									<fmt:formatDate pattern="yyyy 年 MM 月 dd 日 hh:mm:ss a EEEE"
										value="${page.createondate}" />
								</div>

							</div>
<!-- 							<div class="edit-link"> -->
<%-- 								<a href="${contextRoot}/comments/edit2?id=${page.id}"><button --%>
<!-- 										class="btn btn-info">編輯</button></a> <a -->
<!-- 									onclick="return confirm('刪除')" -->
<%-- 									href="${contextRoot}/comments/delete2?id=${page.id}"><button --%>
<!-- 										class="btn btn-danger">刪除</button></a> -->
<!-- 							</div> -->
<!-- 							<br /> <br /> -->

							<!-- 							<div> -->
							<!-- 							<br /> <br /> -->
							<%-- 								<a href="${contextRoot}/comments/page?id=${page.id}"><button --%>
							<!-- 										class="btn btn-danger">內文</button></a> <br /> <br /> -->

							<!-- 							</div> -->

						</div>

					</div>
				</div>
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
											href="${contextRoot}/comments/all2?p=${pageNumber}"><c:out
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
		<div style="height:100px"></div>
<jsp:include page="layout/footer.jsp" />