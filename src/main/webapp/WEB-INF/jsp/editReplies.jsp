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
<!-- <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4"> -->

<!-- </main> -->
<br/><br/><br/>
<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 ">
	<div class="row justify-content-center ">
		<div class=" text-white bg-secondary text-center" style="width: 920px">
			<h1>編輯留言</h1>
		</div>
	</div>
	<div class="row justify-content-center ">
		<div class="col-9">
			<div
				class="card text-center  shadow-lg p-3 mb-5 bg-white rounded font-italic">
				<div class="card-body">

					<form:form class="form" method="post" modelAttribute="replies" enctype="multipart/form-data">

						<form:input path="id" type="hidden" />
						<form:input path="name" type="hidden" />
						<%-- 						<form:input path=fk_c_id type="hidden" />  --%>

						<div class="form-group">
							<form:textarea path="content" class="form-control" />
						</div><br/>
						
						<div class="font-weight-bold">更新圖片</div><br/>
						<div class="form-group">
							<div id="upload"></div>
							<input type="file" name="repimg" id="repimg" width="40%"
								height="35%" />
						</div>


						<input type="submit" name="submit" value="更新">

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

</div>