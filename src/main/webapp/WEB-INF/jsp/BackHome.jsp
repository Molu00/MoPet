<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${empty backloginOK}">
	<c:redirect url="/login" />
</c:if>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/navbar2.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<h1 class="h2">你好 ${emp.empName }</h1>
		</div>
	</main>
	<div style="height: 50px"></div>
	<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3">
		<div class="row" >
			<div class="col">
				<div style="width: 300px; height: 60px">
					<canvas id="myChart" width="100" height="100"></canvas>
					<br/>
					<h5 style="text-align:center;">商品類別分布</h5>
				</div>
			</div>
			<div class="col">
				<div style="width: 300px; height: 60px">
					<canvas id="myChart2" width="100" height="100"></canvas>
					<br/>
					<h5 style="text-align:center;">會員生日月份</h5>
				</div>
			</div>
		</div>
		
		<script>
const ctx = document.getElementById('myChart');
const myChart = new Chart(ctx, {
    type: 'pie',
    data: {
    	 labels: [
    		    '美味食物',
    		    '好玩玩具',
    		    '就是愛美',
    		    '營養補品',
    		    '清潔用品'
    		  ],
        datasets: [{
            label: 'My First Dataset',
            data: [${category.foods}, ${category.toys},${category.clothing}, ${category.supplies}, ${category.cleaning}],
            backgroundColor: [
              'rgb(255, 99, 132)',
              'rgb(54, 162, 235)',
              'rgb(255, 205, 86)',
              'rgb(119, 68, 255)',
              'rgb(255, 200, 180)'
            ],
            hoverOffset: 5
          }]
    },
});

const ctx2 = document.getElementById('myChart2');
const myChart2 = new Chart(ctx2, {
    type: 'pie',
    data: {
    	 labels: [
    		    '一月',
    		    '二月',
    		    '三月',
    		    '四月',
    		    '五月',
    		    '六月',
    		    '七月',
    		    '八月',
    		    '九月',
    		    '十月',
    		    '十一月',
    		    '十二月'
    		  ],
        datasets: [{
            label: 'My Second Dataset',
            data: [
            	${birth.january},
            	${birth.february},
            	${birth.march},
            	${birth.april},
            	${birth.may},
            	${birth.june},
            	${birth.july},
            	${birth.august},
            	${birth.september},
            	${birth.october},
            	${birth.november},
            	${birth.december}
            ],
            backgroundColor: [
              'rgb(255, 99, 132)',
              'rgb(54, 162, 235)',
              'rgb(255, 205, 86)',
              'rgb(119, 68, 255)',
              'rgb(255, 200, 180)',              
              'rgb(220, 220, 220)',
              'rgb(193, 255, 193)',
              'rgb(255, 250, 205)',
              'rgb(176, 224, 230)',
              'rgb(255, 236, 139)',
              'rgb(205, 170, 125)',
              'rgb(238, 224, 229)'
            ],
            hoverOffset: 12
          }]
    },
});
</script>
	</div>

</body>

</html>
