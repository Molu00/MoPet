<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h1 class="h2">更新會員</h1>
		</div>
	</main>
	<div
		class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3 border-bottom">
		<div class="container">
			<div class="row justify-content-center">
				<form method="post" action="edit" enctype="multipart/form-data">
					<input type="hidden" value=${member.id} name="id">
					<div class="row justify-content-center">
						<img id="frame" src=${member.memberProfile} width="100px" height="100px" />
					</div>
					<div class="form-group">
						<label for="inputAddress">Email 帳號</label> <input type="text"
							value="${member.memberEmail}" class="form-control"
							id="inputAddress" placeholder="you@gmail.com" name="email" >
					</div>
					<div class="form-row">

						<div class="form-group col-md-6">
							<label for="inputEmail4">暱稱</label> <input type="text"
								value="${member.memberName}" class="form-control"
								id="inputEmail4" name="nickName">
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">電話</label> <input type="tel"
								value="${member.memberTel}" class="form-control"
								id="inputPassword4" name="phonenNumber">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputgender">性別</label> <select name="gender" value="${member.memberGender}">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>

					</div>
					<div class="form-group">
						<label for="inputBirth">生日</label> <input type="date"
							class="form-control" id="inputBirth" name="birth" value=${member.memberBirth}>
					</div>

					<div class="form-group">
						<label for="inputAddress">地址</label> <input type="text"
							value="${member.memberAddress}" class="form-control"
							id="inputAddress" placeholder="台灣" name="shippingAddress">
					</div>
					<label for="inputAddress">更換圖像</label>
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="customFile"
							name="profile"> <label class="custom-file-label"
							for="customFile">Choose file</label>
					</div>
					<div></div>
					<br />
					<button type="submit" class="btn btn-dark">更新</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>