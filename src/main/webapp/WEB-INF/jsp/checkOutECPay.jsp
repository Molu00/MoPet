<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<%-- <c:if test="${ecpay!=null}">
    ${ecpay}
</c:if> --%>
<c:choose>
	<c:when test="${ecpay!=null}">
		${ecpay}
	</c:when>
	<c:otherwise>
		<jsp:include page="layout/frontendBar3.jsp" />
			<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<div class="card bg-dark text-white">
			  <img src="${contextRoot}/img/gift.jpg" class="card-img" alt="gift_Jpg">
			  <div class="card-img-overlay">
			    <p class="text-muted text-center">購買成功!!請返回會員中心進行查看</p>
			  </div>
			</div>
		<jsp:include page="layout/footer.jsp" />
	</c:otherwise>
</c:choose>