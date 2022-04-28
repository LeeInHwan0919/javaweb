// 세션의 저장되어 있는 row 의 값에 따른 listNum  의 갯수
$(document).ready(function(){
	var listNum = $("#listNum").val();
	
	$("#list option").each(function(){
		if(listNum == $(this).val()){
			$(this).prop("selected",true);
		}else{
			$(this).prop("selected",false);
		}
	})
})

// 해당 페이지번호를 클릭 했을 때 해당 값을 전송
function pageIndex(idx){
	console.log("입력 받은 index 값 : " + idx);
	var index = document.getElementById("index");
	index.value = idx - 1;
	pageAjax();
}

function pageFirst(){
	console.log("처음 페이지로 이동");
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	
	index.value = 0;
	pageNum.value = 1;
	pageAjax();
}

function pagePrev(pNum, pageList){
	console.log("이전 그룹");
	if(0 < pNum - pageList){
		pNum -= pageList;
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageNum");
		
		index.value = pNum - 1;
		pageNum.value = pNum;
	}
	
	pageAjax();
}


function pageNext(pNum,total, listNum, pageList){
	console.log("다음 페이지");
	var idx = Math.ceil(total/listNum); // 31/5 = 7
	var max = Math.ceil(idx/pageList); // 2 그룹
	
	if(max*pageList > pNum+pageList){
		pNum += pageList;
		
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageNum");
		
		index.value = pNum - 1;
		pageNum.value = pNum;
	}
	pageAjax();
}

function pageLast(pNum,total, listNum, pageList){
	console.log("마지막 페이지");
	var idx = Math.ceil(total/listNum); // 31/5 7 index
	var max = Math.ceil(idx/pageList); // 12345 | 67 => 2 묶음
	
	while(max*pageList > pNum+pageList){
		pNum += pageList;			
	}
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageNum");
		
		index.value = pNum - 1;
		pageNum.value = pNum;
		pageAjax();
}


// 글 갯수가 변할 때 동작
function pageList(){
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	var listNum = document.getElementById("listNum");
	
	index.value = 0;
	pageNum.value = 1;
	listNum.value = document.getElementById("list").value;
	
	console.log("pageList : " + listNum.value);
	pageAjax();
}



var pageAjax = function(){
	console.log("index 페이지 처리 Ajax")
	console.log($("#frm").serialize())
	$.ajax({
		url:"./page.do",
		type:"post",
		async:true,
		data:$("#frm").serialize(),
		dataType:"json",
		success:function(msg){
			console.log(msg);
		 	$.each(msg,function(key,value){
            var varHtml = "";
            var n = $(".table tr:eq(0) th").length;
            
            if(key=="lists"){
            varHtml += "<thead>                                                                  ";
            varHtml += "   <tr>                                                                 ";
            if(n == 7){
               varHtml += "      <th><input type='checkbox' id='checkAll' onclick='checkAll(this.checked)'></th>";
            }
            varHtml += "      <th>글번호</th>                                                  ";
            varHtml += "      <th>제목</th>                                                    ";
            varHtml += "      <th>작성자</th>                                                  ";
            varHtml += "      <th>조회수</th>                                                  ";
            if(n==7){
               varHtml += "      <th>삭제여부</th>                                                ";
            }
            varHtml += "      <th>작성일</th>                                                  ";
            varHtml += "   </tr>                                                                ";
            varHtml += "</thead>                                                                 ";
            
            varHtml +="<tbody>";
            $.each(value, function(k,v){
               varHtml +="<tr>                                                                                                                                ";
			   if(n==7){
	               varHtml +="  <td><input type='checkbox' name='chk' value='"+v.seq+"'></td>                                                                           ";			
				}
               varHtml +="  <td>"+v.seq+"</td>                                                                                                                        ";
               varHtml +="  <td>                                                                                                                              ";
               varHtml +="    <div class='panel-heading'><a data-toggle='collapse' data-parent='#accordion' href='#collapse"+v.seq+"'>"+replyImage(v.depth)+v.title+"</a></div>      ";
               varHtml +="  </td>                                                                                                                             ";
               varHtml +="  <td>"+v.id+"</td>                                                                                                                    ";
               varHtml +="  <td>"+v.readcount+"</td>                                                                                                                        ";
	               if(n==7){
				  	 varHtml +="  <th>"+v.delflag+"</th>                                                                                                                        ";	
					}
               varHtml +="  <td>"+v.regdate+"</td>                                                                                                      ";
               varHtml +="</tr>                                                                                                                               ";
               varHtml +="<tr>                                                                                                                                ";
               varHtml +="  <td colspan='"+n+"'>                                                                                                                  ";
               varHtml +="    <div id='collapse"+v.seq+"' class='panel-collapse collapse'>                                                                          ";
               varHtml +="      <div class='form-group'><label>내용</label><textarea rows='4' class='form-control' readonly=''>"+v.content+"</textarea></div>";
               varHtml +="      <div>                                                                                                                         ";
			   varHtml +=" <div class='form-group'>";
			   if(v.id == v.memid){
	               varHtml +="        <input type='button' class='btn btn-primary' value='수정' onclick='modify("+v.seq+")'>";				
				}
			   if(v.id == v.memid || n == 7){
	               varHtml +="        <input type='button' class='btn btn-primary' value='삭제' onclick='del("+v.seq+")'>";			
				}
			   if(n!= 7){
	               varHtml +="        <input type='button' class='btn btn-primary' value='답글' onclick='reply("+v.seq+")'>";
				}
			   varHtml += "</div>"
               varHtml +="      </div>                                                                                                                        ";
               varHtml +="    </div>                                                                                                                          ";
               varHtml +="  </td>                                                                                                                             ";
               varHtml +="</tr>                                                                                                                               ";
            });
				varHtml +="</tbody>";
            }else{
				varHtml += "	<li><a href='#' onclick='pageFirst()'><span class='glyphicon glyphicon-fast-backward'></span></a></li>    ";
				varHtml += "	<li><a href='#' onclick='pagePrev("+value.pageNum+","+value.pageList+")'><span class='glyphicon glyphicon-step-backward'></span></a></li>     ";
				for(let i = value.pageNum; i<=value.count; i++){
					if(value.index+1 == i){
					console.log("iiiiiii : " + i);
						varHtml += "<li class='active'>";
					}else{
						varHtml += "<li>"
					}
					varHtml += "	<a href='#' onclick='pageIndex("+i+")'>"+i+"</a></li>                                        ";
				}
				varHtml += "	<li><a href='#' onclick='pageNext("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'><span class='glyphicon glyphicon-step-forward'></span></a></li>      ";
				varHtml += "	<li><a href='#' onclick='pageLast("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'><span class='glyphicon glyphicon-fast-forward'></span></a></li>      ";
			}



			if(key == "lists"){
				$(".table").html(varHtml);
			}else{
				$(".pagination").html(varHtml);
			}
         });
		},
		error:function(){
			alert("잘못된 요청");
		}
	})
};

//답글 이미지 처리
function replyImage(depth) {
	
		var replyImg="";
		for (let i = 0; i < depth; i++) {
			replyImg +="&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		if(depth!=0) {
			replyImg +="<img src='./images/reply.png'/>";
		}
		console.log(replyImg);
		return replyImg;
	}

//새글 작성
function writeBoard(){
	console.log("글작성");
	//화면을 구성해서 append 처리
	showWrite();
	$("#write").modal({backdrop: 'static', keyboard: false});
}

var showWrite = function(){
	html = "";
	 html += " <div class='form-group'>                                      ";
	 html += "   <label for='id'>아이디:</label>                   ";
	 html += "   <input type='text' class='form-control' id='id' name='id' placeholder='Enter id' readonly>        ";
	 html += " </div>                                                        ";
	 html += " <div class='form-group'>                                      ";
	 html += "   <label for='title'>제목:</label>                          ";
	 html += "   <input type='text' class='form-control' name='title' id='title' required>       ";
	 html += " </div>                                                        ";
	 html += " <div class='form-group'>                                        ";
	 html += "   <label for='content'> 내용</label>          ";
	 html += "   <textarea class='form-control' row='5' id='content' name='content'></textarea>          ";
	 html += " </div>";
	 html += " <div class='modal-footer'> ";
	 html += " <input type='button' class='btn btn-success' value='새글입력' onclick='writeVal()'>";                                                        
	 html += " <input type='reset' class='btn btn-info' value='초기화'>";                                                        
	 html += " <button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";                                                        
	 html += " </div>       ";                                       
	 $("#frmWriter").html(html);          
}


function writeVal(){
	console.log("새글작성 버튼 클릭");
	var frmWriter = document.getElementById("frmWriter");
	frmWriter.action="./write.do";
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	
	const extractTextPattern = /(<([^>]+)>)/gi;
	let convertTitle = title.value.replace(extractTextPattern, '');
	title.value = convertTitle;
	console.log("변경된 title 값 :"+convertTitle);
	
	if(title.value.trim()==""){
		swal("새글작성 오류","제목은 필수 값 입니다. ");
		title.value="";
	}else{
		frmWriter.submit();
	}
}

//글 수정하기
function modify(seq){
	console.log("선택된 글번호"+"글수정 : "+seq);
	//DOM탐색을 ID나 class를 가지고 하는게 아니라 속성의 값(글자)를 탐색하여 선택함
	// ~= : 일치값, *= 포함값 
	var id = "[href*=collapse22]";
	$(id).css("background","yellow");
	ajaxModify(seq);
	
	//뒤 에 눌리면 닫히는것이 싫은 규철
	$("#modify").modal({backdrop: 'static', keyboard: false});
}

//규철이가 하고싶은거
function modalHide(){
	$("#modify").modal("hide");
}

var ajaxModify = function(seq){
	console.log("ajaxModify",seq);
	
	$.ajax({
		url:"./modifyForm.do",
		method:"post",
		data:"seq="+seq,
		success:function(msg){
			console.log(msg,typeof msg);
			var json = JSON.parse(msg);
			console.log(json,typeof json);
			
	html = "";
	html += " <div class='form-group'>                                      ";
	html += "   <label for='id'>아이디:</label>                   ";
	html += "   <input type='hidden' name='seq' value='"+json.seq+"'>       ";
	html += "   <b class='form-control'>"+json.id+"</b>       ";
	html += " </div>                                                        ";
	
	html += " <div class='form-group'>                                      ";
	html += "   <label for='regdate'>작성일:</label>                   ";
	html += "   <b class='form-control'>"+json.regdate+"</b>       ";
	html += " </div>                                                        ";
	
	html += " <div class='form-group'>                                      ";
	html += "   <label for='title'>제목:</label>                   ";
	html += "   <input type='text' class='form-control' id='title' name='title' required value='"+json.title+"'>       ";
	html += " </div>  ";
	
	html += " <div class='form-group'>                                        ";
	html += "   <label for='content'>:내용</label>          ";
	html += "   <textarea class='form-control' row='5' id='content' name='content'>"+json.content+"</textarea>          ";
	html += " </div>";
	
	html += " <div class='modal-footer'> ";
	html += " <input type='button' class='btn btn-success' value='글수정' onclick='modifyVal("+seq+")'>";   
	html += " <input type='reset' class='btn btn-info' value='초기화'>";                                                        
	html += " <button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";                                                        
	html += " </div>       "; 
	                                 
	 $("#frmModify").html(html);          
			
		},
		error:function(){
			alert("잘못된 요청처리");
		}
	})
	
	
}

function modifyVal(){
	var frm = $("#frmModify");
	var idx = document.getElementById("index").value;
	
	console.log(frm.serialize());
	console.log(idx);
		$.ajax({
			url:"./modify.do",
			type:"post",
			data:frm.serialize(),
			success:function(msg){
				console.log("msg값은 : ",msg);
				if(msg.isc=="true"){
					$("#modify").modal("hide");
					pageIndex(idx+1);
				}else{
					location.href="./logout.do";
				}
			},
			error:function(){
				console.log("잘못된 요청 처리");
			}
		});
	

}


//========================답글 달기===========================//
//글 수정하기
function reply(seq){
	console.log("선택된 글번호"+"글수정 : "+seq);
	ajaxReply(seq);
	$("#reply").modal();
}



var ajaxReply = function(seq){
	console.log("ajaxReply",seq);
	
	$.ajax({
		url:"./replyForm.do",
		type:"post",
		data:{"seq":seq},
		dataType:"json",
		success:function(r){
			console.log("RRRR:",r);
	 	$("#frmReply").html("");
//	 	html += " <div class='form-group'>                                      ";
//		html += "   <label for='id'>아이디:</label>                   ";
//		html += "   <input type='hidden' name='seq' value='"+json.seq+"'>       ";
//		html += "   <b class='form-control'>"+json.id+"</b>       ";
//		html += " </div>                                                        ";



//	 	var div = $("<div>").attr("class","form-group");
//	 	var input = $("<input>").attr({"type":"hidden","name":"seq","value":r.obj.seq});
//	 	var label = $("<label></label>").text("부모글 정보("+r.obj.seq+")");
//		var p = $("<p>").attr("class","form-control").text("조회수/"+r.obj.readcount+"작성일/"+r.obj.regdate+"작성자/"+r.obj.id);
//		
//		div.append(input).append(label).append(p);
//		
//		$("#frmReply").append(div);
		
		html = "";
		html += "<div class='form-group'>";
		html += "<input type='hidden' name='seq' value='"+r.obj.seq+"'>";
		html += "<label>부모글의 정보("+r.obj.seq+")</label>";
		html += "<b>조회수:"+r.obj.readcount+" / 작성일:"+r.obj.regdate+" / 작성자:"+r.obj.id+" </b>";
		html += "</div>";
		
		html += "<div class='form-group'>";
		html += "<label>작성자</label>";
		html += "<b>"+r.sessionId+"</b>";
		html += "</div>";
		
		html += "<div class='form-group'>";
		html += "<label id='tit'>제목(원본)</label>";
		html += "<input type='text' class='form-control' id='title' name='title' value='"+r.obj.title+"'>";
		html += "</div>";
		
		html += "<div class='form-group'>";
		html += "<input type='hidden' id='hiddenContent' name='title' value='"+r.obj.content+"'>";
		html += "<label id='con'>내용(원본)</label>";
		html += "<textarea rows='5' class='form-control' id='Textarea' name='content' onclick='chk()'>"+r.obj.content+"</textarea>";
		html += "</div>";
		
		html += " <div class='modal-footer'> ";
		html += " <input type='button' class='btn btn-success' value='답글 작성' onclick='replyVal()'>";   
		html += " <sapn onclick='reset()'><input type='reset' class='btn btn-info' value='초기화'></sapn>";                                                        
		html += " <button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";                                                        
		html += " </div>       "; 
		
		$("#frmReply").html(html);		
		},
		error:function(){
			alert("잘못된 요청처리 값");
		}
	})
	
	
}

function reset(){
	console.log("reset consple.log입니다.");
	document.getElementById("tit").innerHTML="제목(원본)";
	document.getElementById("con").textContent="내용(원본)";
}


function chk(){
	var tit =document.getElementById("tit");
	var con = document.getElementById("con");
	var title = document.getElementById("title");
	var Textarea = document.getElementById("Textarea");
	
	var hiddenContent = document.getElementById("hiddenContent");
	
	console.log(tit, con, title, Textarea, hiddenContent);
	
	if(Textarea.value==hiddenContent.value){
		con.innerHTML="답글";
		tit.innerHTML="답글내용";
		Textarea.value="";
		title.value="";
	}
}


function replyVal(){
	
	var tit =document.getElementById("tit").textContent; //제목(원본) -> 답글 제목
	console.log(tit);
	if(tit=="제목(원본)"){
		swal("답글 작성 오류","제목과 내용을 작성해 주세요.");
		return;
	}
	
	var parentSeq = document.getElementsByName("seq")[0].value;
	var title = document.getElementById("title");
	var content = document.getElementsByName("content")[0];
	const extractTextPattern = /(<([^>]+)>)/gi;
	let convertTitle = title.value.replace(extractTextPattern, '');
	let convertContent = content.value.replace(extractTextPattern, '');
	console.log(convertTitle,convertContent);	
	
	$.ajax({
		url:"./reply.do",
		type:"post",
		data:{"seq":parentSeq,"title":convertTitle,"content":convertContent},
		success:function(msg){
			console.log(msg)
			if(msg.isc=="true"){
				pageAjax();
				$("#reply").modal("hide");
			}else{
				swal("답글 작성 오류","다시 작성해 주세요.");
			}
		},
		error:function(){
			alert("잘못된 요청 처리");
		}
		
	});
	
	

}



