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
		<h1 class="h2">訂單管理</h1>
	</div>
</main>
<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom text-center">
	<div class="container">
		<div>
			<h2 align="center"></h2>
			<br />
			<table data-toggle="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col" data-sortable="true">訂單編號</th>
						<th scope="col" data-sortable="true" class="text-center">訂單日期</th>
						<th scope="col" data-sortable="true">顧客名稱</th>
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
					<c:forEach var="allOrder" items="${orderList.content}">
						<tr>
							<th scope="row" class="text-center"><c:out value="${allOrder.orderId}" /></th>
							<td ><fmt:formatDate pattern="yyyy-MM-dd EEE" value="${allOrder.orderAdded}" /></td>
							<td class="text-center"><c:out value="${allOrder.fkMemberId.getMemberName()}" /></td>
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
									<a href="${contextRoot}/false/shipping/${allOrder.orderId}">
										<button class="btn btn-secondary">未出貨</button></a></td>
								</c:when>
								<c:otherwise>
									<td><a href="${contextRoot}/true/shipping/${allOrder.orderId}">
											<button class="btn btn-secondary">已出貨</button></a> 
										<a href="${contextRoot}/false/shipping/${allOrder.orderId}">
											<button class="btn btn-secondary" disabled>未出貨</button></a></td>
								</c:otherwise>
							</c:choose>
							<td><a href="${contextRoot}/background/orderDetail/${allOrder.orderId}">
										<button class="btn btn-secondary">詳細清單</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
				<div class="row justify-content-center">
					<div class="col-9">
						<ul class="pagination">
							<!-- 			<li class="page-item"><a class="page-link disabled">Previous</a></li> -->
							<c:forEach var="pages" begin="1" end="${orderList.totalPages}">
								<c:choose>
									<c:when test="${orderList.number!= pages-1}">
										<!-- 非當前頁面 -->
										<li class="page-item"><a class="page-link" href="${contextRoot}/orders/all?p=${pages}">
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