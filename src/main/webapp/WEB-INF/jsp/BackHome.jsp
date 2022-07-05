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
<div
		class="col-md-9 ml-sm-auto col-lg-10 px-md-4 pt-3 pb-2 mb-3">
<div style="width:300px;height:60px">
<canvas id="myChart" width="100" height="100"></canvas>
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
            data: [300, 50, 100, 50, 100],
            backgroundColor: [
              'rgb(255, 99, 132)',
              'rgb(54, 162, 235)',
              'rgb(255, 205, 86)',
              'rgb(119, 68, 255)',
              'rgb(255, 200, 180)'
            ],
            hoverOffset: 4
          }]
    },
});
</script>
</div>

</body>

</html>
