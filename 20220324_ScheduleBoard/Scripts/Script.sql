CREATE TABLE CALENDARBOARD(
  SEQ NUMBER PRIMARY KEY,
  ID VARCHAR2(30) NOT NULL,
  TITLE VARCHAR2(200) NOT NULL,
  CONTENT VARCHAR2(4000),
  MDATE VARCHAR2(12) NOT NULL,
  REGDATE DATE NOT NULL
);

CREATE SEQUENCE CALENDARBOARD_SEQ START WITH 1 INCREMENT BY 1;

--일정 추가
INSERT INTO CALENDARBOARD
(SEQ, ID, TITLE, CONTENT, MDATE, REGDATE)
VALUES(CALENDARBOARD_SEQ.NEXTVAL, 'BD001', '일정게시판 시작', '마지막 Servlet 실습이다 무야호!!', '202203241200', SYSDATE);

INSERT INTO CALENDARBOARD
(SEQ, ID, TITLE, CONTENT, MDATE, REGDATE)
VALUES(CALENDARBOARD_SEQ.NEXTVAL, 'BD001', '프로젝트 모임', '불타는 금요일 프로젝트 모임 함', '202203251400', SYSDATE);

INSERT INTO CALENDARBOARD
(SEQ, ID, TITLE, CONTENT, MDATE, REGDATE)
VALUES(CALENDARBOARD_SEQ.NEXTVAL, 'BD001', '즐거운 수업 시작', '즐거운 척하는 수업 시작 입니다.', '202203251000', SYSDATE);

INSERT INTO CALENDARBOARD
(SEQ, ID, TITLE, CONTENT, MDATE, REGDATE)
VALUES(CALENDARBOARD_SEQ.NEXTVAL, 'BD001', '즐거운 수업 시작', '나의 주제는 잘 발표해서 팀원을 모아야지.', '202203251400', SYSDATE);

INSERT INTO CALENDARBOARD
(SEQ, ID, TITLE, CONTENT, MDATE, REGDATE)
VALUES(CALENDARBOARD_SEQ.NEXTVAL, 'BD001', '즐거운 수업 시작', '아작스를 아작내자.', '202203250900', SYSDATE);

INSERT INTO CALENDARBOARD
(SEQ, ID, TITLE, CONTENT, MDATE, REGDATE)
VALUES(CALENDARBOARD_SEQ.NEXTVAL, 'BD001', 'UI/UX 개발 회의', '화면은 사용만하고 싶지만 해야됨', '202203281100', SYSDATE);

INSERT INTO CALENDARBOARD
(SEQ, ID, TITLE, CONTENT, MDATE, REGDATE)
VALUES(CALENDARBOARD_SEQ.NEXTVAL, 'BD001', '개인 API 모듈 발표', '발표를 잘해야 하는데 두렵다.', '202203310900', SYSDATE);

--일정 게시글 조회 => 년월일
SELECT SEQ,ID,TITLE,MDATE,REGDATE
  FROM CALENDARBOARD c 
  WHERE ID='BD001' AND SUBSTR(MDATE,1,8) = '20220324';

--일정 갯수
SELECT COUNT(*) 
  FROM CALENDARBOARD c
  WHERE ID='BD001'AND SUBSTR(MDATE,1,8)='20220326';

--일정 상세
SELECT SEQ,ID,TITLE,CONTENT,MDATE,REGDATE
  FROM CALENDARBOARD c
  WHERE ID='BD001'AND SUBSTR(MDATE,1,8)='20220324'
  AND SEQ='10';

--게시글 삭제
DELETE FROM CALENDARBOARD c WHERE ID='BD001' AND SEQ='10';

--각 달별 게시글 리스트 > 달력에 출력되는 갯수 EX)하루에 일정10개 달력 3개만 보여야됨
SELECT SEQ,ID,TITLE,MDATE,REGDATE
     FROM(SELECT ROW_NUMBER() OVER(PARTITION BY SUBSTR(MDATE,1,8) ORDER BY MDATE)RN , SEQ, ID, TITLE, MDATE, REGDATE
        FROM CALENDARBOARD c
        WHERE ID='BD001' AND SUBSTR(MDATE,1,6)='202203')
WHERE RN BETWEEN 1 AND 3;

TRUNCATE TABLE CALENDARBOARD ;