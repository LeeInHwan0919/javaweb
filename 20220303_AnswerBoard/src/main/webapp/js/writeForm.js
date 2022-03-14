document.onkeydown = function() {
	//새로고침 방지
	if (event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82 || event.keyCode == 116)) {
//		event.ctrlKey == true  컨트롤키를 눌렀을 때
//		event.keyCode == 78  N 새창
//		event.keyCode == 82 R 새로고침
//		event.keyCode == 116  F5키
	}
}