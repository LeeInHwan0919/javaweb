//document.onkeydown = function(){
//	//새로 고침 방지
//	if(event.ctrlKey == true && (event.ctrlKeyCode == 78 || event.ctrlKeyCode == 82) || event.keyCode == 116){
////		event.ctrlKey = true 컨트롤키 눌렀을때
////		event.ctrlKeyCode == 78 N 새ㅇ창
////		event.ctrlKeyCode == 82 R 새로고침
////		event.keyCode == 116 F5 키
//
//		event.keyCode = 0;
//		event.cancelBubble = true;
//		event.returnValue = false;
//	}
//}


var isShow = true;
// 창이 닫혔을때
window.onbeforeunload = function(){
	if(isShow){		
		return "화면을 벗어납니다";
	}
}

function validationForm(){
	//exec iframe의 값을 뺴오는 역할 - editor는 무조건 iframe
	 oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

	var wform = document.wform;
	
	var id = document.getElementById("id");
	var title = document.getElementById("title");
	var content = document.getElementById("ir1");
	
	console.log(id,title,content);
	if(id.value == "" || title.value == "" || content.value == ""){
		alert("필수 값을 입력해 주세요");
	}else{
		isShow = false;
		var str = content.value;
//		str = str.replace(/\r\n|\r|\n|\n\w\r/g,'<br>');
//		str = str.replace(/</gim,'&lt');
//		str = str.replace(/>/gim,'&gt');
//		str = str.replace(/\"/gim,'&quot');
//		str = str.replace(/\'/gim,'&#39;');
//		document.getElementById("convertView").innerHTML = str;
		//g 글로벌 i 대소문자 m 여러줄
		
		wform.submit();
	}
}