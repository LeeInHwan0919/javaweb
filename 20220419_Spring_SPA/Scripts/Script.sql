CREATE TABLE SPRINGMEMBER(	
	ID VARCHAR2(50),
	PW VARCHAR2(300) NOT NULL,
	AUTH CHAR(1) NOT NULL,
	DELFLAG CHAR(1) NOT NULL,
	REGDATE DATE NOT NULL,
	CONSTRAINT "SPRINGMEMBER_PK" PRIMARY KEY(ID),
	CONSTRAINT "SPRINGMEMBER_CK" CHECK("AUTH" IN('U','A'))
);

CREATE TABLE SPRINGBOARD(	
	SEQ NUMBER,
	ID VARCHAR2(50) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000),
	STEP NUMBER NOT NULL,
	DEPTH NUMBER NOT NULL,
	REFER NUMBER NOT NULL,
	READCOUNT NUMBER,
	DELFLAG CHAR(1) NOT NULL,
	REGDATE DATE NOT NULL,
	CONSTRAINT "SPRINGBOARD_PK" PRIMARY KEY(SEQ),
	CONSTRAINT "SPRINGBOARD_FK" FOREIGN KEY ("ID") REFERENCES SPRINGMEMBER("ID")
);;

CREATE SEQUENCE SPRINGBOARD_SEQ START WITH 1 INCREMENT BY 1;

SELECT * FROM SPRINGMEMBER s ;
SELECT * FROM SPRINGBOARD s ;

--회원전체조회(등록일순 내림차순)
SELECT ID, AUTH, DELFLAG, REGDATE FROM SPRINGMEMBER 
ORDER BY REGDATE DESC;
--회원가입
INSERT INTO SPRINGMEMBER (ID,PW,AUTH,DELFLAG,REGDATE) VALUES ('GD001','1234','U','N',SYSDATE);

--로그인(아이디, 비밀번호, 사용여부='N')
SELECT ID, AUTH,REGDATE FROM SPRINGMEMBER WHERE ID='GD001' AND PW='1234' AND DELFLAG ='N';
--비밀번호 확인

SELECT COUNT(*) FROM SPRINGMEMBER WHERE PW = '1234';
SELECT COUNT(*) FROM SPRINGBOARD ;
--새글쓰기
INSERT INTO SPRINGBOARD  (SEQ, ID, TITLE, 
            CONTENT, REFER, STEP,
            DEPTH,READCOUNT,DELFLAG , REGDATE)
      VALUES(SPRINGBOARD_SEQ.NEXTVAL , 'GD004', SPRINGBOARD_SEQ.CURRVAL||'번쨰 새글',
          SPRINGBOARD_SEQ.CURRVAL||'번째 새글 내용', (SELECT NVL(MAX(REFER),0) +1 FROM SPRINGBOARD s),0,
          0,0,'N',SYSDATE);
              
--답글(업데이트, 글입력)
--INSERT 
INSERT INTO SPRINGBOARD  (SEQ, ID, TITLE, 
            CONTENT, REFER, STEP,
            DEPTH,READCOUNT,DELFLAG , REGDATE)
      VALUES(SPRINGBOARD_SEQ.NEXTVAL, 'GD001', '답글1',
     '답글1 내용',(SELECT REFER FROM SPRINGBOARD s1  WHERE SEQ='4'), (SELECT STEP FROM SPRINGBOARD s2 WHERE SEQ='4')+1,
    (SELECT DEPTH FROM SPRINGBOARD s3  WHERE SEQ='4')+1,0,'N',SYSDATE);
  
--UPDATE 
UPDATE SPRINGBOARD SET STEP = STEP+ 1 
      WHERE  REFER = (SELECT REFER FROM SPRINGBOARD s  WHERE SEQ='4')
       AND STEP > (SELECT STEP FROM SPRINGBOARD s2  WHERE SEQ='4');
   
--상세글보기
 SELECT SEQ, ID, TITLE, CONTENT, REFER, STEP, DEPTH, DELFLAG,READCOUNT , REGDATE
FROM SPRINGBOARD 
 WHERE SEQ = '3';
--조회수
UPDATE SPRINGBOARD SET READCOUNT = READCOUNT +1 WHERE SEQ = '2';
--글 수정 (제목, 내용)
UPDATE SPRINGBOARD(TITLE,CONTENT)  VALUES('수정된 제목','수정된 내용') WHERE SEQ ='3';

--글 삭제(삭제여부 변경 : 다중삭제, [], DYNAMIC)
UPDATE SPRINGBOARD SET DELFLAG ='Y' WHERE SEQ = '3';

--글삭제(DB삭제 , 11번과 동일 )
DELETE FROM SPRINGBOARD ;
--하위 삭제 대상 찾기
SELECT SEQ, ID, TITLE, REFER, STEP , DEPTH, DELFLAG , READCOUNT ,REGDATE 
FROM SPRINGBOARD s2 WHERE REFER = (SELECT REFER FROM SPRINGBOARD s3 WHERE SEQ='4')
AND "DEPTH" > (SELECT "DEPTH"  FROM SPRINGBOARD s3 WHERE SEQ='4');
--게시글 전체 조회 (사용자는 삭제된글 보기 불가, 관리자는 삭제된 글 보기 가능) 
--: TEST LPAD로 작성을 하고 DAO는 그냥 작성
--유저
SELECT SEQ, ID, LPAD(TITLE,LENGTH(TITLE)+"DEPTH"*10) ,  REFER, STEP, DEPTH, DELFLAG,READCOUNT , REGDATE
 FROM SPRINGBOARD s WHERE DELFLAG ='N' 
    ORDER BY REFER DESC, STEP ASC;

--관리자
   SELECT SEQ, ID,LPAD(TITLE,LENGTH(TITLE)+"DEPTH"*10) AS TITLE ,  REFER, STEP, DEPTH, DELFLAG,READCOUNT , REGDATE
 FROM SPRINGBOARD s 
    ORDER BY REFER DESC, STEP ASC;
--게시글 페이징 + 전체글 조회 (사용자, 관리자)
   
   
   
 --하위 삭제 대상 조회
 SELECT SEQ, ID, TITLE , CONTENT , REFER , STEP , "DEPTH" ,DELFLAG , REGDATE , READCOUNT 
 	FROM SPRINGBOARD s  
 	WHERE REFER = (SELECT REFER FROM SPRINGBOARD WHERE SEQ = '60') 
 	AND STEP >= (SELECT STEP FROM SPRINGBOARD WHERE SEQ='60')
 	AND DEPTH >= (SELECT DEPTH FROM SPRINGBOARD WHERE SEQ='60')
		ORDER BY REFER DESC, STEP ; 
	   
 --관리자의 페이징처리
	--전처리 작업 : ORDER BY REFER DESC, STEP : 그룹이 정렬 되어야 함
	--WINDOWING 절을 사용해서 한번 잡고 ROWNUM으로 가져와야함
	--ROWNUM 은 WHERE, ORDER BY 상관없이 다 쓸 수 있음
	--RDB와 RDBMS 
	--ROWNUM 은 ROW가 나가면서 실행
	--SELECT절에서 ROWNUM이 만들어지는 것이기때문에 한번 더 감싸줘야함
SELECT SEQ , ID , TITLE ,CONTENT ,STEP , "DEPTH" , REFER , READCOUNT , DELFLAG , REGDATE
	FROM(
				SELECT  ROWNUM RM, SEQ , ID , TITLE ,CONTENT ,STEP , "DEPTH" , REFER , READCOUNT , DELFLAG , REGDATE 
					FROM (
						SELECT SEQ , ID , TITLE ,CONTENT ,STEP , "DEPTH" , REFER , READCOUNT , DELFLAG , REGDATE
							FROM SPRINGBOARD s
							ORDER BY REFER DESC, STEP
				)
			)
	WHERE RM BETWEEN 1 AND 10;

SELECT SEQ , ID , TITLE ,CONTENT ,STEP , "DEPTH" , REFER , READCOUNT , DELFLAG , REGDATE
	FROM(
		SELECT ROW_NUMBER() OVER(ORDER BY REFER DESC, STEP) RM , SEQ , ID , TITLE ,CONTENT ,STEP , "DEPTH" , REFER , READCOUNT , DELFLAG , REGDATE
			FROM SPRINGBOARD 
	)
	WHERE RM BETWEEN 1 AND 10;

SELECT COUNT(*) FROM SPRINGBOARD s ; 

 --사용자의 페이징처리
SELECT SEQ , ID , TITLE ,CONTENT ,STEP , "DEPTH" , REFER , READCOUNT , DELFLAG , REGDATE
	FROM(
		SELECT ROW_NUMBER() OVER(ORDER BY REFER DESC, STEP) RM , SEQ , ID , TITLE ,CONTENT ,STEP , "DEPTH" , REFER , READCOUNT , DELFLAG , REGDATE
			FROM SPRINGBOARD 
			WHERE DELFLAG = 'N'
	)
	WHERE RM BETWEEN 1 AND 10;

SELECT COUNT(*) FROM SPRINGBOARD WHERE DELFLAG = 'N';    
   
   
   UPDATE  SPRINGMEMBER 
   	SET  DELFLAG = CASE DELFLAG WHEN 'N' THEN 'Y' ELSE 'N' END;   
   
   
   