<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty loginOK}">
	<c:set var='target' value='${pageContext.request.requestURI}'
		scope='session' />
	<c:redirect url="/login" />
</c:if>
<jsp:include page="layout/navbar2.jsp"></jsp:include>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">新增貼文</h1>
		<!-- 		<div class="btn-toolbar mb-2 mb-md-0"> -->
		<%-- 			<a href="${contextRoot}/employee"><button type="button" --%>
		<!-- 					class="btn btn-sm btn-outline-secondary"> -->
		<!-- 					<span data-feather="calendar"></span> 新增貼文 -->
		<!-- 				</button></a> -->
		<!-- 		</div> -->
	</div>
</main>
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">
	<div class="container text-center">
		<h1>新增留言</h1>
		<div class="row justify-content-center">
			<!-- 			<div class="col-9"> -->
			<div class="card text-center"></div>
			<div class="card-body">

				<form:form class="form" method="post"
					action="${contextRoot}/replies/add" modelAttribute="replies"
					enctype="multipart/form-data">


					<input type="hidden" name="id" value="${replies.fk_c_id}" />
                    


					<div class="card-header ">內容</div>
					<div class="form-group">
						<form:textarea path="content" class="form-control" />
					</div>
					<div class="card-header">發文者</div>
					<div class="form-group">
						<form:textarea path="name" class="form-control" />
					</div>

					<div class="card-header">上傳圖片</div>
					<div class="form-group">
						<br> <input type="file" name="repimg" id="repimg" />
					</div>


					<input  onclick="return confirm('確認發布?')" type="submit" name="submit"
						value="確定發布">

				</form:form>
				<script type="text/javascript">
					$(function() {

						function preView(preDIV) {
							var files = preDIV.files;
							for (var i = 0; i < files.length; i++) {
								var data = URL.createObjectURL(files[i]);
								$('<img class="img-item" src="'+data+'" />')
										.appendTo($("#upload"));
							}
						}

						$(':file').change(function() {
							console.log(this);
							preView(this);
						});
					});
				</script>

			</div>


		</div>
	</div>
</div>
<!-- </div> -->



