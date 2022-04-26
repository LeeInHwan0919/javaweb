
//Session에 저장되어 있는 row의 값에 따른 ListNum의 갯수
$(document).ready(function(){
	var listNum = $("#listNum").val();

	$("#list option").each(function(){
		if(listNum == $(this).val()){
			$(this).prop("select",true);
		}else{
			$(this).prop("select",false);
		}
	});
});

//해당번호를 클릭했을때 해당 값을 전송
function pageIndex(idx){
   console.log("입력받은 인덱스값",idx);
   var index = document.getElementById("index");
   index.value = idx-1;
   pageAjax();
   
}

//글 갯수가 변할 때
function pageList(){
	var index=document.getElementById("index");
	var pageNum=document.getElementById("pageNum");
	var listNum=document.getElementById("listNum");
	
	index.value=0;
	pageNum.value=1;
	listNum.value=document.getElementById("list").value;
	
	console.log("pageList: ",listNum.value);
	
	pageAjax();
}

function pageFirst(){
	console.log("처음페이지로 이동");
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	
	index.value=0;
	pageNum.value=1;
	pageAjax();
}

function pagePrev(pNum, pageList){
	console.log("이전 그룹");
	if(0<pNum-pageList){
		pNum -= pageList;
		var index = document.getElementById("index");
		var pNum = document.getElementById("pageNum");
		
		index.value=pNum-1;
		pNum.value=pNum;
	}
	
	pageAjax();
	
}

function pageNext(pNum,total,listNum,pageList){
	console.log("다음 페이지");
	var idx = Math.ceil(total/listNum); //31/5 = 7
	var max = Math.ceil(idx/pageList); //2그룹
	
	if(max*pageList > pNum+pageList){
		pNum += pageList;
		
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageNum");
		
		index.value = pNum -1;
		pageNum.value = pNum;
	}
	pageAjax();
}


function pageLast(pNum,total,listNum,pageList){
	console.log("마지막 페이지");
	var idx = Math.ceil(total/listNum); // 31 / 5     7index
	var max = Math.ceil(idx);//12345|56  => 2묶음
	
	while(max*pageList > pNum+pageList){
		pNum += pageList;
	}
	
	var index = document.getElementById("index");
	var pageNum = document.getElementById("pageNum");
	
	index.value="idx-1";
	pageNum.value="1";
	pageNum.value =pNum;
	
	pageAjax();
}



var pageAjax= function(){
   console.log("인덱스 페이지 처리 Ajax");
//   var obj = $("#frm").serialize()
//   console.log(obj);
   
   $.ajax({
      url:"./page.do",
      type:"post",
      async:true,
      data:$("#frm").serialize(),
      dataType:"json",
      success:function(msg){
         
         console.log("msg의 값 : "+msg);
         $.each(msg, function(key,value){
            
            var varHtml="";
            var n = $(".table tr:eq(0) th").length;
            
            
            if(key=="lists"){
               
                  
            varHtml += "<thead>                                                             " ;
             varHtml += " <tr>                                                               " ;
            if(n==7){
                   varHtml += "  <th><input type='checkbox' onclick='checkAll(this.checked)'></th> " ;
               }    
            varHtml += "<th>글번호</th>                                                     " ;
            varHtml += "<th>제목</th>                                                       " ;
            varHtml += "<th>작성자</th>                                                     " ;
            varHtml += "<th>조회수</th>                                                     " ;
                
               if(n==7){
            varHtml += "  <th>삭제 여부</th>     " ;   
            }                                        
            varHtml          
            varHtml += "<th>작성일</th>                                                     " ;
             varHtml += " </tr>                                                              " ;
            varHtml += "</thead>                                                            " ;
               
               
            varHtml +="<tbody>";
            
            $.each(value,function(k,v){
               varHtml += "<tr> "; 
               if(n==7){
               varHtml += "  <td><input type='checkbox' name='chk' value='"+v.seq+"'></td>                                                                             ";
               }                                                                                                                                 
               varHtml += "  <td>"+v.seq+"</td>                                                                                                                          ";
               varHtml += "  <td>                                                                                                                                ";
               varHtml += "    <div class='panel-heading'> <a data-toggle='collapse' data-parent='#accordion' href='#collapse"+v.seq+"'>"+v.title+"</a> =</div>       ";
               varHtml += "  </td>                                                                                                                               ";
               varHtml += "  <td>"+v.id+"</td>                                                                                                                       ";
               varHtml += "  <td>"+v.readcount+"</td>                                                                                                                          ";
               if(n==7){
               varHtml += "  <td>"+v.delflag+"</td>                                                                                                                          ";
               }
               varHtml += "  <td>"+v.regdate+"</td>                                                                                                        ";
               varHtml += "</tr>                                                                                                                                 ";
               varHtml += "<tr>                                                                                                                                  ";
               varHtml += "  <td colspan='"+n+"'>                                                                                                                    ";
               varHtml += "    <div id='collapse"+v.seq+"' class='panel-collapse collapse'>                                                                            ";
               varHtml += "      <div class='form-group'> <label>내용</label> <textarea rows='4' class='form-control' readonly=''>"+v.content+"</textarea> </Adiv>";
               varHtml += "      <div>                                                                                                                           ";
               varHtml += "      <div class='form-group'>                                                                                                                           ";
               
               if(v.id == v.memid){
               varHtml += "          <input type='button' class='btn btn-primary' value='수정' onclick='modify('258')'>            ";
               }
               if(v.id == v.memid || n==7){
               varHtml += "          <input type='button' class='btn btn-primary' value='삭제' onclick='delete('258')'>            ";
				}
				if(n != 7){
               varHtml += "         <input type='button' class='btn btn-primary' value='답글' onclick='reply('258')'>            ";
				               
               varHtml += "</div>                                                                                                                          ";
               varHtml += "      </div>                                                                                                                          ";
               varHtml += "    </div>                                                                                                                            ";
               varHtml += "  </td>                                                                                                                               ";
               varHtml += "</tr>                                                                                                                                 ";
            
               varHtml += "</tbody>";
               }else{
				varHtml += "<li><a href='#' onclick='pageFirst()'><span class='glyphicon glyphicon-fast-backward'></span></a></li>  ";
				varHtml += "<li><a href='#' onclick='pagePrev("+value.pageNum+","+value.pageList+")'><span class='glyphicon glyphicon-step-backward'></span></a></li>   ";
				for(let i=value.pageNum;i<=value.count;i++){
				if(value.index+1==i){
				varHtml += "<li class='active'>";
				}else{
					varHtml += "<li>";
					}
				varHtml += "<a href='#' onclick='pageIndex("+i+")'>"+i+"</a></li>                                      ";
				}
				varHtml += "<li><a href='#' onclick='pageNext("+value.pageNum+","+value.total+","+value.listNum+","+value.pageList+")'><span class='glyphicon glyphicon-step-forward'></span></a></li>    ";
				varHtml += "<li><a href='#' onclick='pageLast()'><span class='glyphicon glyphicon-fast-forward'></span></a></li>    ";
}
            });
            }
            
            if(key=="lists"){
               $(".table").html(varHtml);
            }else{
	           $(".pagination").html(varHtml);
			}
       
         });
         
         
         
         
      },
      error:function(){
         alert("잘못된 요청");
      }
      
   });
};