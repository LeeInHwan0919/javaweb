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
        
            var empRowList = $(data).find("DATA_RECORD");
           
           
            if(empRowList.length > 0){
              $("body").append(makeTable(empRowList));
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

function makeTable(dataTable){
  // $변수명 -> jQuery 변수
  // var 변수명 -> javascript
  
  $table = $("<table>");
  for(var i=0; i<1; i++){
    $tr = $("<tr>");
    for(var j=0;j<dataTable.eq(0).children().length;j++){
      $td = $("<td>").append(dataTable.eq(i).children().eq(j).prop("tagName"));
      $tr.append($td);
    }
    $table.append($tr);
  }  
  
  for(var i=0;i<dataTable.length;i++){
    $tr = $("<tr>")
    for(var j=0;j<dataTable.eq(0).children().length;j++){
      $td = $("<td>").append(dataTable.eq(i).children().eq(j).text());
      $tr.append($td);
    }
    $table.append($tr);
  }
  
  return $table;
}







