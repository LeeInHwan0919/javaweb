/**
 * Bike01
 */
$(function(){
	getJson();
	
});


function getJson(){
	console.log("작동");
	//text 파일의 경우는 text"{"a":"섭"}"를 읽어서 => JSON.parse("{"a":"섭"}");
	$.getJSON("../json/BikeLoc.json",function(data){
//		console.log(typeof data,data);
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
	});
	
}