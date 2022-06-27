<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="layout/frontendBar2.jsp" />
<!DOCTYPE html>
<html>
<head>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">購物車</h1>
      <p>請確認以下商品數量與金額是否正確</p>
    </div>
  </div>

  <div class="container">
    <!-- Example row of columns -->
    <div >
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
							<td class="col-4"><c:out value="${allProduct.pId.getpName()}" /></td>
							<td class="col-2"><c:out value="${allProduct.pId.getpPrice()}" /></td>
							<td>
							<div class="btn">
							  <a href="#"><button type="button" class="btn btn-secondary">－</button></a>
							  <input class="col-md-2" type="text" readonly value="${allProduct.cartItemsAmount}">
							  <a href="#"><button type="button" class="btn btn-secondary">＋</button></a>
							</div>
							</td>
							<td><a href="${contextRoot}/delete/cartItem/${allProduct.pId}"><button class="btn btn-warning">取消購買</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
    <hr>
		<div class="btn-toolbar mb-2 mb-md-0">
		
		  <a href="#"><button type="button" class="btn btn-secondary">下一步</button></a>
		  </div>
  </div> <!-- /container -->
  </div>
</main>
</body>
</html>