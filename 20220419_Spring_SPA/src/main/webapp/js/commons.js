// checkbox의 체크
//document.getElementsByName("chk")[0].checked = true;
// $("#chkall").prop('checked',true);
// $("input:checkbox[name='chk']").prop('checked',true)

//checkbox의 상태여부
//document.getElementsByName("chk")[0].checked == true;
// $("#chkall").prop('checked')==true;
// $(".chk").is(":checked");

// chk의 체크 상태에 따라서 checkAll의 상태 변경
window.onload = function(){
	var chks = document.getElementsByName("chk");
	var checkAll = document.getElementById("checkAll");
	for(let i=0;i<chks.length;i++){
		chks[i].onclick = function(){
			if(chks.length==checkCount()){
				checkAll.checked = true;
			}else{
				checkAll.checked = false;
			}
		}
	}
}

// 전체 체크 버튼

function checkAlls(bool){
//	var chks = document.getElementsByName("chk");
//	for(let i=0; i<chks.length;i++){
//		chks[i].checked = bool;
//	}
	$("input:checkbox[name='chk']").prop("checked",bool);
	console.log("check 갯수 : ",checkCount());
}

// 선택된 checked를 확인하는 함수
function checkCount(){
	var cnt = 0;
	var chks = document.getElementsByName("chk");
//	for(let o in chks){
//		console.log("o는 chk의 인덱스 in : " + o);
//		chks[o].checked
//	}	
	for(let o of chks){
		console.log("o는 object of"+o);
		if(o.checked){
			cnt++;
		}
	}	
	return cnt;
	
}


function chkBox(){
	var chks = $("input:checkbox[name='chk']:checked");
	console.log("chks.length : ",chks.length);
	if(chks.length>0){
		document.getElementById("frm").action="./multiDel.do";
	}else{
		swal("삭제오류","한개 이상의 글을 선택하세요.");
		return false;
	}
	
	
	
		
}

function del(seq){
		console.log("seq의 값 : ",seq);
		location.href="./multiDel.do?seq="+seq;
	}
	

