<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<link rel="stylesheet" type="text/css" href="./css/common.css">

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/signup.js"></script>
</head>
<body>
   <div id="container">
      <div id="title">
         <img alt="logo" src="./images/logo.png">
      </div>
      
      <input type="hidden" id="chkval" value="0">
      
      <form action="./signup.do" method="post" onsubmit="return check()">
         <div id="info">
            <div id="leftInfo">정보입력</div>
            <div id="centerInfo">
               <input type="text" id="id" name="id" placeholder="아이디" required maxlength="20"><br>
               <input type="text" id="name" name="name" placeholder="성명"><br>
               <span id="result"></span>
               <input type="password" id="password" name="pw" placeholder="비밀번호 입력" required><br>
               <input type="password" id="passOk" placeholder="비밀번호 확인" required><br>
            </div>
            <div id="bottomInfo">
               <div class="usm-agree">
                  <input type="checkbox" name="i_agree" id="i_agree" value="1">
                  <label for="i_agree">홈페이지 이용약관 <strong> (필수)</strong></label>
               </div>
               <div class="usm-join-box">
                  <p class="tit">제1장 총칙</p>
                  <dl>
                    <dt><strong>제1조 (목적)</strong></dt>
                    <dd>이 약관은 충청북도교육연구정보원(이하 "우리원"이라 한다)이 제공하는 학교통합홈페이지 및 학교통합홈페이지지원센터에 게재한 내용물(이하 "서비스"라 한다)에 대한 이용 조건 및 운영 절차에 관한 사항을 규정함을 목적으로 합니다.</dd>
                    
                    <dt><strong>제2조(회원 약관의 효력 및 변경)</strong></dt>
                    <dd>① 이 약관은 우리원이 온라인으로 공지함으로써 효력을 발생하며, 합리적인 사유가 발생할 경우 관련 법령에 위배되지 않는 범위 안에서 개정할 수 있습니다.</dd>
                    <dd>② 이 약관에 동의하는 것은 정기적인 방문으로 약관의 변경 사항을 확인하는 것도 포함하여 동의함을 의미하며, 변경된 약관에 대한 정보를 알지 못해 발생하는 이용자의 피해는 우리원에서 책임지지 않습니다.</dd>
                    <dd>③ 회원이 변경된 약관에 동의하지 않을 경우 회원 탈퇴(해지)를 요청할 수 있으며, 변경된 약관의 효력 발생 일로부터 7일 이내에 거부 의사를 표시하지 않을 경우 약관의 변경 사항에 동의한 것으로 간주합니다.</dd>
                    
                    <dt><strong>제3조(약관 외 준칙)</strong></dt>
                    <dd>이 약관에 명시되지 않은 사항은 개인정보보호 등에 관한법률, 기타 관련 법령의 규정에 의합니다.</dd>
         
                    <dt><strong>제4조(서비스의 종류)</strong></dt>
                    <dd>각 학교별 홈페이지에서 별도 서비스를 제공합니다.</dd>
         
                    <dt><strong>제5조 (가입하기)</strong></dt>
                    <dd>① 서비스는 본 이용약관 하단의 "동의함" 단추를 누르면 가입 신청 후 사용이 허락됩니다.</dd>
                    <dd>② 회원으로 가입하여 본 서비스를 이용하고자 하는 사람은 우리원에서 요청하는 제반 정보(이름, 연락처 등)를 등록하여야 하며, 실명으로 등록하지 않은 회원은 일체의 권리를 주장할 수 없습니다.</dd>
                    <dd>③ 우리원은 실명 확인 조치를 할 수 있으며, 타인의 명의(이름 및 주민등록번호)를 도용하여 가입신청을 한 회원의 아이디는 삭제되며, 관련 법령에 따라 처벌을 받을 수 있습니다.</dd>
                    
                    <dt><strong>제6조 (서비스 제공)</strong></dt>
                    <dd>① 서비스 제공은 가입 신청 후 이루어집니다.</dd>
                    <dd>② 서비스의 이용 시간은 연중 무휴 1일 24시간을 원칙으로 합니다. 다만, 시스템 점검 등 특별한 사유가 있는 경우에는 예외로 합니다.</dd>
         
                    <dt><strong>제7조 (서비스 제공의 중지)</strong></dt>
                    <dd>우리원은 다음 각 호의 1에 해당하는 경우에는 서비스 제공을 중지하거나 제한할 수 있습니다.</dd>
                    <dd>1. 국가의 비상사태 또는 천재지변 등 불가항력의 사유가 발생한 경우</dd>
                    <dd>2. 전기통신사업법에 규정된 기간통신사업자가 전기통신서비스를 중지했을 경우</dd>
                    <dd>3. 서비스용 설비의 보수, 공사 또는 장애로 인한 부득이한 경우</dd>
                    <dd>4. 서비스 이용의 폭주 등으로 정상적인 서비스 이용에 지장이 있을 경우</dd>
                    <dd>5. 기타 원활한 시스템 관리를 위해 조치가 필요한 경우</dd>
         
                    <dt><strong>제8조 (회원아이디 관리)</strong></dt>
                    <dd>① 우리원은 회원에 대하여 약관에 정하는 바에 따라 회원 아이디를 부여합니다.</dd>
                    <dd>② 회원 아이디는 원칙적으로 변경이 불가하며 부득이한 사유로 인하여 변경하고자 하는 경우에는 이미 보유한 아이디를 해지하고 재가입하여야 합니다.</dd>
                    <dd>③ 회원이 부여받은 아이디는 타인에게 전매 또는 양도할 수 없습니다.</dd>
                    <dd>④ 회원에게 부여된 아이디와 비밀번호 누설로 인해 발생하는 문제 또는 제3자의 부정사용 등으로 발생하는 모든 결과에 대한 책임은 당해 회원에게 있습니다.</dd>
                    <dd>⑤ 자신의 아이디가 부정하게 사용된 경우 당해 회원은 반드시 우리원에 그 사실을 통보하여야 합니다.</dd>
                    
                    <dt><strong>제9조 (이용 제한)</strong></dt>
                    <dd>우리원은 다음 각 호의 1에 해당하는 경우에는 회원 아이디와 비밀번호를 삭제할 수 있습니다.</dd>
                    <dd>1. 허위로 가입 신청한 경우</dd>
                    <dd>2. 본인의 실명으로 가입하지 않은 경우</dd>
                    <dd>3. 타인의 아이디와 비밀번호를 도용한 경우</dd>
                    <dd>4. 서비스 운영을 고의로 방해하는 경우</dd>
                    <dd>5. 본 약관 제10조(회원의 게시물) 규정에 반한 경우</dd>
         
                    <dt><strong>제10조 (회원의 게시물)</strong></dt>
                    <dd>회원이 게재한 내용물이 다음 각 호의 1에 해당한다고 판단되는 경우에는 사전통지 없이 삭제할 수 있습니다.</dd>
                    <dd>1. 공공질서 및 미풍양속에 위반하는 내용인 경우</dd>
                    <dd>2. 범죄 행위에 관련된 경우</dd>
                    <dd>3. 허위 사실 유포 또는 타인의 명예를 훼손하는 내용인 경우</dd>
                    <dd>4. 우리원의 저작권, 제3자의 저작권 등 기타 권리를 침해하는 내용인 경우</dd>
                    <dd>5. 기타 관련 법령에 위배되거나 홈페이지 운영상 필요하다고 판단되는 경우</dd>
         
                    <dt><strong>제11조 (의무)</strong></dt>
                    <dd>① 우리원은 서비스 제공과 관련하여 회원의 신상정보를 본인의 승낙 없이 제3자에게 누설, 배포하지 않습니다. 다만, 각호의 1에 해당하는 경우에는 그러하지 않습니다.</dd>
                    <dd>  1. 관계법령에 의하여 수사상의 목적으로 관계기관으로부터 요구받은 경우</dd>
                    <dd>  2. 정보통신윤리위원회의 요청이 있는 경우 </dd>
                    <dd>  3. 기타 관계법령에 의한 경우</dd>
                    <dd>② 우리원은 원활한 서비스를 위해 학교별 접속자수, 학교별 회원가입수 등 통계 자료를 작성하여 사용할 수 있습니다.</dd>
                    <dd>③ 회원은 약관에서 규정하는 모든 사항을 준수하여야 합니다.</dd>
         
                    <dt><strong>제12조 (저작권 권리)</strong></dt>
                    <dd>서비스에 이용된 자료에 대한 권리는 다음 각 호의 1과 같습니다.</dd>
                    <dd>1. 회원은 게재된 자료를 상업적인 목적으로 이용할 수 없습니다.</dd>
                    <dd>2. 게시물에 대한 권리와 책임은 게시자에게 있습니다.</dd>
                    <dd>3. 우리원은 회원의 게시물에 대한 신뢰도나 정확성등 내용에 관해서는 책임을 지지 않습니다.</dd>
         
                    <dt><strong>제13조 (운영 세칙)</strong></dt>
                    <dd>기타 필요한 사항은 우리원이 정하여 공지사항란에 게시하여 모든 회원에게 알립니다.</dd>
         
                    <dt><strong>제14조 (분쟁 조정)</strong></dt>
                    <dd>서비스 이용시 발생한 분쟁에 대해 소송이 제기될 경우 우리원 소재지를 관할하는 법원을 관할법원으로 합니다.</dd>
         
                    <dt><strong>부 칙</strong></dt>
                    <dd>제1조(기 가입자에 대한 경과조치) 이 약관 시행일 전 가입자는 이 약관을 승인한 것으로 간주합니다.</dd>
                    <dd>제2조 이 약관은 2013년 7월 1일부터 시행합니다.</dd>
         
                 </dl>
               </div>
            </div>
            <div id="bottom">
               <input class="btn btn-success" type="submit" value="동의하고 회원가입">
               <input class="btn btn-primary" type="button" value="돌아가기" onclick="javascript:history.back(-1)">
            </div>
         </div>
      </form>
   </div>
</body>
</html>