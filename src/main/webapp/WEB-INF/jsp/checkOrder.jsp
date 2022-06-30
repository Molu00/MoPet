<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${empty loginOK}">
    <c:set var='target' value='${pageContext.request.requestURI}' scope='session' />
    <c:redirect url="/login"/>
</c:if>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/frontendBar2.jsp" />

<main role="main">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">訂單成立中</h1>
	</div>
</main>
<div
	>
	<div class="container" align="center">
		<div>
			<div>
				<h2>訂單資訊</h2>
				<form:form method="POST" action="${contextRoot}/intoOrder" modelAttribute="Order">
					
					<h1>商品確認</h1>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col" class="text-md-center">圖片</th>
								<th scope="col" class="text-md-center">名稱</th>
								<th scope="col" class="text-md-center">訂價</th>
								<th scope="col" class="text-md-center">數量</th>
								<th scope="col" class="text-md-center">小計</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="allProduct" items="${productList}">
								<tr>
									<td class="col-2"><img class="rounded-sm" alt="productImg" src="${allProduct.pId.getpImg()}" width="80px" height="80px"></td>
									<td class="col-6 text-md-center"><c:out value="${allProduct.pId.getpName()}" /></td>
									<td class="col-2 text-md-center"><c:out value="${allProduct.pId.getpPrice()}" /></td>
									<td class="col-2 text-md-center"><c:out value="${allProduct.cartItemsAmount}"/></td>
									<td class="col-4 text-md-center"><c:out value="${allProduct.cartItemsAmount*allProduct.pId.getpPrice()}" /></td>
								</tr>
							</c:forEach>
							<tr>
								<th scope="col">總計</th>
								<td colspan="3"></td>
								<td colspan="2"><input class="text-center" id="orderTotal" name="orderTotal" type="text" value="${tempSum}"/></td>
							</tr>
						</tbody>
					</table>
					
					<h1>收件人資料</h1>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col"></th>
								<th scope="col">收件人名字</th>
								<th scope="col">收件人電話</th>
								<th scope="col">送貨地址</th>
							</tr>
							</thead>
							<tbody>
									<tr>
										<td class="col-1"><input id="fkMemberId" name="fkMemberId" type="hidden" value="${member.id}"></td>
										<td class="col-3"><c:out value="${member.memberName}" /></td>
										<td class="col-3"><c:out value="${member.memberTel}" /></td>
										<td class="col-2"><input id="shippingAddress" name="shippingAddress" type="text" value="${member.memberAddress}"></td>
									</tr>
							</tbody>
						</table>
					<h1>送貨相關</h1>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col" colspan="2" class="text-center">送貨方式</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="shippingWay" items="${shipList}">
								<tr>
									<td class="col-5 text-md-center">
										<div class="form-check">
										 	<input class="form-check-input" type="radio" name="shippingId" id="shippingId" value="${shippingWay.shippingId}" checked>
											<c:out value="${shippingWay.shippingWay}" />
										</div>
										<input id="shippingStatus" name="shippingStatus" type="hidden" value="false">
									</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
					<h1>付費相關</h1>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col" colspan="2" class="text-center">付費方式</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="payWay" items="${payList}">
								<tr>
									<td class="col-5 text-md-center">
										<div class="form-check">
										 	<input class="form-check-input" type="radio" name="paymentId" id="paymentId" value="${payWay.payId}" checked>
											<c:out value="${payWay.paymentWay}" />
										</div>
										<input id="paymentStatus" name="paymentStatus" type="hidden" value="false">
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="btn-group d-flex" role="group">
						<input class="btn btn-primary" type="submit" value="送出資料" />
				</div>
				</form:form>
				<div class="btn-group d-flex" role="group">
					<button id="autokeyin" class="btn btn-light" type="submit">Auto keyin</button>
				</div>

			</div>
		</div>
	</div>
</div>