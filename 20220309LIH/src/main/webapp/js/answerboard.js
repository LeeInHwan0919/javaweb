/*
 thead에 있는 checkBox를 눌렀을 경우 하위에 있는 checkbox를 모두 true/false
 */
 function checkAll(bool){
 	console.log(bool);
	var chs = document.getElementsByName("ch");
	for(let i = 0; i<chs.length;i++){
		chs[i].checked = bool;
	}
 }



$(document).ready(function(){
	console.log("ready");
	$(".allCheckBox").click(function(){
		console.log("jquery", this.checked);
		$(".ch").attr("checked",this.checked);
		});		
	});
	
	/*
		하위 checkBox의 선택된 갯수를 판단하는 function
	*/
	
	function chsConfirm(){
		var chs = document.getElementsByName("ch");
		var cnt = 0;
		for(let i = 0; i<chs.length; i++){
			if(chs[i].checked){
				cnt++;
			}
		}
		return cnt;
	}
	
/*
	하위에 모든 checkbox가 체크가 된다면 모두 체크, 아닌 경우 thead에 있는 checkBox를 false로 만든다
	아닌경우 thead에 있는 checkbox를 false로 만듬
*/


window.onload = function(){
	console.log("js onload");
	var chs = document.getElementsByName("ch");
	var allChecked = document.getElementById("allCheck");
	
	for(let i = 0; i<chs.length; i++){
		chs[i].onclick = function(){
			console.log(chs[i].value);
			if(chs.length==chsConfirm()){
				allCheck.checked = true;
			}else{
				allCheck.checked= false;
			}
		}
	}
}


/**submit을 통해서 작동시 ch의 갯수를 판단하여 submit의 동작을 제어 */


//일반적인 alert 처리방식
//function chsSubmit(){
//	let chsCnt = chsConfirm();
//	console.log(chsCnt);
//	if(!(chsCnt > 0)) {
//		alert("한개 이상의 글을 선택해야 합니다");
//		return false;
//	}
//}

//https://sweetalert.js.org/ =>confirm을 사용하여 처리 => callback
function chsSubmit(){
	var isc = false;
	if(chsConfirm() >0){
		swal({
        title: "다중삭제",
        text: "삭제 하시겠습니까?",
        type: "warning",
        showCancelButton: true,
//        confirmButtonColor: "#DD6B55",
		confirmButtonClass : 'btn-danger',
        confirmButtonText: "삭제",
        cancelButtonText: "취소",
        closeOnConfirm: true,
        closeOnCancel: false 
    },

    function(isConfirm) {
		
	
        if (isConfirm) {
            swal("삭제", "삭제", "success");
			submitForm();
        } else {
            swal("취소", "취소", "error");
        } 
    }
);
}else{
	swal("", '선택된 글이 없습니다');
	
}	
	console.log('chsSubmit 마지막라인')
	return false;
	}
	/*
	javascript document를 통해서 submit()함수를 실행
	기존 형태 : input[type='submit'] -> <form action="">
	*/
	function submitForm(){
		document.forms[0].submit();
	}
		
	//=================================//
//=============boardDetail 답글/수정/삭제=============//
//=================================//

function del(val){
	console.log("삭제",val);
}	
function modify(val){
	console.log("수정",val);
}	
function reply(val){
	console.log("답글",val);
}	