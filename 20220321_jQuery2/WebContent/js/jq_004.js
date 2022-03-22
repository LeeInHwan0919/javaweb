function btn01(){
	//input tag중에서 type=text인 태그만 선택
	
	//javascript의 value는 empty element의 속성 "value"를 가져온다.
	//jQuery는 val()으로 가져옴
	//****절대 javascript와 jQuery문법을 혼합해서 사용하면 안됨
	//     ex) $(input:text).value (X)    ==> 혼종
	
	//value /val()
	//innerHTML / html()
	//textContent/ text()
	//입력 대입연산자 / argument로 전달
	var doc = $("input:text").val();
	console.log(doc);
}

function btn02(){
	var doc = $("input:radio").eq(1).val();
	console.log(doc);
//	var obj = $("input[type='text'][value='아이디']");
	$("input:radio").each(function(index,item){
		console.log(item.value);
	});
}

function btn03(){
	//checkbox의 상태는 :checked로 판단 할 수 있다.
	var doc = $("input[type=checkbox]:checked").val();
	console.log(doc);
}

$(function(){
	//jQuery에서는 event는 on으로 시작하지 않음
	$("select").change(function(){
		alert($("select option:selected").val());
	});
	
	var selEle = document.getElementsByTagName("select")[0];
	selEle.onchange = function(){
		alert(selEle.options[selEle.selectedIndex].value);
	}
	
	

});


function btn04(){
    //전체갯수
    var len = $("input:checkbox[name=isChk]").length;
    console.log(len);
    
    //선택갯수
    var chLen = $("input:checkbox[name=isChk]:checked").length;
    console.log(chLen);

    //전체체크
    //prop
    var len = $("input:checkbox[name=isChk]").prop("checked",true);

    //전체체크 for문
//    $("input:checkbox[name=isChk]").each(function(index,item){
//           
//     });
    $("input:checkbox[name=isChk]").each(function(){
           this.checked=true;
     });

    //is문법
    if($("input:checkbox[name=isChk]").is(":checked")==true){
     console.log("isChk 됨");
}


   }















