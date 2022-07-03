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
				<h2>訂單成立，可至會員中心查看訂單</h2>
		    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      	<script>window.jQuery || document.write('<script src="${contextRoot}/js/jquery-3.6.0.slim.min.js"><\/script>')</script><script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
		<div style="height:100px"></div>
		<jsp:include page="layout/footer.jsp" />
	</c:otherwise>
</c:choose>