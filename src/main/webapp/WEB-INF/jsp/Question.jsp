<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/frontendBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<script>
$(function () {
    $('.SendEmail').click(function (event) {
      var email = 'MoPet@gmail.com';
      var subject = '[詢問] Hi MoPet!';
      var emailBody = 'Hi MoPet,';
      var attach = 'path';
      document.location = "mailto:"+email+"?subject="+subject+"&body="+emailBody;
    });
  });
</script>
<meta charset="UTF-8">
<title>QA</title>
</head>
<body>
	<br />
	<br />
	<div class="container shadow-lg p-3 mb-5 bg-white rounded">
		<div class="row">
			<div class="col">
				<div style="margin: 50px 100px">
					<h1>聯繫我們</h1>
					<br />
					<p>營業時間: 週一至週五 10:00-19:00</p>
					<p>聯絡我們: (02)2228-9046</p>
					<a class="SendEmail">寄信給毛胚</a>
				</div>
			</div>
			<div class="col">
				<p>
					<iframe width="300" height="300"
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3615.004559158293!2d121.54122331423845!3d25.03391934445035!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442abd379a5ec97%3A0xedc006d25a9e35df!2z6LOH5bGV5ZyL6Zqb6IKh5Lu95pyJ6ZmQ5YWs5Y-4!5e0!3m2!1szh-TW!2stw!4v1656472193190!5m2!1szh-TW!2stw"
						width="600" height="450" style="border: 0;" allowfullscreen=""
						loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
				</p>
			</div>
		</div>
	</div>
	<br />
	<div class="container">
		<h1>常見Q&A</h1>
		<div class="card">
			<div class="card-header">付款相關</div>
			<div class="card-body">
				<h5 class="card-title">毛胚會開發票嗎？</h5>
				<p class="card-text">當然會！配合政府環保無紙發票政策，所有訂單一律在出貨的同時寄出電子發票到你的
					email 信箱裡喔。</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		<br />
		<div class="card">
			<div class="card-header">付款相關</div>
			<div class="card-body">
				<h5 class="card-title">目前有什麼付款方式呢？</h5>
				<p class="card-text">現在可以使用【線上刷卡】、【宅配貨到付款】、【Apple Pay
					付款】、以及【超商取貨付款】等方式付款唷！</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		<br />
		<div class="card">
			<div class="card-header">付款相關</div>
			<div class="card-body">
				<h5 class="card-title">可以開統編嗎？</h5>
				<p class="card-text">可以，請在訂單結帳畫面勾選「公司戶(三聯)發票」，填寫統編、抬頭、地址，我們會在出貨的同時寄出電子發票到你的
					email 信箱裡喔。</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		<br />
		<div class="card">
			<div class="card-header">運費相關</div>
			<div class="card-body">
				<h5 class="card-title">運費是多少錢呢？</h5>
				<p class="card-text">單筆訂單運費計算如下： 【本島】購物滿 1000 元免運 (購物金 /
					優惠碼折抵後，不包含運費) 未滿 1000 元將酌收 80 元金物流費。 【離島】購物滿 2000 元免運 (購物金 /
					優惠碼折抵後，不包含運費) 未滿 2000 元將酌收 200 元金物流費。</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		<br />
		<div class="card">
			<div class="card-header">購物相關</div>
			<div class="card-body">
				<h5 class="card-title">購物金是什麼？</h5>
				<p class="card-text">購物金就是存在你帳戶的錢錢，下單時可用購物金直接折抵消費金額，並且沒有使用限制與期限，不管多少錢都可折抵喔。點我查詢帳戶裡的購物金。</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		<br />
		<div class="card">
			<div class="card-header">購物相關</div>
			<div class="card-body">
				<h5 class="card-title">我想要退回現金要怎麼處理呢？</h5>
				<p class="card-text">以 LINE@ 與店長聯繫，告知 匯款銀行 / 分行 / 戶名 /
					帳號，請務必提供存摺/提款卡封面(有帳號那面)給馬克店長，將立刻幫你申請匯款，由於現金匯款作業由會計姊姊親自辦理，約 7至 14
					工作天入帳。 ◎若因個人訂購商品之疏失，導致商品訂購錯誤，僅接受退貨服務，不提供換貨。 ◎特價出清、即期商品，恕不接受退換貨服務。

					◎若退貨商品經檢查發現已拆封使用/外箱彩盒包裝破損，則會收取商品售價20%金額的整新費。



					加入官方客服，解答你的更多問題：https://line.me/R/ti/p/~@petpetgo</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
</body>
</html>