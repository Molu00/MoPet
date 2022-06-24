<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="layout/navbar2.jsp" />
<!DOCTYPE html>
<html>
<head>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			
			
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">圖片</th>
						<th scope="col">名稱</th>
						<th scope="col">訂價</th>
						<th scope="col">數量</th>
						<th scope="col">取消</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="allProduct" items="${productList}">
						<tr>
							<td><img class="rounded-sm" alt="productImg" src="${allProduct.pId.getpImg()}" width="80px" height="80px"></td>
							<td><c:out value="${allProduct.pId.getpName()}" /></td>
							<td><c:out value="${allProduct.pId.getpPrice()}" /></td>
							<td><c:out value="${allProduct.cartItemsAmount}" /></td>
							<td><a href="${contextRoot}/delete/product/${allProduct.pId}"><button class="btn btn-warning">取消</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</div>
	</div>
</div>
</body>
</html>