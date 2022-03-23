$(document).ready(function(){
//  console.log($("div").length);
//  $("div").eq(0).css("background","yellow");
//  $("div").eq(3).css("background","tomato");

//  console.log($("div>div").length);

//  var div = document.getElementsByTagName("div");
//  console.log(div.length);
    $("div").find("b").css({"font-size":"20px","color":"tomato"})
//  console.log($("div").children().length);
//  $("div").children().css("color","blue");
    $("div").children("#id").text("2번 Child");
    
    //parent : 상위 element, parents("선택자");
//    console.log($("b").parent().css("background","yellow"))
//    $("div>b").parents("div").css("background","lime");

    $("div>div").eq(2).next().css("background","skyblue");
});