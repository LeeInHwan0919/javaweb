$(function(){
  $("button:eq(0)").click(function(){
    $("div").prepend($("<p>")).addClass("prepend").text("prepend작동");
  });
  
  $("button:eq(1)").click(function(){
//    $("div").append($("<p>")).addClass("append").text("append작동");
    $("body").append($("div p:first"));
  });
  
  $("button:eq(2)").click(function(){
    //선택된 Element중에서 콘텐츠 선택 : innerHTML /textContent
    $("div").html("<b>innerHTML로 변경하겠다.</b>");
  });
  
  $("button:eq(3)").click(function(){
    $("div").text("<b>innerHTML로 변경하겠다.</b>");
  });
    
});