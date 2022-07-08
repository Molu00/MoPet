<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>loginSystem</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/sign-in/">



<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#info').click(function() {
		$('#inputEmail4').val('蘇小樹');
		$('#inputPassword4').val('0958616953');
		$('#inputAccount').val('susu@gmail.com');
		$('#inputBirth').val('1991-01-05');
		$('#inputAddress').val('420台中市豐原區西勢二街21號');
	})
})
</script>
<style>
html, body {
	height: 100%;
}

body {
	display: flex;
	align-items: center;
	padding-top: 20px;
	padding-bottom: 20px;
	background-image: url("${contextRoot}/img/top6.png");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	 background-attachment: fixed;
	 margin-left: 100px;
}
</style>

</head>

<body style="opacity: 0.8">
<div class="shadow-lg p-3 mb-12 bg-white rounded">
		<div class="container">
			<h1 class="h2">註冊會員</h1>
			<div class="row justify-content-center">
				<form method="post" action="member/insert"
					enctype="multipart/form-data" id="test2">					
					<br />
					<div class="row">
						<div class="form-group col-md-6">
							<label for="inputEmail4">暱稱</label> <input type="text"
								class="form-control" id="inputEmail4" name="nickName" required>
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">電話</label> <input type="tel"
								class="form-control" id="inputPassword4" name="phonenNumber" required>
						</div>
					</div>
					<br/>
					<div class="form-group">
						<label for="inputAddress">Email 帳號</label> <input type="text"
							class="form-control" id="inputAccount"
							placeholder="you@gmail.com" name="email" required>
					</div>
					<br/>
					<div class="row">
					<div class="custom-control custom-radio custom-control-inline col-md-6">
						<input type="radio" id="customRadioInline1"
							name="gender" class="custom-control-input"> <label
							class="custom-control-label" for="customRadioInline1">男性</label>
					</div>
					<br/>
					<div class="custom-control custom-radio custom-control-inline col-md-6">
						<input type="radio" id="customRadioInline2"
							name="gender" class="custom-control-input"> <label
							class="custom-control-label" for="customRadioInline2">女性</label>
					</div>
					</div>
					<br/>
					<div class="form-group">
						<label for="inputBirth">生日</label> <input type="date"
							class="form-control" id="inputBirth" name="birth" required>
					</div>
<br/>
					<div class="form-group">
						<label for="inputAddress">地址</label> <input type="text"
							class="form-control" id="inputAddress" placeholder="台灣"
							name="shippingAddress" required>
					</div>
					<br/>
					<label for="inputAddress">上傳圖像</label>
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="customFile"
							name="profile" onchange="preview()"> <label
							class="custom-file-label" for="customFile">Choose file</label>

					</div>
					<div></div>
					<br />
					<button type="submit" class="btn btn-dark" id="test">註冊</button>
				</form>
			<p></p>
			</div>
				<button id="info" type="submit">一鍵帶入</button>
		</div>
		<script>
			function preview() {
				frame.src = URL.createObjectURL(event.target.files[0]);
			}
		</script>
<script>
document.getElementById('test').addEventListener('click',function(){
	event.preventDefault();
	Swal.fire({
		  title: '已新增會員',
		  width: 600,
		  padding: '3em',
		  color: '#716add',
		  background: '#fff url()',
		  backdrop: `
			  rgba(210,233,255,0.4)
		    url("${contextRoot}/img/fun2.gif")
		    left
		    no-repeat
		  `
		}).then(function(isConfirm){
            if(isConfirm){
                $("#test2").submit();
                    }
})
})
</script>
</div>
</body>
</html>