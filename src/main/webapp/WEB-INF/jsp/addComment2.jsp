<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
<c:when test="${empty loginOK}">
<jsp:include page="layout/frontendBar3.jsp" />
</c:when>
<c:otherwise>
<jsp:include page="layout/frontendBar.jsp" />
</c:otherwise>
</c:choose>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">


</main>
<br />
<div>

	<div class="container text-center ">
		<div class="text-white bg-dark">
			<h1>新增貼文</h1>
		</div>

		<div class="row justify-content-center">
			<div class="col-9">
				<div class="card text-center"></div>
				<div class="card-body">

					<form:form class="form" method="post"
						action="${contextRoot}/comments/add2" modelAttribute="comments"
						enctype="multipart/form-data">

						<div class="card-header">標題</div>
						<div class="form-group">
							<form:textarea path="title" class="form-control" />
						</div>
						<div class="card-header">內容</div>
						<div class="form-group">
							<form:textarea path="content" class="form-control" />
						</div>
						<div class="card-header">發文者</div>
						<div class="form-group">
							<form:textarea path="name" class="form-control" />
						</div>

						<div class="card-header">上傳圖片</div>
						<div class="form-group">
							<div id="upload"></div>
							<br> <input type="file" name="comimg" id="comimg" />
						</div>

						<input onclick="return confirm('確認發布?')" type="submit"
							name="submit" value="發文">
					</form:form>
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
	<div style="height:100px"></div>
<jsp:include page="layout/footer.jsp" />