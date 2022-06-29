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
<title>Insert title here</title>
</head>
<body>
<main role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">尚未購入任何商品</h1>
      <p>歡迎進商城購入您需要的商品</p>
    </div>
  </div>
  <div class="container">
    <!-- Example row of columns -->
    <div >
    <hr>
		<div class="btn-toolbar mb-2 mb-md-0">
		  <a href="${contextRoot}/shop/products"><button type="button" class="btn btn-secondary">返回商城</button></a>
		  </div>
  </div> <!-- /container -->
  </div>
</main>
</body>
</html>