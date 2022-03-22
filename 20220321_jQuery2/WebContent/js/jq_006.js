// 유효성 검사: 에러메세지 표시하기 class=error
$(function(){
  //클래스는 .으로 검색
  $(".error").hide();

  //submit은 onclick과 같은 이벤트 하지만 jQuery이기 떄문에 on을 빼고 이벤트 처리
  //submit버튼을 통해서 <form onsubmit="return fn()"> fn()의 결과에서 따라서 propagation을 처리 함
  //button으로 처리해서 javascript에서 DOM탐색(document.forms[0], document.name) 한후 submit()함수를 통해서 실행 

//id #으로 검색
  $("#signal").submit(function(){
    if($(".infoBox").val()==""){
      $(".error").show();
      return false;
    }  
  });
  
  // 체크박스의 체크여부를 확인하여 화면에 체크된 값 표현하기
  $("#confirm").click(function(){
    $("#result").empty();
    if($("input[name=chk]:checked").length == 0){
      alert("하나 이상 체크해 주세요.");
    }else{
      //선택된 checkbox의 value와 다음에 있는 text값을 가져와야 함
      $("input[name=chk]:checked").each(function(i){
        // 위치를 가지고 옴
        var chkPosition = $("input[name=chk]:checked").eq(i);
        
        //글자를 가져옴 <input>태그의 다음태그인 <b>태그의 textNode
        //다음 노드 검색 next()를 통해서 탐색됨
        var bookName=chkPosition.next().text();

        // 값을 가지고 옴 input의 value=값
        var price = chkPosition.val();
        
//        $("#result").text("책이름 : "+bookName+"\n책 가격 : "+price +"원");
        $("#result").append(bookName+"가격:"+price+"<br>");
      });
    }  
  
   }); 
   $("input[name=chk]").click(function(){
    
  
  //name=chk인 갯수와checked되어 있는 갯수가 있다면 all 체크 해줌
  if($("input[name=chk]").length==$("input[name=chk]:checked").length){
    $("input[name=all]").prop("checked",true);
  }else{
    $("input[name=all]").prop("checked",false);
  }
  
  });
});
  
function allChk(bool){
  //입력받음 bool에 따른 전체 체크
  //속성 : javascript에서는 예약어를 통해서 사용하게 됨 ex) document.getElementsByTagname("chk")[0].checked=true
  //      jQuery에서는 함수 형식이기 때문에 attr(), prop()
  //속성을 가져 옴 : attr("속성명")
  //속성을 입력할 때 : attr("속성명","입력할 값")
  
  $("input[name=chk]").each(function(){
    $(this).prop("checked",bool);
  });
  
  }
  