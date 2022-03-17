//만약에 dom이 탐색된 문자 깨짐 발생이된다면
//값처리가 필요함 encodeURIComponent
function getParameterValue(){
	var name=$("#name").val();
	var kor=$("#kor").val();
	var eng=$("#eng").val();
	var math=$("#math").val();
	var returnVal="name="+name+"&kor="+kor+"&eng="+eng+"&math="+math;
	console.log(returnVal);
	return returnVal;
}

$(function(){
	//Ajax Get방식
	$("#process1").click(function(){
		ajaxLoad();
	});
	//Ajax Post방식
	$("#process2").click(function(){
		ajaxLoad2();
	});
});

var httpRequest = null;//xhr

//state
function ajaxLoad(){
	var url="./scoreCal.do?"+getParameterValue();
	console.log(url);
	
	//1)서버 송수신 객체를 생성
	httpRequest = new XMLHttpRequest();
	//2)xhr의 송신state에 따라서 실행되는 callback함수
	httpRequest.onreadystatechange =callback;
	//3)xhr의 처리방식, 주소, 비동기
	httpRequest.open("GET",url,true);
	//4) GET방식으로 URL을 호출 하겠다.
	httpRequest.send();
}

//status callback
function callback(){//0-1-2-3-4
  alert("httpRequest.readyState =>"+httpRequest.readyState);
  console.log(httpRequest.status);
  alert("최종처리된 결과 코드 status"+httpRequest.status);

  if(httpRequest.readyState==4){
	alert("서버 통신이 완료되었습니다.");
	if(httpRequest.status==200){
		alert("성공적으로 interactive 하였습니다.");
		console.log(httpRequest.responseText);
		var obj = JSON.parse(httpRequest.responseText);
		$("#result").html(obj.name+"의 총점은?"+obj.sum+"이고 평균은?"+obj.avg);
	}else{
		alert("데이터 송수신에 실패하였습니다.");
	}
}
}

/*
	XMLHttpRequest : javascript에서 Object를 통한 HTTP데이터 송수신이 가능하도록 만들어 주는 객체
	state(작동 진행) / status(작동 후 상태)
	onreadystatechange : 상태 정보 
  -readystate
    0. uninitialized : 실행(load)가 되어 있지 않은 상태
	1. loading : 로드단계
	2. loaded : 로드완료
	3. interactive : 통신완료
	4. complete : 완료
	
	status code : onreadystatechange에 의해서 실행되는 callback 함수에 의해서 확인
	200 : 성공
	404 : 요청 페이지 혹은 프로토콜이 없음
	403 : forbidden 미인가 접근
	500 : 서버문제코드 (값처리나 값바인딩, 변수선언이 안됫다던지)
*/
