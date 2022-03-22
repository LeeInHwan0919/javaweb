$(function(){
  $("#emp_search").click(function(){
//    var empid=$("#empId").val();
      var empid = $("input[name=empId]").val();
    console.log(empid);
    //유효성 검사
    if(!isNaN(empid)&&empid.length==3){
      $.ajax({
        url:"EMPLOYEES.xml",//전송할 페이지의 주소(jsp, servlet호출, 다른 ws)
        method:"POST",//서버 전송 프로토콜 방식
        async:true,//비동기식의 처리방식 , true면 비동기 /false 동기식
//        data:"emp=111" or {"emp":"1111"}//전송되는 데이터 queryString
        dataType: "xml",//url 동작이 된후 response된 데이터의 형변환
        success:function(data){//성공한 경우 4번 200인경우
//          console.log(data,typeof data);
//          alert($(data).find("DATA_RECORD").eq(0).children().eq(1).text());
            //입력 받은 값으로 EMPLOYEE_ID를 찾음
            var empInfo = $(data).find("EMPLOYEE_ID:contains("+empid+")").parent();
            console.log(empInfo);
            if($(empInfo).is("DATA_RECORD")){
              $("table input").each(function(i){
                $(this).val($(empInfo).children().eq(i).text())
              });
            }else{
              alert("해당 사원은 존재하지 않습니다.");
            }
        },
        error:function(request,status,error){//실패 했을 경우 callback 함수 실행되면 자동으로 응답하게됨
          alert("code:"+request.status+"\n message: "+request.responseText+"\n error:"+error);
        }
      });
    }else{
      alert("부정확한 사원번호 입니다.");
    }
    
  });
  
  
});