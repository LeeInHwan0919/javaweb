function imgSize(){
	//많은 속성을 변경하기 위해서는 여러개로 반복 작성 해도 됨
	//jQuery에서 {}JSON형태로 여러개의 속성 값을 처리 할 수 있다.
	//NodeList의 경우는 for문을 처리 할 필요 없고 모두 적용
	//각각의 요소 eq()처리 하면 됨
		$("img").css({"width":"300px","height":"300px"})
	}
	
	//#은 id검색
	function idSelector(){
		//방법 1. css속성중에서 display를 block / none처리
		//방법 2. toggle(), hide()
		
//		$("#selId").toggle();
//		$("#selId").css("display","none");
		
		//화면에서 id의 값이 많은 경우 documen.getElementById() , $("#아이디") 무조건 첫번째것만 선택
		$("#selId").hide();
	}
	
	//.은 클래스 검색
	function classSeletor(){
		 $(".selClass").css("opacity","0.3");
	}
	
	function changeImg(){ //틀림
	  //찾아서 tag를 지우고 새로 입력(create append)
	  //여기서는 속성을 변경하라는 소리 > src변경
      $("td>img").attr("src","./img/Gavicham.png");//속성변경
	//그냥 attr("src")하면 src의 속성을 가지고올 뿐
	}
	
	//title속성중 '02'를 포함하고 있는 img tag만 선택
	function propSeleotr(){ //틀림
	  //선택자의 속성검색[], 이벤트 : 
      // ex)input[type="text"]:hover        hover> 마우스올릴때 동작
      // = 같다, *= 포함한다, |= 키워드 검색
	  $("img[title*=02]").slideUp(2000);
	}
	
	
	
	
	
	
	
	
	
	
	