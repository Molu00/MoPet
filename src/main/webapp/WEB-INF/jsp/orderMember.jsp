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
			<h2 align="center">歷史訂單</h2>
			<br />
				<table data-toggle="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col" data-sortable="true">訂單編號</th>
						<th scope="col" data-sortable="true" class="text-center">訂單日期</th>
						<th scope="col">訂單金額</th>
						<th scope="col">送貨地址</th>
						<th scope="col">付費方式</th>
						<th scope="col">送貨方式</th>
						<th scope="col" class="text-center">付費狀態</th>
						<th scope="col" class="text-center">送貨狀態</th>
						<th scope="col" class="text-center">詳細清單</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="allOrder" items="${orderList}">
					<c:if test="${orderMmberId==allOrder.fkMemberId.getId()}">
						<tr>
							<th scope="row" class="text-center"><c:out value="${allOrder.orderId}" /></th>
							<td ><fmt:formatDate pattern="yyyy-MM-dd EEE" value="${allOrder.orderAdded}" /></td>
							<td class="text-center"><c:out value="${allOrder.orderTotal}" /></td>
							<td><c:out value="${allOrder.shippingAddress}" /></td>
							<td><c:out value="${allOrder.paymentId.getPaymentWay()}" /></td>
							<td><c:out value="${allOrder.shippingId.getShippingWay()}" /></td>
							<c:choose>
								<c:when test="${allOrder.paymentStatus}">
									<td><a href="${contextRoot}/true/payment/${allOrder.orderId}">
										<button class="btn btn-secondary" disabled>已付費</button></a> 
									</td>
								</c:when>
								<c:otherwise>
									<td><a href="${contextRoot}/false/payment/${allOrder.orderId}">
											<button class="btn btn-secondary" disabled>未付費</button></a></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${allOrder.shippingStatus}">
									<td><a href="${contextRoot}/true/shipping/${allOrder.orderId}">
										<button class="btn btn-secondary" disabled>已出貨</button></a> 
									</td>
								</c:when>
								<c:otherwise>
									<td><a href="${contextRoot}/false/shipping/${allOrder.orderId}">
											<button class="btn btn-secondary" disabled>未出貨</button></a></td>
								</c:otherwise>
							</c:choose>
							<td>
							<a href="${contextRoot}/member/orderDetail/${allOrder.orderId}">
											<button class="btn btn-secondary">詳細清單</button></a>
							</td>
							
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
			<div class="d-grid gap-2 d-md-block">
				<a href="${contextRoot}/shop/products"><button type="button" class="btn btn-secondary">返回商城</button></a>
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