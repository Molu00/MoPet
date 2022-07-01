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

					<div class="card-header">請設定班表</div>

					<div class="card-body">

						<form:form class="form" method="post" action="${contextRoot}/addSchedule" >
						    
						    <h1><form:label path="staffname" >${staffName}</form:label> <form:input path="staffname" type="hidden" /></h1>
						    
							<table>
								<tr>
									<td><form:label path="addVactions">每週休假日</form:label></td>
									<td><form:checkboxes items="${webVactionList}"
											path="addVactions" /></td>
								</tr>
								<tr>
									<td><form:label path="addWorkdays">平日工作時間</form:label></td>
									<td><form:checkboxes items="${webDateList}"
											path="addWorkdays" /></td>
								</tr>
								<tr>
									<td><label>開始工作: </label></td>
									<td><form:select path="starttime">
									<form:option value="NONE" label="請選擇..." />
									<form:options items="${webWorktimeList}" />
									</form:select></td>
								</tr>
								<tr>
									<td><label>結束工作: </label></td>
									<td><form:select path="endtime">
									<form:option value="NONE" label="請選擇..." />
									<form:options items="${webWorktimeList}" />
									</form:select></td>
								</tr>
								<tr>
									<td><form:label path="addWeekens">假日日工作時間</form:label></td>
									<td><form:checkboxes items="${webWeekenList}"
											path="addWeekens" /></td>
								</tr>
								<tr>
									<td><label>開始工作: </label></td>
									<td><form:select path="wk_starttime">
									<form:option value="NONE" label="請選擇..." />
									<form:options items="${webWorktimeList}" />
									</form:select></td>
								</tr>
								<tr>
									<td><label>結束工作: </label></td>
									<td><form:select path="wk_endtime">
									<form:option value="NONE" label="請選擇..." />
									<form:options items="${webWorktimeList}" />
									</form:select></td>
								</tr>
							</table>


                           
							    <input type="submit" name="submit" value="確認修改">
							  
							  
						
						
						
						</form:form>

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