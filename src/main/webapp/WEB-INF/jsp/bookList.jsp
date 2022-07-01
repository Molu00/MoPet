<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

	</div>

</main>
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">

				<div class="table-responsive">


					<div class="container">






						<table>
							<tr>
								<th>編號</th>
								<th>預約的設計師</th>
								<th>預約日期</th>
								<th>預約時間</th>
								<th></th>
								
							</tr>


							
								<tr>
									<td>${booking.id}</td>
									<td>${booking.staffname}</td>
									<td>${booking.bookday}</td>
									<td>${booking.start_booktime}</td>
									<td>${booking.end_booktime}</td>
								</tr>

							
						</table>



						<br />




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