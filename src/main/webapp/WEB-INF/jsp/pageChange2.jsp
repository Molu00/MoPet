<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
<c:when test="${empty loginOK}">
<jsp:include page="layout/frontendBar3.jsp" />
</c:when>
<c:otherwise>
<jsp:include page="layout/frontendBar.jsp" />
</c:otherwise>
</c:choose>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<style type="text/css">
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
<body>
	<main role="main">
		<br />

		<!-- 		<div -->
		<!-- 			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"> -->
		<!-- 			<h1 class="h2">回覆</h1> -->
		<!-- 		</div> -->

	</main>
	<div>
		<div class="container">

			<button class="js-back-to-top back-to-top" title="回到頭部">&#65085;</button>

			<script src="https://cdn.staticfile.org/jquery/2.2.4/jquery.min.js"></script>

			<script>
				$(function() {
					var $win = $(window);
					var $backToTop = $('.js-back-to-top');
					$win.scroll(function() {
						if ($win.scrollTop() > 100) {
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

			<div class="btn-toolbar mb-2 mb-md-0">
				<a href="${contextRoot}/replies/add2?id=${com.id}"><button
						type="button" class="btn btn-sm btn-outline-secondary">
						<span data-feather="calendar"></span> 新增留言
					</button></a>
			</div>


			<form:form class="form" method="post" modelAttribute="com">

				<div class="row justify-content-center ">
					<div class="col-9">
						<div class="card text-center ">
							<div class="card-header text-white bg-info ">

								<c:out value="${com.name}"></c:out>
							</div>
							<div class="card-body">
								<h1 class="display-5">
									<c:out value="${com.title}"></c:out>
								</h1>
							</div>
							<div style="padding: 10px ; font-size: 18px">
								<c:out value="${com.content}"></c:out>
							</div>
							<div class="card-body">
								<c:choose>
									<c:when test="${com.com_img !=null }">
										<img alt="avatar" src="${com.com_img}" width="40%"
											height="30%">
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</div>
							<span>留言數<c:out value="${count}"></c:out></span>
							<div class="card-body">
								<fmt:formatDate pattern="yyyy 年 MM 月 dd 日 hh:mm:ss a EEEE"
									value="${com.createondate}" />
							</div>
						</div>
					</div>
				</div>
			</form:form>


			<c:forEach var="fk" items="${fk}">
				<div class="row justify-content-center">
					<div class="col-9">
						<div class="card text-center">
							<div class="card-header card-header text-white bg-info">
								留言
								<c:out value="${fk.name}"></c:out>
							</div>
							<span class="card-body"> <c:out value="${fk.content}"></c:out>
								<c:choose>
									<c:when test="${fk.rep_img !=null }">
										<img alt="#" src="${fk.rep_img}" width="10%" height="5%">
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</span>
							<!-- 							<div class="card-body"> -->


							<!-- 							</div> -->
							<div class="card-body">
								<fmt:formatDate pattern="yyyy 年 MM 月 dd 日 hh:mm:ss a EEEE"
									value="${fk.createondate}" />
							</div>
														<div class="edit-link">
															<a href="${contextRoot}/replies/edit23?id=${fk.id}"><button
																	class="btn btn-info">編輯</button></a> <a
																onclick="return confirm('刪除')"
																href="${contextRoot}/replies/delete2?id=${fk.id}&c_id=${com.id}"><button
																	class="btn btn-danger">刪除</button></a> <br /> <br /> <br />
														</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>


