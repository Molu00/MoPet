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
<style type="text/css">
.back-to-top {
	display: none;
	position: fixed;
	bottom: 20px;
	right: 30px;
	z-index: 99;
	border: 1px solid #5cb85c;
	outline: none;
	background-color: #fff;
	color: #5cb85c;
	cursor: pointer;
	padding: 10px 15px 15px 15px;
	border-radius: 10px;
}
</style>

<div class="container">
<script src="https://cdn.staticfile.org/jquery/2.2.4/jquery.min.js"></script>
<main role="main">

<a href="${contextRoot}/into/cart"><button class="js-back-to-top back-to-top" title="購物車"><img alt="購物車" src="${contextRoot}/img/trolley.png" width="30px" height="30px"></button></a>

			<script>
				$(function() {
					var $win = $(window);
					var $backToTop = $('.js-back-to-top');
					$win.scroll(function() {
						if ($win.scrollTop() > 1) {
							$backToTop.show();
						} else {
							$backToTop.hide();
						}
					});
				});
			</script>

<br/>
		
  <div class="album py-5 bg-light">
    <div class="container">
      <div class="row">
      
      <c:forEach var="allProduct" items="${productList}">
      
      <c:if test="${allProduct.sold==true}">
      
        <div class="col-md-3">
          <div class="card mb-1 shadow-sm">
            <img class="rounded-sm" alt="productImg" src="${allProduct.pImg}">
            <div class="card-body">
              <p class="card-text"><c:out value="${allProduct.pName}" /></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="${contextRoot}/add/cartItems/${allProduct.pId}"><button type="button" class="btn btn-sm btn-outline-secondary">加入購物車</button></a>
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        </c:if>
        
        </c:forEach>
        
      </div>
    </div>
  </div>
</main>



<!--     <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> -->
<%--       <script>window.jQuery || document.write('<script src="${contextRoot}/js/jquery-3.6.0.slim.min.js"><\/script>')</script><script src="${contextRoot}/js/bootstrap.bundle.min.js"></script> --%>
</div>
<div style="height:100px"></div>
<jsp:include page="layout/footer.jsp" />
