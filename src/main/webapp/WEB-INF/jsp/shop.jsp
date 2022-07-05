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
<jsp:include page="layout/frontendBar2.jsp" />
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
	padding: 5px 5px 11px 11px;
	border-radius: 10px;
}

</style>

<div class="container">
<script src="https://cdn.staticfile.org/jquery/2.2.4/jquery.min.js"></script>
<main role="main">

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
<br/>
<br/>
		<div id="carouselExampleControlsNoTouching" class="carousel slide" data-touch="false" data-interval="false">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="${contextRoot}/img/makuProduct1.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="${contextRoot}/img/makuProduct2.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="${contextRoot}/img/makuProduct3.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-target="#carouselExampleControlsNoTouching" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-target="#carouselExampleControlsNoTouching" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </button>
		</div>
	<div>
	  <a href="${contextRoot}/shop/category/1"><button type="button" class="btn btn-outline-secondary">美味食物</button></a>
      <a href="${contextRoot}/shop/category/2"><button type="button" class="btn btn-outline-secondary">好玩玩具</button></a>
      <a href="${contextRoot}/shop/category/3"><button type="button" class="btn btn-outline-secondary">就是愛美</button></a>
      <a href="${contextRoot}/shop/category/4"><button type="button" class="btn btn-outline-secondary">營養補品</button></a>
      <a href="${contextRoot}/shop/category/5"><button type="button" class="btn btn-outline-secondary">清潔用品</button></a>
  	</div>
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
                  <a href="${contextRoot}/add/cartItems/${allProduct.pId}"><button type="button" class="btn btn-sm btn-outline-secondary">購物車</button></a>
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
 <a href="${contextRoot}/into/cart"><button class="js-back-to-top back-to-top" title="購物車">
<c:choose>
<c:when test="${haveOrNot==false}">
<img id="cartImg" alt="購物車" src="${contextRoot}/img/trolley.png" width="50px" height="50px">
</c:when>
<c:otherwise>
<img id="cartImg" alt="購物車" src="${contextRoot}/img/trolleyRed.png" width="50px" height="50px">
</c:otherwise>
</c:choose>
</button></a>
  
  
</main>
<!-- <script>
$(function() {
	var send = document.getElementById("send_"+"${allProduct.pId}");
	send.addEventListener('click',function(e){
		e.preventDefault();
	});
});
</script> -->
</div>
<div style="height:100px"></div>
<jsp:include page="layout/footer.jsp" />
