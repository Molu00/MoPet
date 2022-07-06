<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${empty backloginOK}">
    <c:set var='target' value='${pageContext.request.requestURI}' scope='session' />
    <c:redirect url="/login"/>
</c:if>
<jsp:include page="layout/navbar2.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<script>
	$(function() {
		$("#autokeyin").click(function() {
			document.getElementById("pName").value = "逗貓棒";
			document.getElementById("categoryjsp").selectedIndex = "2";
			document.getElementById("companyjsp").selectedIndex = "1";
			document.getElementById("pPrice").value = "200";
			document.getElementById("pCost").value = "100";
			document.getElementById("pStock").value = "30";
		});
	});

	function preview() {
		frame.src = URL.createObjectURL(event.target.files[0]);
	}
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	</div>
</main>
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">
	<div class="container" align="center">
		<div class="row justify-content-center">
			<div class="col-9">
				<h2>新增商品資訊</h2>
				<form:form method="POST" action="${contextRoot}/insertProduct"
					modelAttribute="Product" enctype="multipart/form-data" id="test2">
					<div class="form-group">
						<input placeholder="商品名稱" class="form-control" type="text"
							name="pName" id="pName" />
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
						<input placeholder="商品單價" class="form-control" type="text"
							name="pPrice" id="pPrice" />
					</div>
					<div class="form-group">
						<input placeholder="商品成本" class="form-control" type="text"
							name="pCost" id="pCost" />
					</div>
					<div class="form-group">
						<input placeholder="商品庫存" class="form-control" type="text"
							name="pStock" id="pStock" />
					</div>
					<div class="form-group">
						<select class="form-control" id="sold" name="sold">
							<option value="true" selected>直接上架</option>
							<option value=false>暫不上架</option>
						</select>
					</div>

					<div class="input-group mb-3">
						<input type="file" class="form-control" name="tempFile" id="tempFile" onchange="preview()"> 
						<label class="input-group-text" for="inputGroupFile02">上傳</label>
					</div>
					<div>
						<img id="frame" class="rounded-sm" alt="productImg" src="${contextRoot}/img/defaultimg.jpg" width="100px" height="100px">
					</div>
					<div class="btn-group d-flex" role="group">
						<input class="btn btn-primary" type="submit" value="送出資料" id="test"/>
					</div>
				</form:form>
				<div class="btn-group d-flex" role="group">
					<button id="autokeyin" class="btn btn-light" type="submit">Auto keyin</button>
				</div>

				<script>
				document.getElementById('test').addEventListener('click',function(){
					event.preventDefault();
					Swal.fire({
						  position: 'center',
						  icon: 'success',
						  title: '商品新增完成',
						  showConfirmButton: false,
						  timer: 2000
						}).then(function(isConfirm){
				            if(isConfirm){
				                $("#test2").submit();
				                    }
				})
				})
				</script>
			</div>
		</div>
	</div>
</div>
