<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="layout/frontendBar.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<div class="container">

<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1>Mopet Store</h1>
      <p class="lead text-muted">歡迎來到Mopet商城，您可以在這裡找到數百種商品，總有一種適合您心愛的寵物</p>
    </div>
  </section>
  <div class="album py-5 bg-light">
    <div class="container">
      <div class="row">
      <c:forEach var="allProduct" items="${productList}">
        <div class="col-md-4">
          <div class="card mb-4 shadow-sm">
            <img class="rounded-sm" alt="productImg" src="${allProduct.pImg}">
            <div class="card-body">
              <p class="card-text"><c:out value="${allProduct.pName}" /></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="${contextRoot}/add/cartItems/${allProduct.pId}"><button type="button" class="btn btn-sm btn-outline-secondary">加入購物車</button></a>
                  <button type="button" class="btn btn-sm btn-outline-secondary">商品詳細頁面</button>
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
      </div>
    </div>
  </div>
</main>

<footer class="text-muted">
  <div class="container">
    <p class="float-right">
      <a href="#">Back to top</a>
    </p>
    <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
    <p>New to Bootstrap? <a href="/">Visit the homepage</a> or read our <a href="../getting-started/introduction/">getting started guide</a>.</p>
  </div>
</footer>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="${contextRoot}/js/jquery-3.6.0.slim.min.js"><\/script>')</script><script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</div>
