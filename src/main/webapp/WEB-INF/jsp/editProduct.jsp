<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="layout/navbar2.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<script>
	function preview() {
		frame.src = URL.createObjectURL(event.target.files[0]);
	}
</script>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">修改商品</h1>
	</div>
</main>
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">
	<div class="container" align="center">
		<h2>修改商品資訊</h2>
		<form:form method="POST" action="${contextRoot}/editProduct"
			var="product" modelAttribute="product" enctype="multipart/form-data">
			<input type="hidden" value="${product.pId}" name="pId" id="pId">
			<div class="form-group">
				<input placeholder="商品名稱" class="form-control" type="text"
					name="pName" id="pName" value="${product.pName}" />
			</div>
			<div class="form-group">
				<select class="form-control" id="categoryjsp" name="catid">
					<option value="" disabled selected>商品分類</option>
					<c:forEach items="${catelist}" var="catelist">
						<option value="${catelist.categoryid}">${catelist.categoryName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<select class="form-control" id="companyjsp" name="companyid">
					<option value="" disabled selected>公司名稱</option>
					<c:forEach items="${companyList}" var="companyList">
						<option value="${companyList.companyid}">${companyList.company}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<input value="${product.pPrice}" placeholder="商品單價"
					class="form-control" type="text" name="pPrice" id="pPrice" />
			</div>
			<div class="form-group">
				<input value="${product.pCost}" placeholder="商品成本"
					class="form-control" type="text" name="pCost" id="pCost" />
			</div>
			<div class="form-group">
				<input value="${product.pStock}" placeholder="商品庫存"
					class="form-control" type="text" name="pStock" id="pStock" />
			</div>
			<div class="form-group"></div>

			<div class="input-group mb-3">
				<input type="file" class="form-control" name="tempFile"
					id="tempFile" onchange="preview()"> <label
					class="input-group-text" for="inputGroupFile02">上傳</label>
			</div>
			<div>
				<img id="frame" class="rounded-sm" alt="productImg"
					src="${product.pImg}" width="100px" height="100px">
			</div>
			<div class="btn-group d-flex" role="group">
				<input class="btn btn-primary" type="submit" value="送出資料" />
			</div>
		</form:form>


	</div>
</div>