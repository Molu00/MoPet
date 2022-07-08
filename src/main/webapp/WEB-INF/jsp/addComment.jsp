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

<jsp:include page="layout/navbar2.jsp"></jsp:include>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

</main>
<br />
<br />
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 ">
	<div class="row justify-content-center ">
		<div class=" text-white bg-secondary text-center" style="width: 900px">
			<h1>新增貼文</h1>
		</div>
	</div>

		<div class="row justify-content-center">
			<div class="col-9">
				<div
					class="card text-center  shadow-lg p-3 mb-5 bg-white rounded font-italic">
					<div class="card-body">

						<form:form class="form" method="post"
							action="${contextRoot}/comments/add" modelAttribute="comments"
							enctype="multipart/form-data">

							<div class="font-weight-bold">管理員</div>
							<br />
							<div class="form-group">
								<form:input path="name" class="form-control" />
							</div>

							<div class="font-weight-bold">標題</div>
							<br />
							<div class="form-group">
								<form:input path="title" class="form-control" />
							</div>

							<div class="font-weight-bold">內容</div>
							<br />
							<div class="form-group">
								<form:textarea path="content" class="form-control" />
							</div>

							<div class="font-weight-bold">上傳圖片</div>
							<br />
							<div class="form-group">

								<div id="upload"></div>
								<input type="file" name="comimg" id="comimg" />
							</div>


							<input onclick="return confirm('確認發布?')" type="submit"
								name="submit" value="確定發布">

						</form:form>

					</div>

				</div>
			</div>
		</div>
	</div>

</div>
<script type="text/javascript">
	$(function() {

		function preView(preDIV) {
			var files = preDIV.files;
			for (var i = 0; i < files.length; i++) {
				var data = URL.createObjectURL(files[i]);
				$('<img class="img-item" src="'+data+'" />').appendTo(
						$("#upload"));
			}
		}

		$(':file').change(function() {
			console.log(this);
			preView(this);
		});
	});
</script>