var brocken;

$(document).ready(function(){
  console.log("calendar.js onload 실행");
  $(".countView")
  .on("mouseenter"
                   ,function(){
                    var v = $(this)
                      brocken = setTimeout(function(){
                      console.log($(this).text(),"들어옴");  
                          var cDate = v.text().trim(); //선택된 날짜의 text 콘텐츠 // jQuery -> text -> trim
                                                                             // $.trim(문자)
                          var year = $(".y").text();//화면에 있는 년도 text콘텐츠
                          var month = $(".m").text();//화면에 있는 월 text콘텐츠
                          console.log(cDate.length);
                          var yyyymmdd = year + isTwo(month)+ isTwo(cDate);
                          console.log(yyyymmdd);
                          ajaxCnt(v,yyyymmdd);               
                    },1000);
  })
  .on("mouseleave"
                   ,function(){
                      clearTimeout(brocken);
//                      console.log($(this).text(),"나감");
                      $(".cPreview").remove();                      
            });
      });
      
    
function isTwo(n){
  return n.length<2?"0"+n:n;
}


function ajaxCnt(v,yyyymmdd){
  console.log("ajaxCnt 들어옴",v);
  $.ajax({
    url : "./CalListAjax.do",
    type:"post",
    async:false,
    data:"yyyymmdd="+yyyymmdd,
    dataType:"JSON",
    success:function(msg){
      console.log(msg.calCount,typeof msg);
      v.after("<div class='cPreview'>"+msg.calCount+"</div>"); 
    },
     beforeSend:function(){
      console.log("동작전");
      $('.wrap-loading').css("display","block");
    },
    complete:function(){
      console.log("동작완료");
        $('.wrap-loading').css("display","none");
    },
    error:function(){
      alert("서버통신실패");
    }
  });
  
}

