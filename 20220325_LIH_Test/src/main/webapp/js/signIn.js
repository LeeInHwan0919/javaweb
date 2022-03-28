$(function(){
  var id =  $("#id").val();
  $.ajax({
    url:"./login.do",
    type:"post",
    data:{id:id},
    success:function(cnt){
      console.log(cnt);
      if(cnt!=1){
        $("#insert").attr("disabled",false);
        $("#idok").hide(); 
        $("#iduse").show(); 
      }else{
        $("#insert").attr("disabled",true);
        $("#idok").show();    
        $("#iduse").hide(); 
      }
    },
    error:function(){
      alert("실패입니다.");
    }
    
  }); 
});

