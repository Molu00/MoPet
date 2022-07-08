<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
<c:when test="${empty loginOK}">
<jsp:include page="layout/frontendBar3.jsp" />
</c:when>
<c:otherwise>
<jsp:include page="layout/frontendBar.jsp" />
</c:otherwise>
</c:choose>
<c:if test="${empty loginOK}">
	<c:redirect url="/login" />
</c:if>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
<!-- 	<div -->
<!-- 		class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom"> -->
	<div class="container">
		<div>
			<h2 align="center">詳細清單</h2>
			<br />
				<table data-toggle="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col" class="text-center">圖片</th>
						<th scope="col" class="text-center">名稱</th>
						<th scope="col" class="text-center">價格</th>
						<th scope="col" class="text-center">數量</th>
						<th scope="col" class="text-center">小計</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="allOrder" items="${oDetailList}">
						<tr>
							<td class="col-2 text-md-center"><img class="rounded-sm" alt="productImg" src="${allOrder.pId.getpImg()}" width="80px" height="80px"></td>
									<td class="col-5 text-md-center"><c:out value="${allOrder.pId.getpName()}" /></td>
									<td class="col-1 text-md-center"><c:out value="${allOrder.productPrice}" /></td>
									<td class="col-1 text-md-center"><c:out value="${allOrder.productAmount}" /></td>
									<td class="col-1 text-md-center"><c:out value="${allOrder.productAmount*allOrder.productPrice}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="d-grid gap-2 d-md-block ">
				<a href="${contextRoot}/shop/products"><button type="button" class="btn btn-secondary">返回商城</button></a>
		 		 <a href="${contextRoot}/member/order"><button type="button" class="btn btn-secondary ">上一頁</button></a>
		  </div>
			</div>
		</div>
<!-- 	</div> -->
<br/>
<br/>
<br/>
<jsp:include page="layout/footer.jsp" />
</body>
</html>