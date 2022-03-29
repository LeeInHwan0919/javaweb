CREATE TABLE STARMEMBER(
  SEQ NUMBER NOT NULL,
  ID VARCHAR2(20) NOT NULL,
  PASSWORD VARCHAR2(100) NOT NULL,
  NAME VARCHAR2(50) NOT NULL,
  ADDRESS VARCHAR2(200) NOT NULL,
  PHONE VARCHAR2(20) NOT NULL,
  EMAIL VARCHAR2(100) NOT NULL,
  ENABLE CHAR(1) NOT NULL,
  "ROLE" VARCHAR2(10) NOT NULL,
  CONSTRAINT "STARMEMBER_PK" PRIMARY KEY(SEQ),
  CONSTRAINT "STARMEMBER_UL1" UNIQUE ("ID","EMAIL")
);

CREATE SEQUENCE STARMEMBER_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO BD.STARMEMBER
(SEQ, ID, PASSWORD, NAME, ADDRESS, PHONE, EMAIL, ENABLE, "ROLE")
VALUES(STARMEMBER_SEQ.nextval, 'ldkkoj111', '123456', '이인환', '서울시관악구신림동', '01033097483', 'ldkkoj777@naver.com', 'Y', 'ADMIN');

SELECT ID,NAME,"ROLE" 
  FROM STARMEMBER
    WHERE ID='ldkkoj111' AND PASSWORD='123456' AND ENABLE ='Y';
    
SELECT *
  FROM ANSWERBOARD
  WHERE SEQ=6;
  
SELECT a.SEQ, NVL(NAME,'GUEST') AS ID, TITLE, CONTENT,
  CASE
        WHEN TO_CHAR(REGDATE,'YYYY-MM-DD') <= TO_CHAR(SYSDATE,'YYYY-MM-DD')
        THEN '이전글' 
        ELSE TO_CHAR(REGDATE,'YYYY-MM-DD') END AS REGDATE
  FROM ANSWERBOARD a LEFT JOIN STARMEMBER s
  USING(ID)
  WHERE DELFLAG ='N'
  AND "DEPTH"='0'
  ORDER BY a.SEQ DESC;
  
