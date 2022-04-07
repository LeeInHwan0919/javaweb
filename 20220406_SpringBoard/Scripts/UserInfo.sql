
CREATE TABLE USERINFO(
  ID VARCHAR2(30) NOT NULL,
  NAME VARCHAR2(100) NOT NULL,
  PASSWORD VARCHAR2(1000) NOT NULL,
  EMAIL VARCHAR2(100) NOT NULL,
  AUTH CHAR(1) NOT NULL,
  DELFLAG CHAR(1) NOT NULL,
  JOINDATE DATE NOT NULL
);



ALTER TABLE USERINFO ADD CONSTRAINT EMAIL_UQ UNIQUE (EMAIL);
ALTER TABLE USERINFO ADD CONSTRAINT USERINFO_PS PRIMARY KEY (ID);

--------------------------------------
--회원등록
INSERT INTO USERINFO
(ID, NAME, PASSWORD, EMAIL, AUTH, DELFLAG, JOINDATE)
VALUES('jinro', '참이슬', '1234', 'jinro@gmail.com', 'U', 'N', SYSDATE);
INSERT INTO USERINFO
(ID, NAME, PASSWORD, EMAIL, AUTH, DELFLAG, JOINDATE)
VALUES('admin', '관리자', '1234', 'admin@gmail.com', 'A', 'N', SYSDATE);

SELECT ID, NAME, EMAIL , AUTH
  FROM USERINFO u 
  WHERE DELFLAG = 'N' 
  AND ID='jinro'
  AND PASSWORD ='1234';

SELECT * FROM USERINFO u;
INSERT INTO USERINFO  values ('ldkkoj111', '이인환', '123456','ldkkoj777@naver.com','U','N',SYSDATE)

SELECT ID, NAME, AUTH FROM USERINFO
WHERE ID = 'ldkkoj111' AND PASSWORD='123456';