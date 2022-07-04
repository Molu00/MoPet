<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="layout/frontendBar.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="card bg-dark text-white">
  <img src="${contextRoot}/img/gift.jpg" class="card-img" alt="gift_Jpg">
  <div class="card-img-overlay">
    <h5 class="card-title">購買成功</h5>
    <p class="card-text">您可繼續購物</p>
    <p class="card-text">或點擊回到會員中心查看歷史訂單</p>
  </div>
</div>
<div class="container">
<main role="main">
	<div class="alert alert-success" role="alert">
			  購買成功!!請返回會員中心進行查看
	</div>
</main>
</div>

<div style="height:100px"></div>
<jsp:include page="layout/footer.jsp" />