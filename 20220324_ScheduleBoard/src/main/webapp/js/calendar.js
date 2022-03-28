var brocken;

$(document).ready(function(){
  console.log("calendar.js onload 실행");
  $(".countView")
  .on("mouseenter"
                   ,function(){
                    var v = $(this)
                      brocken = setTimeout(function(){
                      console.log($(this).text(),"들어옴");  
                      v.after('<div class="cPreview">5</div>');                    
                    },2000);
  })
  .on("mouseleave"
                   ,function(){
                      clearTimeout(brocken);
                      console.log($(this).text(),"나감");
                      $(".cPreview").remove();                      
            });
      });