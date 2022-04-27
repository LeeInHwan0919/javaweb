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
	var id = "[href*=collapse22]";
	$(id).css("background","yellow");
	showModify(seq);
	$("#modify").modal({backdrop: 'static', keyboard: false});
}

function modalHide(){
	$("#modify").modal("hide");
}

var showModify = function(seq){
	mhtml = "";
	mhtml += " <div class='form-group'>                                      ";
	mhtml += "   <label for='id'>아이디:</label>                   ";
	mhtml += "   <input type='text' class='form-control' id='id' name='id' placeholder='Enter id' readonly>        ";
	mhtml += " </div>                                                        ";
	mhtml += " <div class='form-group'>                                      ";
	mhtml += "   <label for='title'>수정 할 제목:</label>                          ";
	mhtml += "   <input type='text' class='form-control' name='title' id='title' required>       ";
	mhtml += " </div>                                                        ";
	mhtml += " <div class='form-group'>                                        ";
	mhtml += "   <label for='content'>수정 할 내용</label>          ";
	mhtml += "   <textarea class='form-control' row='5' id='content' name='content'></textarea>          ";
	mhtml += " </div>";
	mhtml += " <div class='modal-footer'> ";
	mhtml += " <input type='button' class='btn btn-success' value='수정 글 입력' onclick='modifyVal("+seq+")'>";   
	mhtml += " <input type='reset' class='btn btn-info' value='초기화'>";                                                        
	mhtml += " <button type='button' class='btn btn-default' data-dismiss='modal'>수정 취소</button>";                                                        
	mhtml += " </div>       ";                                       
	 $("#frmModify").html(mhtml);          
}

function modifyVal(seq){
	console.log("새글작성 버튼 클릭");
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
		$.ajax({
			url:"./modify.do",
			type:"post",
			data:{"title":title.value,"content":content.value,"seq":seq},
			dataType:"json",
			success:function(msg){
				console.log("msg값은 : ",msg);
				if(msg>0){
					console.log("성공");
					swal("수정 성공");
					modalHide();
					pageAjax();
				}else{
					swal("수정 실패");
					modalHide();
					pageAjax();
				}
			}
				
			,
			error:function(err){
				console.log("실패");
			}
				
			
			
		});
	}
}






