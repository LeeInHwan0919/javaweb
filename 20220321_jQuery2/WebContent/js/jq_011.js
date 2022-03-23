$(function(){
//  $("p:eq(0)").add("span").css("color","red");
  
  $("p:eq(0),span").css("color","green");
  $("body").css("background","dark");
  
//  var doc = document.getElementsByTagName("div")[0];
//  var chd = doc.children;
//  for(var i in chd){
//    chd[i].onclick(function(){
//      if(this.tagName=="SAPN"){
//        console.log(this.textContent)
//      }
//    });
//  }
  $("div").children().click(function(){
    if($(this).prop("tagName")=="SPAN"){
      $(this).css("color","orange");
    }
    
    if($(this).is("p")){
      $(this).css("background","yellow");
    }
    
  });
//  $("div>span").css
//  if($("div").children("SPAN").is()){
//    $("span").css("font-color","orange")
//    $("p").css("background-color","yellow")
//  }else{
//    alert("span이 없습니다. 입력하세요")
//  }
  
  
});