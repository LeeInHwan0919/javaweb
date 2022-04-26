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
                   varHtml += "     <th><input type='checkbox' onclick='checkAll(this.checked)'></th>    ";
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
               varHtml+="      <div class='panel-heading'><a data-toggle='collapse' data-parent='#accordion' href='#collapse"+v.seq+"'>"+v.title+"</a></div>";
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
		               varHtml+="            <input type='button' class='btn btn-primary' value='삭제' onclick='delete('107')'>";
					}                               
					if(v.id==v.memid || n==7){
	              		 varHtml+="            <input type='button' class='btn btn-primary' value='수정' onclick='modify('107')'>";
					}
					if(n!=7){
			               varHtml+="            <input type='button' class='btn btn-primary' value='답글' onclick='reply('107')'> ";
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
				varHtml += " <li><a href='#' onclick='pagePrev()'><span class='glyphicon glyphicon-chevron-left'></span></a></li> ";
					for(let i=value.pageNum; i<=value.count; i++){
						if(value.index+1 == i){
							varHtml += "<li class='active'>";
						}else{
							varHtml += " <li >";
						}
						varHtml += "<a href='#' onclick='pageIndex("+i+")'>"+i+"</a></li>                                   ";
					}
				varHtml += " <li><a href='#' onclick='pageNext()'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
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