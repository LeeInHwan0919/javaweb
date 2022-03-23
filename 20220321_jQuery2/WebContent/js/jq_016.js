$(function(){
  $(".delete").click(function(i){
    $(this).parents("div").slideUp("slow","easeInOutBounce");
  });
  
  $("#view").click(function(){
    $(".panel").css("display","block"); 
  });
});