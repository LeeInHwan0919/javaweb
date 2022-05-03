CREATE TABLE SPRINGMEMBER(
	ID VARCHAR2(50),
	PW VARCHAR2(300) NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	EMAIL VARCHAR2(50) NOT NULL,
	AUTH CHAR(1) NOT NULL,
	DELFLAG CHAR(1) NOT NULL,
	REGDATE DATE NOT NULL,
	CONSTRAINT "SPRINGMEMBER_PK" PRIMARY KEY(ID),
	CONSTRAINT "SPRINGMEMBER_CK" CHECK("AUTH" IN('U','A'))
);
DROP TABLE SPRINGMEMBER;
DROP TABLE SPRINGBOARD ;

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
	CONSTRAINT "SPRINGBOARD_PK" PRIMARY KEY (SEQ),
	CONSTRAINT "SPRINGBOARD_FK" FOREIGN KEY ("ID") REFERENCES SPRINGMEMBER("ID")
);

CREATE SEQUENCE SPRINGBOARD_SEQ START WITH 1 INCREMENT BY 1;


--새글쓰기
INSERT INTO SPRINGBOARD  (SEQ, ID, TITLE, 
            CONTENT, REFER, STEP,
            DEPTH,READCOUNT,DELFLAG ,REGDATE)
      VALUES(SPRINGBOARD_SEQ.NEXTVAL , 'USER', SPRINGBOARD_SEQ.CURRVAL||'번쨰 새글',
          SPRINGBOARD_SEQ.CURRVAL||'번째 새글 내용', (SELECT NVL(MAX(REFER),0) +1 FROM SPRINGBOARD s),0,
          0,0,'N',SYSDATE);
        
INSERT INTO SPRINGMEMBER (ID, PW,NAME,EMAIL, AUTH, DELFLAG, REGDATE)
	VALUES('G00'||SPRINGMEMBER_ID.NEXTVAL, 1234,'홍길동','1234@NAVER.COM', 'U', 'Y', SYSDATE);

CREATE SEQUENCE SPRINGMEMBER_ID START WITH 1 INCREMENT BY 1;


