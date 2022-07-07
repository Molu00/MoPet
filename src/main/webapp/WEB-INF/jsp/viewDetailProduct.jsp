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
		<br /> <br /> <br />
		<div id="carouselExampleControlsNoTouching" class="carousel slide"
			data-touch="false" data-interval="false">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="${contextRoot}/img/makuProduct1.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="${contextRoot}/img/makuProduct2.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="${contextRoot}/img/makuProduct3.jpg"
						class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-target="#carouselExampleControlsNoTouching" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-target="#carouselExampleControlsNoTouching" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</button>
		</div>
		<div>
			<a href="${contextRoot}/shop/category/1"><button type="button"
					class="btn btn-outline-secondary">美味食物</button></a> <a
				href="${contextRoot}/shop/category/2"><button type="button"
					class="btn btn-outline-secondary">好玩玩具</button></a> <a
				href="${contextRoot}/shop/category/3"><button type="button"
					class="btn btn-outline-secondary">就是愛美</button></a> <a
				href="${contextRoot}/shop/category/4"><button type="button"
					class="btn btn-outline-secondary">營養補品</button></a> <a
				href="${contextRoot}/shop/category/5"><button type="button"
					class="btn btn-outline-secondary">清潔用品</button></a>
		</div>
		<div class="album py-5 bg-light ">
			<div class="container">
				<div class="row">
					<div class="col-md-5 shadow-lg p-3 mb-5 bg-white rounded">
						<div class="card mb-3" style="max-width: 540px;">
							<div class="row no-gutters text-center">
								<img src="${product.pImg}" alt="ProductIMG" width="400px" height="400px">
							</div>
						</div>
					</div>
					<div class="col-md-7">
						<div class="card mb-3 shadow-lg p-3 mb-5 bg-white rounded" style="max-width: 540px;">
							<div class="card-body">
							<h2 class="card-title"> ${product.pName}</h2>
							<h5>
							<span class="badge badge-primary">${product.companyid.getCompany()}</span>
							
							<c:if test="${product.catid.getCategoryid()==1}">
							<span class="badge badge-warning">美味食物</span>
							</c:if>
							
							<c:if test="${product.catid.getCategoryid()==2}">
							<span class="badge badge-warning">好玩玩具</span>
							</c:if>
							
							<c:if test="${product.catid.getCategoryid()==3}">
							<span class="badge badge-warning">就是愛美</span>
							</c:if>
							
							<c:if test="${product.catid.getCategoryid()==4}">
							<span class="badge badge-warning">營養補品</span>
							</c:if>
							
							<c:if test="${product.catid.getCategoryid()==5}">
							<span class="badge badge-warning">清潔用品</span>
							</c:if>
							<c:choose>
							<c:when test="${product.pStock<10}"><span class="badge badge-danger">庫存告急</span></c:when>
							<c:otherwise><span class="badge badge-success">庫存足夠</span></c:otherwise>
							</c:choose>
							</h5>
							<c:choose>
							<c:when test="${product.companyid.getCompanyid()==1}">
							<div class="nav flex-column justify-content-center text-center" style="width:450px;height:175px">
							<p>
							貪貪大獲好評的食品項目！<br/>
							全新系列強攻主子們挑剔的胃口，這次我們耗時半年調配貓貓的美味關鍵！
							口感與美味兼具！打造出完美適口性
							</p>
							</div>
							</c:when>
							<c:when test="${product.companyid.getCompanyid()==2}">
							<div class="nav flex-column justify-content-center text-center" style="width:450px;height:175px">
							<p>
							人氣網路寵物社群毛起來，由兩位年輕的創立品牌<br/>
							「一開始其實有點實驗性質做寵物品牌，我們本身就是毛爸媽，<br/>
							我們只是在想要做對毛孩們好的東西。」
							</p>
							</div>
							</c:when>
							<c:otherwise>
							<div class="nav flex-column justify-content-center text-center" style="width:450px;height:175px">
							<p>
							<br/>
							擺脫傳統生食價格高昂、營養不均、生菌數超標…等疑慮<br/>
							具有以下三大特色的汪喵沙西米終於誕生<br/><br/>
							頂級食材搭配親民價格、營養符合NRC美國最具公信力標準<br/>
							高壓滅菌把關，是最貼近犬貓原始生理需求的安心飲食<br/>
							讓毛拔麻餵得放心 ; 毛孩吃得開心
							</p>
							</div>
							</c:otherwise>
							</c:choose>
								<h3 class="card-title text-danger">$ ${product.pPrice}</h3>
								 <div class="btn-group">
				                  <a href="${contextRoot}/add/cartItems/${product.pId}"><button type="button" class="btn btn-sm btn-outline-secondary">加入購物車</button></a>
				                  <a href="${contextRoot}/shop/products"><button type="button" class="btn btn-sm btn-outline-secondary">返回商城</button></a>
				                  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<a href="${contextRoot}/into/cart"><button
				class="js-back-to-top back-to-top" title="購物車">
				<c:choose>
					<c:when test="${haveOrNot==false}">
						<img id="cartImg" alt="購物車" src="${contextRoot}/img/trolley.png"
							width="50px" height="50px">
					</c:when>
					<c:otherwise>
						<img id="cartImg" alt="購物車"
							src="${contextRoot}/img/trolleyRed.png" width="50px"
							height="50px">
					</c:otherwise>
				</c:choose>
			</button></a>


	</main>
</div>
<div style="height: 100px"></div>
<jsp:include page="layout/footer.jsp" />
