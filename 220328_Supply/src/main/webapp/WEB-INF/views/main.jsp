<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인페이지</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style type="text/css">
  	.navbar-brand{
  		background-image: url(./img/star.png);
  		background-repeat: no-repeat;
  		background-size: 100%;
  		background-position: center;
  	}
  	
  	.navbar-header{
  		padding-left:20px; 
  		padding-right: 20px;
  	}
  	.container{
  		width: 850px;
  	}
  	
  	.panel-heading{
  	  padding: 0px;
  	}
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/boardList.js"></script>
</head>
<body>
<header>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="./login.do"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="${category eq 'b'? 'active':''}"><a href="#">게시판</a></li>
        <li><a href="#">도서관안내</a></li>
        <li><a href="#">희망도서신청</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">도서검색 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">저자별</a></li>
            <li><a href="#">출판사</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
            <a href="#">
                 <span class="glyphicon glyphicon-user"></span> ${loginVo.name}(${loginVo.role=='ADMIN'?'관리자':'일반사용자'})
            </a>
        </li>
        <li><a href="./logout.do" id="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
</header>
<div class="container">
  <h2>공지게시판</h2>
  <div class="panel-group" id="accordian">
    <table class="table table-hover">
      <thead>
        <tr class="info">
          <th>연번</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="row" items="${lists}" varStatus="vs">
          <tr>
            <td>${fn:length(lists)-vs.index}</td>
            <td>
            <div class="panel-heading">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse${row.seq}">${row.title}</a>
            </div>
            </td>
            <td>${row.id}</td>
            <td>${row.regdate}</td>
          </tr>
          <tr>
            <td colspan="4" style="padding:0px; border-top:0px;">
              <div id="collapse${row.seq}" class="panel-collapse collapse" >
                 <div class="form-group">
                   <label>내용 : </label>
                  <textarea rows="4" cols="form-control" readonly="readonly">${row.content}</textarea>
                 </div>
                 <div class="form-group">
                   <c:choose>
                     <c:when test="${loginVo.role eq 'ADMIN' or loginVo.id eq row.id}">
                       <input type="button" class="btn btn-primary" value="삭제" onclick="delete(${row.seq})">
                     </c:when>
                     <c:otherwise>
                       <input type="button" class="btn btn-primary" value="답글" data-toggle="modal" data-target="#myModal" onclick="reply(${row.seq})">
                                                                                                                       
                     </c:otherwise>
                   </c:choose>
                 </div>
              </div>
            </td>
          </tr>
        </c:forEach>
      </tbody>      
    </table>
  </div>
  
</div>

<!-- Modal -->
  <div class="modal fade" id="reply" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">답글작성</h4>
        </div>
        <div class="modal-body">
          <p>ajax를 통해서 form을 그려줄거임</p>
        </div>
      </div>
    </div>
  </div>


<script type="text/javascript">
  document.getElementById("logout").addEventListener('click',function(){
	                                                            var bool = comfirm("로그아웃 됩니다.");
	                                                            if(!bool){
	                                                            	event.preventDefault();
	                                                            }
	                                                            });
  $("tbody a").on("click",function(){
	  var cl = $(this).prop("href");
	  var id = cl.substring(cl.lastIndexOf("#")+1);
	  console.log(id);
	  
	  var ch = $(".panel-collapse");
	  for (var i = 0; i < ch.length; i++) {
		  if(id==ch[i].id){
			  console.log(ch[i].className + "-----");
		  }else{
			  ch[i].className="panel-collapse collapse"
		  }
	}
  });
</script>
</body>
</html>