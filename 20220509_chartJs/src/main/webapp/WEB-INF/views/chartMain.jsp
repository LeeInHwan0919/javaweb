<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>차트 샘플</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- 필수 CDN -->
<body>
<h3><a href="./chartData.do">chart JS 데이터 바인딩</a></h3>
<hr>
<div style="width: 50%; height: 50%" >
<canvas id="myChart"></canvas>
</div>
<script>
const ctx = document.getElementById('myChart').getContext('2d');//getContext 속성을 통해 2d로 세팅
const myChart = new Chart(ctx, {
    type: 'bar',// 차트의 형태(line, pie ...)
    data: {// 차트에 들어갈 데이터
        labels: ['판매사A', '판매사B', '판매사C', '판매사D', '판매사E', '판매사F'],//x 축 label
        datasets: [{
            label: '판매량',//차트 제목 클릭시 데이터 언바운드
            data: [12, 19, 3, 5, 2, 3], //x축 label에 대응되는 데이터 값
            backgroundColor: [  //색상
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [ //경계선(테두리) 색상
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1//경계선(테두리) 굵기
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true //y축 시작점이 0으로 시작하는지
            }
        }
    }
});
</script>
</body>
</html>
