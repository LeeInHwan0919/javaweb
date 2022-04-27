function check(){
   var id = document.getElementById("id").value;
   var name = document.getElementById("name").value;
   var password = document.getElementById("password").value;
   var passOk = document.getElementById("passOk").value;
   var i_agree2 = document.getElementById("i_agree").checked;
   var chkval = document.getElementById("chkval").value;
   
   var frm = document.forms[0];
   
   if(password != passOk){
      swal("회원가입오류","비밀번호를 확인해주세요");
      return false;
   }else if(chkval == "0"){
      swal("회원가입오류","아이디중복을 확인해 주세요");
      return false;
   }else if(i_agree2 == false){
      swal("회원가입오류","개인정보 수집 동의(필수) 해주세요");
      return false;
   }else{
      frm.submit();
   }
   
}
// var idRegEx = /^[a-zA-Z]{1}[a-zA-Z0-9]{5,19}$/g;
$(document).ready(function(){
   $("#id").keyup(function(){
      var idVal = $(this).val();
      console.log(idVal);
      if(idVal.indexOf(" ")!=-1){
         $("#result").css("color","red");
         $("#result").html("공백이 포함된 아이디는 사용할 수 없습니다.");
         $("#chkval").val(0);

      }else if(idVal.length <= 5 || idVal.length >=20){
         $("#result").css("color","red");
         $("#result").html("아이디는 5~20 글자를 입력해주세요");
         $("#chkval").val(0);
      }else{
         $("#result").html("");
         console.log("아이디 중복 Ajax 실행");
		 $("#chkval").val(1);
      }
   });
});






