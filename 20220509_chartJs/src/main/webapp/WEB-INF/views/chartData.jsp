<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>차트 샘플 (DATA)</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- 필수 CDN -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<h3>데이터 바인딩 chartJs</h3>
<hr>
<div style="width: 90%; height: 90%" >
<canvas id="myChart"></canvas>
</div>
<script type="text/javascript">
$(document).ready(function(){
	getGraph();
	console.log("javascript 실행");
});

function getGraph(){
	var timeList =[];
	var posList =[];
	
	$.ajax({
		url:"./countGoods.do",
		type:"get",
		dataType:"json",
		success:function(data){
// 			console.log(data[0].pos_count);
		//그래프로 나타낼 데이터 리스트에 담기
		for(let i=0; i<data.length;i++){
			timeList.push(data[i].pos_time);//x축 data
			posList.push(data[i].pos_count);//y축 data
		}
// 		console.log(timeList);
// 		console.log(posList);
		//그래프
		new Chart(document.getElementById("myChart"),{
			type:"line",
			data:{
				labels:timeList,//x축 data
				datasets:[{
					data:posList,//y축 data
					label:"A상품",
					borderColor:"#3e95cd",
					fill:false
// 				    - false  : 아무것도 채워지지 않음
// 				    - origin : 기준점 사이로 채워짐 
// 				    - start : x축 선부터 채워짐
// 				    - end : x축의 최대값의 기준으로 채워짐
				}
			  ]
			},
			options:{
				title:{ 
					display:true,
					text:"상품판매량"
				},
				scales: {
		            y: {
		                beginAtZero: true //y축 시작점이 0으로 시작하는지
		            }
				}
			}
		});//그래프
		},
		error:function(err){
			alert("실패 에러메세지 : "+err);
		}
	})//ajax 
	
}//getGraph
</script>
</body>
</html>
