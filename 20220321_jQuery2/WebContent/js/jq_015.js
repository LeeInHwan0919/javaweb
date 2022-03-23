$(function(){
  $(".run").click(function(){
    $("#box").animate({"opacity":"0.1","left":"400px"},1000)
    .animate({"opacity":"0.4","top":"160px","height":"20px","width":"20px"},"slow")
    .animate({"opacity":"1","background":"#fff","left":"0px","height":"100px","width":"100px"},"slow")
    .animate({"top":"0px"},"fast")
    .slideUp().slideDown("slow")    ;
      
  });
});