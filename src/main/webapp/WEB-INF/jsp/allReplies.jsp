<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="layout/navbar2.jsp" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">留言管理</h1>

	</div>
</main>
<div
	class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">

	<br />

	<div class="container">

		<c:forEach var="page" items="${page.content}">


			<div class="row justify-content-center">
				<div class="col-9">
					<div class="card text-center">
						<div class="card-header card-header text-white bg-dark">
							留言
							<c:out value="${page.name}"></c:out>
						</div>
						<!-- 		<div class="card-body"> -->
						<%-- 			<h1 class="display-5"><c:out value="${page.name}"></c:out></h1> --%>
						<!-- 		</div> -->
						<div class="card-body">
							<c:out value="${page.content}"></c:out>
						</div>
						<div class="card-body">
							<fmt:formatDate pattern="yyyy 年 MM 月 dd 日 hh:mm:ss a EEEE"
								value="${page.createondate}" />
						</div>

						<div class="edit-link">
							<a href="${contextRoot}/replies/edit?id=${page.id}"><button
									class="btn btn-info">編輯</button></a> <a
								onclick="return confirm('刪除')"
								href="${contextRoot}/replies/delete?id=${page.id}"><button
									class="btn btn-danger">刪除</button></a> <br /> <br /> <br />
						</div>

					</div>


				</div>
			</div>
		</c:forEach>
		<!-- 	<div class="row justify-content-center"> -->
		<!--      <div class="col-9"> -->

		<%-- 		<c:forEach var="pageNumber" begin="1" end="${page.totalPages}"> --%>

		<%-- 		<c:choose> --%>
		<%-- 		<c:when test="${page.number != pageNumber-1}"> --%>
		<%-- 		<a href="${contextRoot}/replies/all?p=${pageNumber}"><c:out value="${pageNumber}" /></a> --%>
		<%-- 		</c:when> --%>
		<%-- 		<c:otherwise> --%>
		<%--        <c:out value="${pageNumber}" /> --%>
		<%--      </c:otherwise> --%>
		<%-- 		</c:choose> --%>
		<%-- 		 <c:if test="${pageNumber != page.totalPages}"> --%>
		<!-- 		   | -->
		<%-- 		  </c:if> --%>
		<%-- 		</c:forEach> --%>

		<!-- 	 </div> -->
		<!-- 	 </div> -->

	</div>

</div>