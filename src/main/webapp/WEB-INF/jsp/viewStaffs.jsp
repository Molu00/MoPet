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
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">新增貼文</h1>

	</div>

</main>
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">

				<div class="table-responsive">


					<a href="${contextRoot}/staff/add"><button
							class="btn btn-danger">新增員工</button></a> <br />

					<div class="container">

						<table>
							<tr>
								<th>編號</th>
								<th>名子</th>
								<th>職稱</th>
								<th>行動電話</th>
								<th>信箱</th>
							</tr>


							<c:forEach var="employee" items="${page.content}">
								<tr>
									<td><c:out value="${employee.empId}" /></td>
									<td><c:out value="${employee.empName}" /></td>
									<td><c:out value="${employee.empRole}" /></td>
									<td><c:out value="${employee.empTel}" /></td>
									<td><c:out value="${employee.empEmail}" /></td>
									<td><a href="${contextRoot}/workday?id=${employee.empId}"><button
							               class="btn btn-danger">排班設定</button></a>
							            <a href="${contextRoot}/schedule/editSchedule?staffname=${employee.empName}"><button class="btn btn-info">班表顯示</button></a>       
							        </td>
								</tr>

							</c:forEach>
						</table>



						<br />


						<div class="row justify-content-center">
							<div class="col-9">
								<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">

									<c:choose>
										<c:when test="${page.number != pageNumber-1}">
											<a href="${contextRoot}/staff/all?p=${pageNumber}"> <c:out
													value="${pageNumber}" />
											</a>
										</c:when>

										<c:otherwise>
											<c:out value="${pageNumber}" />
										</c:otherwise>
									</c:choose>

									<c:if test="${pageNumber != page.totalPages}">
   |
   </c:if>

								</c:forEach>
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