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
}

// 글 갯수가 변할 때 
function pageList(){
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   var listNum = document.getElementById("listNum");
   
   index.value = 0;
   pageNum.value = 1;
   listNum.value = document.getElementById("list").value;
}

function pageFirst(){
   console.log("처음페이지로 이동");
   var index = document.getElementById("index");
   var pageNum = document.getElementById("pageNum");
   
   index.value = 0;
   pageNum.value = 1;
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

















