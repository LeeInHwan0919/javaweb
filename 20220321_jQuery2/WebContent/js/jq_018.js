/* jQuery방식 */
$(function(){
  $("#btn").click(function(){
    $("img").toggleClass("onOffSize");
  });
  
  //클래스를 삭제와 추가
  //attr
  $("img").click(function(){
    if($(this).hasClass("addSize")){
      $(this).removeClass("addSize").attr("title","이미지 축소");
    }else{
      $(this).addClass("addSize").attr("title","이미지 확대");
    }
  });
  
});

/* only javascript방식 */

//window.onload=function(){
//  var btn = document.getElementById("btn");
//  btn.onclick=function(){
//    console.log("작동");
//    var img01 = document.getElementsByTagName("img")[0];
//    var cn = img01.className;
//    console.log(cn);
//    if(cn==""){
//      img01.className="onOffSize";
//    }else{
//      img01.className="";
//    }   
//  }
//}