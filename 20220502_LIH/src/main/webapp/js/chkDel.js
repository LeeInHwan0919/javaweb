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

function checkAlls(bool){
	$("input:checkbox[name='chk']").prop("checked",bool);
	console.log("check 갯수 : ",checkCount());
}

function checkCount(){
	var cnt = 0;
	var chks = document.getElementsByName("chk");
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
		alert("삭제오류","글을 한개 이상 선택하세요.");
		return false;
	}
}

	function del(seq){
		console.log("삭제 :",seq);
		location.href="./multiDel.do?chk="+seq;
	}

