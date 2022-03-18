$(function(){
	parseJSON();
});

function parseJSON(){
	console.log("parseJSON 작동")
	$.getJSON("./json/BikeLoc.json",function(data){
//		console.log(typeof data, data);
	$.ajax({
		url:"./bikeCtrl.do",
		type:"post",
		data:{"obj":JSON.stringify(data),"command":"second_db"},
		success:function(msg){
			console.log("전송된 결과 값"+msg);
			if(msg>0){
				$.each(data,function(key, value){
			$("table").attr("border","1px");
			if(key=="DESCRIPTION"){
				//value => JSONObject
				$("thead").append("<tr><td>"+value.NEW_ADDR+"</td><td>"+value.CONTENT_ID+"</td><td>"+value.ADDR_GU+"</td><td>"+value.LONGITUDE+"</td><td>"+value.CRADLE_COUNT+"</td><td>"+value.LATITUDE+"</td><td>"+value.CONTENT_NM+"</td></tr>");
			}else if(key == "DATA"){
				var dList = value;//여러개의 DATA 묶음 JSONArray
				for(let i=0; i<dList.length; i++){
                    var oneData = dList[i];
                    $("tbody").append("<tr><td>"+oneData.NEW_ADDR+"</td><td>"+oneData.CONTENT_ID+"</td><td>"+oneData.ADDR_GU+"</td><td>"+oneData.LONGITUDE+"</td><td>"+oneData.CRADLE_COUNT+"</td><td>"+oneData.LATITUDE+"</td><td>"+oneData.CONTENT_NM+"</td>"+
                    "<input type='hidden' name='bike' value='"+oneData.NEW_ADDR+"/"+oneData.CONTENT_ID+"/"+oneData.ADDR_GU+"/"+oneData.LONGITUDE+"/"+oneData.CRADLE_COUNT+"/"+oneData.LATITUDE+"/"+oneData.CONTENT_NM+"'>"+"</tr>");

                }
			}
		});
			}else{
				alert("테이블이 생성되지 않았습니다.");
			}
			
		},
		error: function(){
			console.log("잘못된 접근");
		}
	});
	
	});
}