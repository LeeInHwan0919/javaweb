$(function(){
  $("b").click(function(){
     $("p").toggle();
     $("p").each(function(i){
//       $("div").css("color","red"),css("font-size","20pt");
//       $("div").css({"top":i*50+"px","left":"10px"})

         $(this).animate({"top":30*(i+1)+"px"},1000);
    });
  });
  
  //p tag에 각 이팩트를 발생
  $("p").bind("click",function(){
    var ele = $(this);
    
    //공통 적용
    ele.css("background-color","orange");
    //그룹선택
    ele.siblings("p").css("background-color","white");
    
    //포함하는 단어를 selector 표현식에서 찾아 낸다.
    //input[name=chk], *=(포함), |=(키워드)
    // contains를 통해서 tag의 값을 확인 할 수 있다.this.textContent.indexOf("show")!= -1
    
    //is()가지고 있는지 확인, 있다면true
    if(ele.is("p:contains(show)")){
      $("#img1").show();
    }
    
    if(ele.is("p:contains(hide)")){
      $("#img1").hide();
    }
    
    if(ele.is("p:contains(toggle)")){
      $("#img1").toggle();
    }
    
    if(ele.is("p:contains(slideUp)")){
      $("#img1").slideUp();
    }
    
    if(ele.is("p:contains(slideDown)")){
      $("#img1").slideDown();
    }
    
    if(ele.is("p:contains(slideToggle)")){
      $("#img1").slideToggle();
    }
    
    if(ele.is("p:contains(fadeIn)")){
      $("#img1").fadeIn();
    }
    
    if(ele.is("p:contains(fadeOut)")){
      $("#img1").fadeOut();
    }
    
    if(ele.is("p:contains(fadeTo)")){
      $("#img1").fadeTo(1000,0.3);
   }   
   if(ele.is("p:contains(fadeToggle)")){
      $("#img1").fadeToggle();
    }
    
    if(ele.is("p:contains(animate)")){
      $("#img1").animate({
        "width":"300px",
        "height":"300px",
        "top":"300px",
        "left":"600px"
      },1000);
    //jQuery 에서는 clone()을 사용하면 복제가 된다.
    var img2 = $("#img1").clone().attr("id","img2");
    $("#img1").after(img2);
    $("#img2").animate({
        "width":"300px",
        "height":"300px",
        "top":"280px",
        "left":"580px",
        "opacity":"0.5"
      },2000);


    }
    
    
  });
  
});