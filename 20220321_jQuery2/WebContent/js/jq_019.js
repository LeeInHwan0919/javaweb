/**
    아코디언 메뉴
    1. 구성 : 각 상위 메뉴 H3에 대한 하위 메뉴 P로 구성되어 있음
             초기화면은 첫번째 메뉴 목록만 하위메뉴가 보이고
             화살표 버튼의 방향을 위로 표시되게 만들고 나머지 메뉴들은 아래로 감춤
    2. 기능 : 각 상위 메뉴의 오른쪽 상단에 위치한 화살표 버튼을 클릭하면 해당 메뉴의 하위 메뉴가 슬라이드 방식으로 나오도록 함
             이 때 화살표방향을 위로 표기하고
             나머지 메뉴들의 하위 메뉴를 모두 슬라이드 방식으로 감춰지며, 이때 화살표는 아래로 표시한다.             
 */

$(function(){
  $("div>p").eq(0).show();
  $("div>p").eq(0).siblings("p").hide();
  $("div>h3").eq(0).addClass("active");
  
  $("h3").click(function(){
    $(this).next().stop().slideToggle();
    $(this).next().siblings("p").stop().slideUp();
    $(this).toggleClass("active");
    
    $(this).siblings("h3").each(function(){
      if($(this).hasClass("active")){
        $(this).removeClass("active");
      }
    });
  });
});