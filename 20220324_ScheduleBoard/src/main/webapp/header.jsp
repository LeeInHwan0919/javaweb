<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
 <link rel="shortcut icon" type="image/x-icon" href="./image/favicon.ico">
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
  <script type="text/javascript" src="./js/calendar.js"></script>
  
  <style type="text/css">
    #container{
    
      width: 800px;
      height: 480px;
      margin: 40px auto;
    }
    
    header{
      background-color: #D9e5ff;
      height: 70px;
      box-sizing: border-box;
      color:#000000;
      text-align: right;
      padding-right: 10px;
    }
    #calendar{
      border: 1px solid #ccc;
      border-collapse: collapse;
      margin: auto;
    }
    #calendar th{
      width: 80px
      border:1px solid #ccc;
    }
    
    #calendar td{
    width: 80px;
    height: 80px;
    border: 1px solid #ccc;
    text-align: left;
    vertical-align: top;
    position: relative;
    }
    .clist{
     margin-top: 10px;
    }
    .clist>p{
      font-size: 8px;
      margin: 2px;
      background-color: orange;
      border-radius: 3px;
    }
    
    a{
     text-decoration: none;
    }
    
    .cPreview{
      position: absolute;
      background: forestgreen;
      top:-30px;
      left:10px;
      opacity: 0.5;
      
      width: 40px;
      height: 40px;
      color: white;
      text-align: center;
      vertical-align: middle;
      line-height: 40px;
      font-weight: bold;
      border-radius: 40px 40px 40px 1px;
    }
  </style>
</head>
<body>
  <header>
    <div>
      <div>아이디 : ${sessionScope.id}</div>      
      <div>이름 : ${sessionScope.name}</div>
      <div>
        <a href="./CalController.do?command=sessionDel">세션삭제</a>
      </div>      
    </div>
  </header>
</body>
</html>