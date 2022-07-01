<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${empty loginOK}">
    <c:set var='target' value='${pageContext.request.requestURI}' scope='session' />
    <c:redirect url="/login"/>
</c:if>
<jsp:include page="layout/frontendBar2.jsp" />
<!DOCTYPE html>
<html>
<head>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Mopet Cart</title>

<script>
/* function amountChange(apo){
	var amountValue=document.getElementById('acount_'+apo).value;
	var productProic=document.getElementById('price_'+apo).value;
	console.log(amountValue);
	console.log(productProic);
	document.getElementById('total_'+apo).value=amountValue*productProic;
} */

/* 
$(function(){
	var amountValue=()
	}); */
</script>

</head>
<body>
<main role="main">
<div style="height:125px"></div>
  <div class="container">
    <div >
    <table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"></th>
						<th scope="col">圖片</th>
						<th scope="col">名稱</th>
						<th scope="col">訂價</th>
						<th scope="col">數量</th>
						<th scope="col">小計</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="allProduct" items="${productList}">
						<tr>
							<td class="col-1"><a href="${contextRoot}/delete/cartItem/${allProduct.pId.getpId()}"><button type="button" class="btn btn-danger">X</button></a></td>
							<td><img class="rounded-sm" alt="productImg" src="${allProduct.pId.getpImg()}" width="80px" height="80px"></td>
							<td class="col-4"><c:out value="${allProduct.pId.getpName()}" /></td>
							<td class="col-2"><c:out value="${allProduct.pId.getpPrice()}" /></td>
							<td>
							<div class="btn-group">
							  <a href="${contextRoot}/minus/cartItem/${allProduct.pId.getpId()}"><button type="button" class="btn btn-secondary">－</button></a>
							  <input class="col-md-4" type="text" readonly value="${allProduct.cartItemsAmount}">
							  <a href="${contextRoot}/add/cartItem/${allProduct.pId.getpId()}"><button type="button" class="btn btn-secondary">＋</button></a>
							</div>
							</td>
							<td><input class="col-md-7" readonly value="${allProduct.cartItemsAmount*allProduct.pId.getpPrice()}"></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
    <hr>
    	<div class="d-grid gap-2 d-md-block">
				<a href="${contextRoot}/shop/products"><button type="button" class="btn btn-secondary">返回商城</button></a>
		 		 <a href="${contextRoot}/checkIntoOrder"><button type="button" class="btn btn-secondary">下一步</button></a>
		  </div>
		  
  </div> <!-- /container -->
  </div>
</main>
<div style="height:100px"></div>
<jsp:include page="layout/footer.jsp" />
</body>
</html>
