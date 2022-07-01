<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:if test="${empty backloginOK}">
    <c:set var='target' value='${pageContext.request.requestURI}' scope='session' />
    <c:redirect url="/login"/>
</c:if>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/navbar2.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<h1 class="h2">更新員工</h1>
		</div>
	</main>
	<div
		class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">
		<div class="container">
			<div class="row justify-content-center">
				<form method="post" action=""
					enctype="multipart/form-data">
					<input type="hidden" value=${employee.empId} name="id">
					<div class="row justify-content-center">
						<img id="frame" src=${employee.empProfile} width="100px" height="100px" />
					</div>
<br/>
					<div class="form-group">
						<label for="inputAddress">Email 帳號</label> <input type="text"
							value="${employee.empEmail}" class="form-control"
							placeholder="you@gmail.com" name="email">
					</div>
					<div class="form-row">

						<div class="form-group col-md-6">
							<label for="inputEmail4">暱稱</label> <input type="text" value="${employee.empName}"
								class="form-control" id="inputEmail4" name="nickName">
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">電話</label> <input type="tel" value="${employee.empTel}"
								class="form-control" id="inputPassword4" name="phonenNumber" >
						</div>
					</div>
					

					<div class="form-group">
						<label for="inputCharacter">角色</label> <input type="text" value="${employee.empRole}"
							class="form-control" 
							name="character">
					</div>
					
						<div class="form-group">
						<label for="inputstart_date">到職日</label> <input type="date" value=${employee.empStartDate}
							class="form-control" 
							name="start_date">
					</div>
					<label for="inputAddress">更換圖像</label>
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="customFile"
							name="profile" onchange="preview()"> <label
							class="custom-file-label" for="customFile">Choose file</label>

					</div>
					<div></div>
					<br />
					<button type="submit" class="btn btn-dark">更新</button>
				</form>
			</div>
		</div>
		<script>
			function preview() {
				frame.src = URL.createObjectURL(event.target.files[0]);
			}
		</script>
	</div>

</body>
</html>