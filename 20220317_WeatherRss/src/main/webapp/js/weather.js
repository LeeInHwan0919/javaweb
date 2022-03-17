$(function(){
    $("#weaView").click(function(){
        console.log("jquery ajax를 실행해 봅니다");
        var code = $("#address option:selected").val();
        console.log("선택된 지역", code);

        $.ajax({
            url:"./weatherOpen.do",
            type:"post",
            data:{"zone":code}, // 보내주는 값
            dataType:"text", //callback으로 반환되는 값
            success:function(data){
                console.log(data);
                var obj = JSON.parse(data);
                console.log(obj, typeof obj);
                $("#x").val(obj.x);
                $("#y").val(obj.y);
                $("#pubDate").val(obj.pubDate);
                $("#wfKor").val(obj.wfKor);
                $("#temp").val(obj.temp);
                $("#reh").val(obj.reh);
                $("#pop").val(obj.pop);

                var weather_con = obj.wfKor;
                switch(weather_con){
                    case "맑은": $("#weatherImg").attr("src","./images/Clear.png");break;
                    case "구름 조금": $("#weatherImg").attr("src","./images/PartlyCloudy.png");break;
                    case "구름 많음": $("#weatherImg").attr("src","./images/MostlyCloudy.png");break;
                    case "흐림": $("#weatherImg").attr("src","./images/Cloudy.png");break;
                    case "비": $("#weatherImg").attr("src","./images/Rain.png");break;
                    case "눈/비": $("#weatherImg").attr("src","./images/SnowRain.png");break;
                    case "눈": $("#weatherImg").attr("src","./images/Snow.png");break;
                }
            },
            error:function(){
                alert("잘못된 요청 입니다");
            }

            });

        });
    });