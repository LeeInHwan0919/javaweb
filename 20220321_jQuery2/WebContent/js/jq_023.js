$(function(){
  $("button:eq(0)").click(function(){
    //target이 앞에 온다.
    $("#base").after("<div>새로운 ELementAfter</div>");
  })
  $("button:eq(1)").click(function(){
    //target이 뒤에 위치한다.
//    $("<div>새로운 ELementAfter</div>").insertAfter("#base");
    $("<div>").html("<b>새로운 Element insertAfter</b>").insertAfter("#base");
  })
  $("button:eq(2)").click(function(){
    $("#base").before("<div>새로운 Element Before</div>");
  })
  $("button:eq(3)").click(function(){
    $("<b>새로운 Element Before</b>").insertBefore("#base");
  })
});