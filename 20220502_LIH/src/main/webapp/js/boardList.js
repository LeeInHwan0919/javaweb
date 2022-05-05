function paging(){
	$("#frmp").attr("action","./boardList.do");
	$("#frmp").submit();
}



function pageIndex(idx){
   console.log("입력받은 index 값",idx);
   var index = document.getElementById("index");
   index.value = idx-1;
   paging();
}

function pageList(){
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   var listNum = document.getElementById("listNum");
   
   index.value = 0;
   pageNum.value = 1;
   listNum.value = document.getElementById("list").value;
   paging();
}

function pageFirst(){
   console.log("처음페이지로 이동");
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   
   index.value = 0;
   pageNum.value = 1;
   paging();
}

function pagePrev(pNum, pageList){
   console.log("이전 그룹");
   if(0 < pNum-pageList){
      pNum -= pageList;
      var index = document.getElementById("index");
      var pageNum = document.getElementById("pageNum");
      
      index.value = pNum-1;
      pageNum.value = pNum;
   }
   paging();
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
   paging();
}

function pageLast(pNum,total,listNum,pageList){
   console.log("마지막 페이지");
   var idx = Math.ceil(total/listNum);
   var max = Math.ceil(idx/pageList);
   
   while(max*pageList > pNum+pageList){
      pNum += pageList;
   }
   
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   
   index.value=pNum-1;
   pageNum.value=pNum;
      paging();
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

















