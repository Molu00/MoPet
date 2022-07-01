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


					<div class="container">






						<table>
							<tr>
								<th>編號</th>
								<th>員工</th>
								<th>日期</th>
								<th>工昨開始時間</th>
								<th>工昨結束時間</th>
								<th>狀態</th>
							</tr>


							<c:forEach var="addSchedule" items="${addschedules}">
								<tr>
									<td><c:out value="${addSchedule.id}" /></td>
									<td><c:out value="${addSchedule.staffname}" /></td>
									<td><c:out value="${addSchedule.added}" /></td>
									<td><c:out value="${addSchedule.starttime}" /></td>
									<td><c:out value="${addSchedule.endtime}" /></td>
									<td><c:out value="${addSchedule.status}" /></td>
									<td><a
										href="${contextRoot}/schedule/editSchedule?id=${addSchedule.id}"><button
												class="btn btn-info">編輯</button></a></td>
								</tr>

							</c:forEach>
						</table>



						<br />



                            						<div class="content ">
							<div class="select-box clearfix">
								<div class="col-xs-4">
									<form>
										<div class="form-group ">
											<label for="sel1">执勤地点</label> <select id="sel1"
												class="form-control"
												style="width: initial; display: inline-block; margin: 0 15px;">
												<option>城中一区</option>
												<option>城中二区</option>
												<option>城中三区</option>
												<option>城中四区</option>
											</select> <span>执勤类型：岗亭</span>
										</div>

									</form>
								</div>
								<div class="col-xs-3 text-right">
									<span class="preMonth">上一月</span> <input type="text"
										class="datetimepicker text-center form-control"
										id="datetimepicker"> <span class="nextMonth">下一月</span>
								</div>
							</div>
							<div class="content-data clearfix">
								<div class="col-xs-7">
									<table class="table table-condensed " border='1'
										cellspacing="0">
										<tbody>
											<tr class="text-center">
												<td>一</td>
												<td>二</td>
												<td>三</td>
												<td>四</td>
												<td>五</td>
												<td>六</td>
												<td>日</td>
											</tr>
										</tbody>


									</table>
								</div>
								<div class="col-xs-3 col-sm-offset-1 hide arrange-apply">
									<form class="form-horizontal " role="form">
										<div class="form-group">
											<label for="firstlabel" class="col-sm-3 control-label">排班计划</label>
										</div>
										<div class="form-group">
											<label for="firstlabel" class="col-sm-3 control-label">排班类型</label>
											<div class="col-sm-8">
												<select id="firstlabel" class="form-control">
													<option>单日排班</option>
												</select>
											</div>
										</div>
										<div class="form-group ">
											<label for="twolabel" class="col-sm-3 control-label">执勤日期</label>
											<div class="col-sm-8 input-icon">
												<input type="text" class="datetimepicker form-control"
													value="2019-04-01" id="twolabel"> <i
													class=" glyphicon glyphicon-calendar"></i>
											</div>

										</div>
										<div class="form-group">
											<label for="threelabel" class="col-sm-3 control-label">执勤时间</label>
											<div class="col-sm-8 input-icon">
												<input type="text" class="form-control" id="threelabel">
												<i class="glyphicon glyphicon-time"></i>
											</div>
										</div>
										<div class="form-group">
											<label for="fourlabel" class="col-sm-3 control-label">执行中队</label>
											<div class="col-sm-8">
												<select id="fourlabel" class="form-control">
													<option class="disabled">请选择</option>
													<option>一队</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="fivelabel" class="col-sm-3 control-label">选择警员</label>
											<div class="col-sm-8">
												<select id="fivelabel" class="form-control">
													<option class="disabled">请选择</option>
													<option>警员1</option>

												</select>
											</div>
										</div>
										<div class="form-group" style="margin-top: 40px;">
											<div class="col-sm-offset-3 col-sm-8 text-center">
												<button type="submit"
													class="btn btn-default btn-group-lg col-xs-5">清空</button>
												<button type="submit"
													class="btn btn-primary  col-xs-5 col-sm-offset-2">登录</button>
											</div>
										</div>
									</form>

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