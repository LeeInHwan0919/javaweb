function checkAll(bool){
	console.log(bool);
	var chs = document.getElementsByName("ch");
	for(let i = 0; i < chs.length; i++){
		chs[i].checked = bool;
	}
}





function chsConfirm(){
	var chs = document.getElementsByName("ch");
	var cnt = 0;
	for(let i = 0; i < chs.length; i++){
		if(chs[i].checked){
			cnt++;
		}
	}
	return cnt;
}


window.onload = function(){
	console.log("js onload");
	var chs = document.getElementsByName("ch");
	var allCheck = document.getElementById("allCheck");
	
	for(let i = 0; i < chs.length; i++){
		chs[i].onclick = function(){
			console.log(chs[i].value);
			if(chs.length == chsConfirm()){
				allCheck.checked = true;
			}else{
				allCheck.checked = false;
			}
		}
	}
}



function chsSubmit(){
   swal({
        title: "Are you sure?",
        text: "You will not be able to recover this imaginary file!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Yes, delete it!",
        cancelButtonText: "No, cancel plx!",
        closeOnConfirm: false,
        closeOnCancel: false 
    },
    function(isConfirm) {
        if (isConfirm) {
            swal("Deleted!", "Your imaginary file has been deleted.", "success");
        } else {
            swal("Cancelled", "Your imaginary file is safe :)", "error");
        }
    }
);
   return false;
}


function submitForm(){
	document.forms[0].submit;
}

function del(val){
	console.log("삭제",val);
	var con = confirm("선택된 글이 DB에서 삭제됩니다.");
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
}