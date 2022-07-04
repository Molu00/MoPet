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
		<jsp:include page="layout/frontendBar.jsp" />
			<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<div class="alert alert-success" role="alert">
			  購買成功!!請返回會員中心進行查看
			</div>
		<div style="height:100px"></div>
		<jsp:include page="layout/footer.jsp" />
	</c:otherwise>
</c:choose>