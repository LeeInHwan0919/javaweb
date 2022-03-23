/*
  이벤트 전파 : 각 요소가 중첩(포함, 겹침)인 경우 하나의 이벤트가 발생하면 중첩된 요소의 이벤트가 모두 차례대로 이벤트가 발생함
  이벤트 전파막기 : stopPropagation() - 이벤트 요소의 전파를 막는다.//javacript 이벤트 onclick
                preventDefault() - 이벤트의 의한 기본 동작을 막음//html의 기본 이벤트를 막음
                return false; 위의 두개의 기능을 모두 멈춤
   기존의 Propagation 없이 진행되면 중첩이기 때문에 a-> p -> div ->HTML 동작
   하지만 중간에 p이벤트 stopPropagation을 작성하면 a->p->HTML href동작
*/

$(function(){
  $("a:eq(0)").click(function(e){//click이벤트를 담고있는 객체를 e변수로 받아줌
    alert("a클릭",e);
//    e.preventDefault();
//    e.stopPropagation();
      return false;
  });
  
  $("p").click(function(){
    alert("p클릭");
//    e.stopPropagation();
  });
  
  $("div").click(function(){
    alert("div클릭");
  });
  
  //이벤트 메소드 종류 : click(), change(), keyUp(), keyDown(), submit()....
  //이벤트 핸들러(이벤트를 발생시키거나 도와주는 것) : bind(), unbind(), live(), die(
//  $("a:eq(1)").bind("mouseover mouseout",function(e){
//    if(e.type=="mouseover"){
//      $(this).css("background","yellow");
//    }
//    if(e.type=="mouseout"){
//      $(this).css("background","lime");
//    }
//  });

   $("a:eq(1)").bind({
    "mouseover":function(){
      $(this).css("background","blue");
    },
    "mouseout":function(){
      $(this).css("background","white");
    }
  });
  //bind()를 통해 원래 없었던 이벤트를 생성
  //생성된 이벤트를 제거함 unbind()
  //var interval = setInterval(함수,시간); 일정시간간격으로 반복
  //clearInterval(interval)
  
  $("span").click(function(){
    $("a:eq(1)").unbind();
  });
  
  $("button").click(function(){
    $("body").append("<p>요소추가</p>")
    //기존에 추가된 Element에 이벤트를 추가 하기 위해서 innerHTML혹은 setAttribute를 통해서 해야함
    $("body").append("<p onclick='alert(100);'>요소추가</p>")
  })
  
  //생성된 Element에 이벤트를 걸어 줌
  //이전에 생성된 tag가 아닌 추가된 p tag이기 때문에 event를 걸어 줄 수가 없음. on을 통해서 처리 해준다.
  $("body").on("click",">p",function(){
    alert("on으로 추가된 새로운 이벤트");
  });
 
 //javascript
 //linked 방식이 아닌 embeded 화ㅣ면이 뿌려진 상태에서 탐색으로 이벤트를 걸어 줘야 하기 때문에
 var p = document.getElementsByTagName("p");
 for(var i in p){
  p[i].onclick(function(){
    alert("안녕하세요.")
  });
} 
});