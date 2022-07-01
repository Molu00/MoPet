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

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">商品管理</h1>
		<div class="btn-toolbar mb-2 mb-md-0">
			<a href="${contextRoot}/add/products"><button type="button"
					class="btn btn-sm btn-outline-secondary">新增商品</button></a> <a
				href="${contextRoot}/add/companys"><button type="button"
					class="btn btn-sm btn-outline-secondary">新增廠商</button></a> <a
				href="${contextRoot}/add/category"><button type="button"
					class="btn btn-sm btn-outline-secondary">新增分類</button></a>
		</div>
		
	</div>
</main>
<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">
	<div class="container">
		<div>
			<h2 align="center"></h2>
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="輸入商品尋找"
					aria-label="Search">
				<button class="btn btn-dark" type="submit">Search</button>
			</form>
			<br />
			<table data-toggle="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">編號</th>
						<th scope="col">圖片</th>
						<th scope="col">名稱</th>
						<th scope="col" data-sortable="true">廠商</th>
						<th scope="col">分類</th>
						<th scope="col">庫存</th>
						<th scope="col">成本</th>
						<th scope="col">訂價</th>
						<th scope="col">日期</th>
						<th scope="col">是否上架</th>
						<th scope="col">編輯</th>
						<th scope="col">刪除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="allProduct" items="${productList.content}">
						<tr>
							<th scope="row"><c:out value="${allProduct.pId}" /></th>
							<td><img class="rounded-sm" alt="productImg" src="${allProduct.pImg}" width="100px" height="100px"></td>
							<td><c:out value="${allProduct.pName}" /></td>
							<td><c:out value="${allProduct.companyid.getCompany()}" /></td>
							<td><c:out value="${allProduct.catid.getCategoryName()}" /></td>
							<td><c:out value="${allProduct.pStock}" /></td>
							<td><c:out value="${allProduct.pCost}" /></td>
							<td><c:out value="${allProduct.pPrice}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${allProduct.pAdded}" /></td>
							<c:choose>
								<c:when test="${allProduct.sold}">
									<td><a href="${contextRoot}/onsold/product/${allProduct.pId}">
										<button class="btn btn-secondary" disabled>上架</button></a> 
										<a href="${contextRoot}/offsold/product/${allProduct.pId}">
									<button class="btn btn-secondary">下架</button></a></td>
								</c:when>
								<c:otherwise>
									<td><a href="${contextRoot}/onsold/product/${allProduct.pId}">
										<button class="btn btn-secondary">上架</button></a> 
										<a href="${contextRoot}/offsold/product/${allProduct.pId}">
									<button class="btn btn-secondary" disabled>下架</button></a></td>
								</c:otherwise>
							</c:choose>
							<td><a href="${contextRoot}/edit/product/${allProduct.pId}">
								<button class="btn btn-primary">Edit</button></a></td>
								<td><a href="${contextRoot}/delete/product/${allProduct.pId}">
							<button class="btn btn-warning">Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
				<div class="row justify-content-center">
					<div class="col-9">
						<ul class="pagination">
							<!-- 			<li class="page-item"><a class="page-link disabled">Previous</a></li> -->
							<c:forEach var="pages" begin="1" end="${productList.totalPages}">
								<c:choose>
									<c:when test="${productList.number!= pages-1}">
										<!-- 非當前頁面 -->
										<li class="page-item"><a class="page-link" href="${contextRoot}/all/products?p=${pages}">
										<c:out value="${pages}" /></a></li>
									</c:when>
									<c:otherwise>
										<!-- 當前頁面 -->
										<li class="page-item disabled"><a class="page-link"><c:out
													value="${pages}" /></a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<!-- 				<li class="page-item"><a class="page-link disabled">Next</a></li> -->
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
</div>