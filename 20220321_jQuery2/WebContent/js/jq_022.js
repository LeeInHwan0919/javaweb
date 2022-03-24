/*
  첫번째 이미지는 마지막 위치하도록 만듬
  button tag이기 때문에 콘텐츠를 찾을때 text으로 탐색
  시작(START), 멈춤(STOP) 글자를 속성을 통해서 탐색해서 분리
 */
 var flag = null;
 $(function(){
  $("button").click(function(){
    if($("button").text()=="START"){
      flag = setInterval(function(){
        $("img:first").appendTo($("#menu"));
      },30);
      $(this).text("STOP");
    }else{
      clearInterval(flag);
      $(this).text("START");
      alert("오늘의 메뉴는? "+($("img:eq(2)").attr("alt"))+"입니다.");
    }
  });
  

});