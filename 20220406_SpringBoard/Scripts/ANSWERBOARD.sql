--20220303 답변형 게시판 쿼리테스트
CREATE TABLE ANSWERBOARD(
  SEQ NUMBER,
  ID VARCHAR2(30) NOT NULL,
  TITLE VARCHAR2(200) NOT NULL,
  CONTENT VARCHAR2(1000),
  REF NUMBER NOT NULL,
  STEP NUMBER NOT NULL,
  DEPTH NUMBER NOT NULL,
  DELFLAG CHAR(1) DEFAULT 'N',
  REGDATE DATE DEFAULT SYSDATE
);



ALTER TABLE ANSWERBOARD ADD FOREIGN KEY(ID) REFERENCES USERINFO;

CREATE SEQUENCE ANSWERBOARD_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

ALTER TABLE ANSWERBOARD ADD CONSTRAINT ANSWERBOARD_PK PRIMARY KEY (SEQ);
ALTER TABLE USERINFO ADD CONSTRAINT USERINFO_PK PRIMARY KEY (ID);

-- ROOT글 입력
INSERT INTO ANSWERBOARD (SEQ,ID, TITLE, CONTENT, "REF",STEP, "DEPTH")
  VALUES (ANSWERBOARD_SEQ.NEXTVAL, 'rlaandus2', '첫번째 새글', '새글을 작성해 봅니다.', 
      (SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a2) , 
      0, 0);

INSERT INTO ANSWERBOARD (SEQ, ID, TITLE, CONTENT, "REF",STEP, "DEPTH")
  VALUES (ANSWERBOARD_SEQ.NEXTVAL, 'rlaandus2', '두번째 새글', '두번째 새글을 작성해 봅니다.', 
      (SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a2) , 
      0, 
      0);
    
INSERT INTO ANSWERBOARD (SEQ, ID, TITLE, CONTENT, "REF",STEP, "DEPTH")
  VALUES (ANSWERBOARD_SEQ.NEXTVAL, 'rladndus3', '안녕하세요~', '신입입니다!', 
      (SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a2) , 
      0, 
      0);
    
INSERT INTO ANSWERBOARD (SEQ, ID, TITLE, CONTENT, "REF",STEP, "DEPTH")
  VALUES (ANSWERBOARD_SEQ.NEXTVAL, 'rladndus3', '댓글좀 달아주세요!', '테스트 중인데 급합니다!', 
      (SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a2) , 
      0, 
      0);
-- ROOT 조회 (전체)
SELECT SEQ, ID, TITLE, "REF", STEP, "DEPTH", DELFLAG, REGDATE
FROM ANSWERBOARD a 
ORDER BY REF DESC, STEP ASC;

-- 글상세
SELECT SEQ, ID, TITLE, CONTENT, "REF", STEP, "DEPTH", DELFLAG, REGDATE
FROM ANSWERBOARD
WHERE SEQ ='7';

-- 답글입력(STEP)
UPDATE ANSWERBOARD SET STEP = STEP+1 
WHERE REF = (SELECT REF FROM ANSWERBOARD a4 WHERE SEQ ='2')
AND STEP > (SELECT STEP FROM ANSWERBOARD a5 WHERE SEQ = '2');
-- 답글 입력(INSERT)
INSERT INTO ANSWERBOARD(SEQ,ID,TITLE,
                            CONTENT,"REF",STEP,
                            "DEPTH")
                            VALUES (ANSWERBOARD_SEQ.NEXTVAL, 'Q003','답글3입니다',
                            '답글3 달아요',(SELECT REF FROM ANSWERBOARD a WHERE SEQ='2'),
                            (SELECT STEP FROM ANSWERBOARD a2 WHERE SEQ='2')+1,
                            (SELECT DEPTH FROM ANSWERBOARD a3 WHERE SEQ='2')+1);
-- 글삭제(UPDATE DELFLAG)
UPDATE ANSWERBOARD SET DELFLAG ='Y' WHERE SEQ='1';

-- 글수정
UPDATE ANSWERBOARD SET CONTENT ='수정 될 내용' WHERE SEQ='3';



-------------------------------
--BoardList 페이지

--기존의 전체 리스트 가져오기
SELECT SEQ, ID, TITLE, "REF", STEP, "DEPTH", DELFLAG, REGDATE
FROM ANSWERBOARD a 
ORDER BY REF DESC, STEP ASC;

--글의 전체 갯수
SELECT COUNT(*) 
  FROM ANSWERBOARD a ;

--
--(page-1)*10
-- (1-1)*10 , (2-1)*10
SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY REF DESC, STEP ASC)AS RNUM,SEQ, ID, TITLE, "REF", STEP, "DEPTH", DELFLAG, REGDATE
  FROM ANSWERBOARD a )
    WHERE RNUM>10 AND ROWNUM<=10;












