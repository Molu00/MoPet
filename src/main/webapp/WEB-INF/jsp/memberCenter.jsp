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
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container">



</div>
<div style="height:100px"></div>
<jsp:include page="layout/footer.jsp" />