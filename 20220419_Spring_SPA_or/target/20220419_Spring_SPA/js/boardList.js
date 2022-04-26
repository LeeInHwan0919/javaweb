//해당 페이지 번호를 클릭했을때 해당 값을 전송
function pageIndex(idx){
	console.log("입력 받은 인덱스 값 : "+idx);
	var index = document.getElementById("index");	
	index.value = idx-1;
	pageAjax();
}

var pageAjax = function(){
	console.log("index 페이지 처리 Ajax");
	$.ajax({
		url:"./page.do",
		type:"post",
		async:true,
		data:$("#frm").serialize(),
		dataType:"json",
		success : function(msg){
			
		},
		error:function(){
			alert("잘못된 요청 처리")		
		}
	});
}


	
