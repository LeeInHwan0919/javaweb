$(function(){
  //1.input tag중에서 text인 엘리먼트를 선택하여 배경색 주기
  $("input:text").css("background-color","#ccc");
  
  //2.input tag중에서 type이 password인 엘리먼트를 선택하여 배경색 주기
  $("input:password").css("background-color","lime");
  
  //3.select tag의 name속성이 email인 엘리먼트의 change 이벤트가 발생했다면
  //     , 선택한 목록의 value를 alert해주세요.
  $("select[name=email]").change(function(){
//    alert($("select option:selected").val());
      alert($(this).add("option:selected").val());
  });
  
  //4.checkbox를 체크하면 체크된 목록들을 alert으로 출력하기
  // (체크된 목록이 모두 alert함수에 출력되어야 합니다.)
  $("input:checkbox").click(function(){
      var str = "";
//    $("input:checked").each(function(){
//      str += $(this).val()+" ";
//    });

      $("input:checked").each(function(i){
        str += $("input:checked").eq(i).val();
      });
      
      alert(str);
  });
  
});