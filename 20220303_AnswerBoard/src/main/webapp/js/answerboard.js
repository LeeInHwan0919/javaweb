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
        text: "삭제할거야?",
        type: "warning",
        showCancelButton: true,
//        confirmButtonColor: "#DD6B55",
		confirmButtonClass : 'btn-danger',
        confirmButtonText: "응 지우면 그만이야~",
        cancelButtonText: "응 안지워~",
        closeOnConfirm: true,
        closeOnCancel: false 
    },

    function(isConfirm) {
		
	
        if (isConfirm) {
            swal("응 지울거야~", "지워버리면 그만이야~", "success");
			submitForm();
        } else {
            swal("응 안지울거야~", "응 취소하면 그만이야", "error");
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
	var con = confirm("선택된 글이 DB에서 삭제 됩니다.");
	if(con){
		location.href="boardDelete.do?seq="+val;
	}else{
		alert("삭제가 취소되었습니다.");
	}
}	
function modify(val){
	console.log("수정",val);
	location.href="./boardModify.do?seq="+val;
}	
function reply(val){
	console.log("답글",val);
	location.href="./boardAnswer.do?seq="+val;
	
}	

function contentCheck(){
	var obj1 = document.getElementById("hideContent").value;
	var obj2 = document.getElementById("txtArea").value;
	console.log(obj2);
	var obj3 = obj2.replace("원본글>","");
	if(obj1==obj3){
		document.getElementById("txtArea").value = "";
		document.getElementById("contxt").innerHTML="내용";
		document.getElementById("chkContent").value="N";
	}
}

function resetValue(){
	document.getElementById("contxt").innerHTML = "내용<br>(원본)";
	document.getElementById("chkContent").value = Y;
}

function checkCon(){
	var chk = document.getElementById("chkContent").value;
	if(chk=="Y"){
		alert("내용을 작성해 주세요");
		//document.getElementById("txtArea").focus;
		return false;
	}
}