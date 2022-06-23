<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="layout/navbar2.jsp"></jsp:include>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<body>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<h1 class="h2">回覆</h1>
		</div>

	</main>
	<div
		class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom ">
		<div class="container">

			<form:form class="form" method="post" modelAttribute="com">

				<div class="row justify-content-center ">
					<div class="col-9">
						<div class="card text-center ">
							<div class="card-header text-white bg-dark ">

								<c:out value="${com.name}"></c:out>
							</div>
							<div class="card-body">
								<h1 class="display-5">
									<c:out value="${com.title}"></c:out>
								</h1>
							</div>
							<div class="card-body">
								<c:out value="${com.content}"></c:out>
							</div>
							<div class="card-body">
								<fmt:formatDate pattern="yyyy 年 MM 月 dd 日 hh:mm:ss a EEEE"
									value="${com.createondate}" />
							</div>
						</div>
					</div>
				</div>
			</form:form>


			<c:forEach var="fk" items="${fk}">
				<div class="row justify-content-center">
					<div class="col-9">
						<div class="card text-center">
							<div class="card-header card-header text-white bg-dark">
								留言
								<c:out value="${fk.name}"></c:out>
							</div>
							<div class="card-body">
								<c:out value="${fk.content}"></c:out>
							</div>
							<div class="card-body">
								<fmt:formatDate pattern="yyyy 年 MM 月 dd 日 hh:mm:ss a EEEE"
									value="${fk.createondate}" />
							</div>
							<div class="edit-link">
								<a href="${contextRoot}/replies/edit?id=${fk.id}"><button
										class="btn btn-info">編輯</button></a> <a
									onclick="return confirm('刪除')"
									href="${contextRoot}/replies/delete?id=${fk.id}&c_id=${com.id}"><button
										class="btn btn-danger">刪除</button></a> <br /> <br /> <br />
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

<h1>777</h1>
</body>



