//Session에 저장되어 있는 row의 값에 따른 ListNum의 갯수
$(document).ready(function(){
   var listNum = $("#listNum").val();
   
   $("#list option").each(function(){
      if(listNum == $(this).val){
         $(this).prop("selected",true);
      }else{
         $(this).prop("selected",false);
      }
   });
   }
);




//해당 페이지 번호를 클릭했을때 해당 값을 전송

function pageIndex(idx){
   console.log("입력받은 index 값",idx);
   var index = document.getElementById("index");
   index.value = idx-1;
   pageAjax();
}

// 글 갯수가 변할 때 
function pageList(){
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   var listNum = document.getElementById("listNum");
   
   index.value = 0;
   pageNum.value = 1;
   listNum.value = document.getElementById("list").value;
   
   console.log("pageList : ", listNum.value);
   pageAjax();
}

function pageFirst(){
   console.log("처음페이지로 이동");
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   
   index.value = 0;
   pageNum.value = 1;
   pageAjax();
}

function pagePrev(pNum, pageList){
   console.log("이전 그룹");
   if(0 < pNum-pageList){
      pNum -= pageList;
      var index = document.getElementById("index");
      var pageNum = document.getElementById("pageNum");
      
      index.value = pNum-1;
      pageNum.value = pNum;
     pageAjax();
   }
}

function pageNext(pNum, total, listNum, pageList){
   console.log("다음페이지");
   var idx = Math.ceil(total/listNum); //31/5 => 7
   var max = Math.ceil(idx/pageList); //2그룹
   
   if(max*pageList > pNum+pageList){
      pNum+=pageList;
      
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   
   index.value = pNum-1;
   pageNum.value = pNum
   }
   pageAjax();
}

function pageLast(pNum,total,listNum,pageList){
   console.log("마지막 페이지");
   var idx = Math.ceil(total/listNum); // 31/ 5 -> 7 index
   var max = Math.ceil(idx/pageList);  // 12345 | 67-> 2그룹
   
   while(max*pageList > pNum+pageList){
      pNum += pageList;
   }
   
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   
   index.value=idx-1;
   pageNum.value=pNum;
   
   pageAjax();
}


var pageAjax = function(){
//   console.log("index 페이지 처리 ajax");
//   var obj=$("#frm").serialize();
//   console.log(obj);
     $.ajax({
      url:"./page.do",
      type:"post",
      async:true,
      data:$("#frm").serialize(),
      dataType:"JSON",
      success:function(msg){
         console.log(msg);
      $.each(msg,function(key,value){
         var varHtml ="";
         var n = $(".table tr:eq(0) th").length;
         
         if(key=="lists"){                                                                         
            varHtml += "<thead>                                                                   ";
                varHtml += "  <tr>                                                                    ";
            if(n ==7){
                   varHtml += "     <th><input type='checkbox' id='checkAll' onclick='checkAll(this.checked)'></th>    ";
            }
                varHtml += "     <th>글 번호</th>                                                     ";
                varHtml += "     <th>제목</th>                                                        ";
                varHtml += "     <th>작성자</th>                                                      ";
                varHtml += "     <th>조회수</th>                                                      ";
            if(n ==7){
             varHtml += "     <th>삭제여부</th>                                                    ";
            }               
                varHtml += "     <th>작성일</th>                                                      ";
                varHtml += "  </tr>                                                                   ";
                varHtml += "</thead>                                                                  ";

            varHtml += "<tbody>";
            
            $.each(value, function(k,v){
               varHtml+="   <tr>";
               if(n==7){
               varHtml+="      <td><input type='checkbox' name='chk' value='"+v.seq+"'></td>                                                              ";
               }
               varHtml+="      <td>1</td>                                                                                                           ";
               varHtml+="      <td>                                                                                                                 ";
               varHtml+="      <div class='panel-heading'><a data-toggle='collapse' data-parent='#accordion' href='#collapse"+v.seq+"'>"+replyImage(v.depth)+v.title+"</a></div>";
               varHtml+="      </td>                                                                                                                ";
               varHtml+="      <td>"+v.id+"</td>                                                                                                      ";
               varHtml+="      <td>"+v.readcount+"</td>";
               if(n==7){
                  varHtml+="      <td>"+v.delflag+"</td>                                                                                                    ";
               }                                                                                                           
               varHtml+="      <td>"+v.regdate+"</td>                                                                                         ";
               varHtml+="   </tr>                                                                                                                   ";
               varHtml+="   <tr>                                                                                                                    ";
               varHtml+="      <td colspan="+n+" style='padding-top:0px;padding-bottom:0px;'>                                                         ";
               varHtml+="         <div id='collapse"+v.seq+"' class='panel-collapse collapse'>                                                            ";
               varHtml+="            <div class='form-group'>                                                                                       ";
               varHtml+="            <label>내용</label>                                                                                         "; 
               varHtml+="            <textarea rows='4' class='form-control' readonly='readonly'> "+v.content+"</textarea></div>              ";
               varHtml+="            <div>                       ";
            varHtml += "<div class='form-group'>";
               if(v.id == v.memid){
                     varHtml+="            <input type='button' class='btn btn-primary' value='삭제' onclick='del("+v.seq+")'>";
               }                               
               if(v.id==v.memid || n==7){
                        varHtml+="            <input type='button' class='btn btn-primary' value='수정' onclick='modify("+v.seq+")'>";
               }
               if(n!=7){
                        varHtml+="            <input type='button' class='btn btn-primary' value='답글' onclick='reply("+v.seq+")'> ";
               }
               varHtml += "</div>";
               varHtml+="            </div>                                                                                                         ";                                                                                                              
               varHtml+="         </div>                                                                                                            ";                                                                                                              
               varHtml+="      </td>                                                                                                                ";                                                                                                              
               varHtml+="   </tr>                                                                                                                   ";                                                                                                              
                  
            });
            varHtml +="</tbody>";
         }else{
            varHtml += " <li><a href='#' onclick='pageFirst()'><span class='glyphicon glyphicon-backward'></span></a></li>    ";
            varHtml += " <li><a href='#' onclick='pagePrev("+value.pageNum+","+value.pageList+")'><span class='glyphicon glyphicon-chevron-left'></span></a></li> ";
               for(let i=value.pageNum; i<=value.count; i++){
                  if(value.index+1 == i){
                     varHtml += "<li class='active'>";
                  }else{
                     varHtml += " <li >";
                  }
                  varHtml += "<a href='#' onclick='pageIndex("+i+")'>"+i+"</a></li>                                   ";
               }
            varHtml += " <li><a href='#' onclick='pageNext("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
            varHtml += " <li><a href='#' onclick='pageLast()'><span class='glyphicon glyphicon-forward'></span></a></li>      ";
   
      }
      
         if(key == "lists"){
            $(".table").html(varHtml);
         }else{
            $(".pagination").html(varHtml);
      }
         
      });

      },
      error:function(){
         alert("잘못된 요청 처리");
      }
   });
}
//답글 이미지 처리
function replyImage(depth){
   console.log(depth);
   var replyImg="";
   for(let i = 0; i<depth; i++){
      replyImg+="&nbsp;&nbsp;&nbsp;&nbsp;";
   }
   if(depth!=0){
      replyImg +="<img src='./images/reply.png'>";
   }
   console.log(replyImg);
   return replyImg;
}


//새글작성
function writeBoard(){
   console.log("글작성");
   //화면을 구성해서 append 처리
   showWrite();
   $("#write").modal({backdrop: 'static', keyboard: false});
   
}

//---------------------------------------------------------------------------------------------------------
//글 수정

function modify(seq){
   console.log("선택된 글번호" + seq);
   //선택된 돔탐색을 ID나 class .. 아니라 속성의 값(글자)를 탐색하여 선택함
   // ~=: 일치값, *=포함값 Tilde
   var id = "[href*=collapse143]";
//   $(id).css("background","yellow");
   ajaxModify(seq);
   //뒤에 눌리면 자동으로 닫기지않음
   $("#modify").modal({backdrop: 'static', keyboard: false});
}

function modalHide(){
   $("#modify").modal("hide");
}

var ajaxModify = function(seq){
   console.log("ajaxModify",seq);
   $.ajax({
      url: "./modifyForm.do",
      method:"post",
      data:"seq="+seq,
//      dataType:"json",
      success:function(msg){
         console.log("---------------");
         console.log(msg, typeof msg);
         var json = JSON.parse(msg);
         console.log(json);
         html = "";
         html += "<div class='form-group'>                                     ";
         html += "  <label for='id'>아이디 :</label>                         ";
         html += "  <input type='hidden' name='seq' value='"+json.seq+"'>";
         html += "  <b style='text-align:left;' class='form-control'>"+json.id+"</b>     ";
         html += "</div>                                                       ";
         
         html += "<div class='form-group'>                                     ";
         html += "  <label for='regdate'>작성일 :</label>                         ";
         html += "  <b style='text-align:left;' class='form-control'>"+json.regdate+"</b>     ";
         html += "</div>                                                       ";
         
         html += "<div class='form-group'>                                     ";
         html += "  <label for='title'>제목 :</label>                         ";
         html += "  <input style='text-align:left; type='text' class='form-control' id='title' name='title' required value='"+json.title+"'>";
         html += "</div>                                                       ";
         
         html += "<div class='form-group'>                                       ";
         html += "  <label for='content'>내용 :</label>                         ";
         html += "  <textarea class='form-control' row='5' name='content' id='content'>"+json.content+"</textarea>      ";
         html += "</div>                                                       ";
         
         
         html +="<div class='modal-footer'>                                                         ";
          html +="  <input type='button' class='btn btn-success' value='글 수정' onclick='modifyVal()'>";
          html +="  <input type='reset' class='btn btn-info' value='초기화'>";
          html +="  <button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";
          html +="</div>                                                                             ";

         $("#frmModify").html(html);
      },
      error:function(){
         alert("잘못된 요청 처리");
      }
      
   });
}

function modifyVal(){
   var frm = $("#frmModify")
   var idx = document.getElementById("index").value;
//   console.log(frm.serialize());
//   console.log(idx);
   $.ajax({
      url : "./modify.do",
      type : "post",
      data : frm.serialize(),
      success : function(msg){
         console.log(msg)
         if(msg.isc == "true"){
            $("#modify").modal("hide");
            pageAjax();
         }else{
            location.href="./logout.do";
         }
      },error:function(){
         alert("잘못된 요청 처리");
      }
       
   });
}

//---------------------------------------------------------------------------------------------------------
var showWrite = function(){
   html = "";
       html += " <div class='form-group'>";
       html += "   <label for='id'>아이디 : </label>";
       html += "   <input type='email' class='form-control' id='id' readonly value=''>";
       html += " </div>";
       html += " <div class='form-group'>";
       html += "   <label for='title'>제목 : </label>";
       html += "   <input type='text' class='form-control' name='title'  id='title' required>";
       html += " </div>";
       html += " <div class='form-group'>";
       html += "   <label for='title'>내용 : </label>";
       html += "   <textarea class='form-control' row = '5'  name='content'  id='content'></textarea>";
       html += " </div>"
       html += "   <div class='modal-footer'>                                                        ";
       html += "    <input type='button' class='btn btn-success' value='새글입력' onclick='writeVal()'>";
      html += "    <input type='reset' class='btn btn-info' value='초기화'>";
      html += "    <button type='button' class='btn btn-danger' data-dismiss='modal'>취소</button>";
        html += "  </div>                                                                             ";
   $("#frmWriter").html(html);
}
//------------------------------------------------------------------------------------------


function writeVal(){
   console.log("새글작성");
   var frmWriter = document.getElementById("frmWriter");
   frmWriter.action = "./write.do";
   var title = document.getElementById("title");
   var content = document.getElementById("content");
   
   const extractTextPattern = /(<([^>]+)>)/gi;
   let convertTitle = title.value.replace(extractTextPattern,'');
   title.value = convertTitle;
   console.log("변경된 title 값 :",convertTitle);
   if(title.value.trim() == ""){
      swal("새글작성 오류","제목은 필수값 입니다");
      title.value="";
   }else{
      frmWriter.submit();
   }
}

//-------------------------------------
//답글
function reply(seq){
   console.log(seq);
   ajaxReply(seq);
   $("#reply").modal();
}

var ajaxReply = function(seq){
   $.ajax({
      url:"./replyForm.do",
      type:"post",
      data:{"seq":seq},
      dataType:"json",
      success:function(r){
         console.log(r);
         $("#frmReply").html("");
//         html += " <div class='form-group'>";
//          html += "   <label for='id'>아이디 : </label>";
//          html += "   <input type='email' class='form-control' id='id' readonly value=''>";
//          html += " </div>";

//         var div = $("<div>").attr("class","form-group");
//         var input = $("<input>").attr({"type":"hidden","name":"seq","value":r.obj.seq});
//         var label = $("<label></label>").text("부모글 정보("+r.obj.seq+")");
//         var p = $("<p>").attr("class","form-control").text("조회수 /"+r.obj.readcount + " 작성일 / " + r.obj.regdate + "작성자 / "+r.obj.id);
//         div.append(input).append(label).append(p);
//         $("#frmReply").append(div);
         
         html ="";
         html += "<div class='form-group'>";
         html += "<input type='hidden' name='seq' value='"+r.obj.seq+"'>";
         html += "<label>부모글의 정보("+r.obj.seq+")</label>";
         html += "<b>조회수:"+r.obj.readcount+" / 작성일 :"+r.obj.regdate+"/ 작성자:"+r.obj.id+"</b>";
         html += "</div>";
         
         
         html +="<div class='form-group'>";
         html +="<label>작성자</label>";
         html +="<b>"+r.sessionId+"</b>";
         html +="</div>";
         
         html +="<div class='form-group'>";
         html +="<label id='tit'>제목(원본)</label>";
         html +="<input type='text' class='form-control' id='title' name='title' value='"+r.obj.title+"'>";
         html +="</div>";
         
         html +="<div class='form-group'>";
         html +="<input type='hidden' id='hiddenContent' value='"+r.obj.content+"'>";
         html +="<label id='con'>내용(원본)</label>";
         html += "<textarea rows='5' class='form-control' id='Textarea' name='content' onclick='chk()'>"+r.obj.content+"</textarea>";         
         html +="</div>";
         
         html += "   <div class='modal-footer'>                                                        ";
          html += "    <input type='button' class='btn btn-success' value='답글작성' onclick='replyVal()'>";
         html += "    <span onclick='reset()'><input type='reset' class='btn btn-info' value='초기화'></span>";
         html += "    <button type='button' class='btn btn-danger' data-dismiss='modal'>취소</button>";
           html += "  </div> ";
         
         $("#frmReply").html(html);
         
      },
      error:function(){
         alert("잘못된 요청 처리 값");   
      }
      
   });
}

function reset(){
   console.log("리셋");
   document.getElementById("tit").innerHTML = "제목(원본)";
   document.getElementById("con").textContent = "내용(원본)";
}

function chk(){
   var tit = document.getElementById("tit");
   var con = document.getElementById("con");
   var title = document.getElementById("title");
   var Textarea = document.getElementById("Textarea");
   
   var hiddenContent = document.getElementById("hiddenContent");
   
   console.log(tit,con,title,Textarea,hiddenContent);
   
   if(Textarea.value == hiddenContent.value){
      tit.innerHTML = "답글제목";
      con.innerHTML = "답글내용";
      Textarea.value="";
      title.value="";
   }


}


function replyVal(){
   var tit = document.getElementById("tit").textContent; //제목(원본) -> 답글 제목
   console.log(tit);
   if(tit == "제목(원본)"){
      swal("답글작성 오류","제목과 내용을 작성해주세요");
      return;
   }
   var parentSeq = document.getElementsByName("seq")[0].value;
   var title = document.getElementById("title");
   var content = document.getElementsByName("content")[0];
   
   const extractTextPattern =/(<[^>]+)>/gi;
   let convertTitle = title.value.replace(extractTextPattern,'');
   let convertContent = content.value.replace(extractTextPattern,'');
   console.log(convertTitle,convertContent);
   
   $.ajax({
      url:"./reply.do",
      type:"post",
      data:{"seq":parentSeq,"title":convertTitle,"content":convertContent},
      success:function(msg){
         if(msg.isc == "true"){
            pageAjax();
            $("#reply").modal("hide");
         }else{
            swal("답글작성 오류","다시 작성해 주세요");
         }
      },error:function(){
         alert("잘못된 요청 처리");   
      }
   });
   
}















