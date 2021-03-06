CREATE TABLE RESERVATION(
	ID NUMBER PRIMARY KEY,
	RESOURCEID VARCHAR2(10),
	TITLE VARCHAR2(50) NOT NULL,
	WRITER VARCHAR2(50) NOT NULL,
	DESCRIPTION VARCHAR2(1000),
	"START" DATE NOT NULL,
	"END" DATE NOT NULL,
	DELFLAG CHAR(1) DEFAULT 'N'
);
DROP TABLE RESERVATION ;

CREATE TABLE RESERVATION_ROOM(
	ID VARCHAR2(10) PRIMARY KEY,
	TITLE VARCHAR2(50) NOT NULL,
	DELFLAG CHAR(1) NOT NULL
);

DROP TABLE RESERVATION_ROOM ;

CREATE SEQUENCE RESERVATION_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO RESERVATION_ROOM VALUES('A','회의실A','N');
INSERT INTO RESERVATION_ROOM 
	VALUES('B','회의실B','N');

INSERT INTO RESERVATION 
values(RESERVATION_SEQ.nextval,'A',1,'할일title','김우연', '내용-content',
to_date('2022/05/07','YYYY/MM/DD'), to_date('2022/05/08','YYYY/MM/DD'),'N');

INSERT INTO RESERVATION 
values(RESERVATION_SEQ.nextval,'B','','[뚜잇뚜잇]캘린더 테스트입니다.','김우연', '프로젝트 화이팅',
to_date('2022/05/07093000','YYYY/MM/DD HH24/MI/SS'), to_date('2022/05/07132500','YYYY/MM/DD HH24/MI/SS'),'N');

SELECT ID, RESOURCEID, GROUPID, TITLE, WRITER, DESCRIPTION, TO_CHAR("START", 'YYYY-MM-DD"T"HH24:MI:SS') AS "START",
	TO_CHAR("END", 'YYYY-MM-DD"T"HH24:MI:SS') AS "END"
	FROM RESERVATION
		WHERE DELFLAG = 'N';
	

	
SELECT 
	FROM RESERVATION_ROOM
		WHERE
		AND
	ORDER BY ;

UPDATE RESERVATION SET 
	"START" = TO_DATE('2022/05/060930','YYYY/MM/DD HH24:MI'), 
	"END" = TO_DATE('2022/05/071325','YYYY/MM/DD HH24:MI'),
	RESOURCEID = 'C'
	WHERE ID='4';


INSERT INTO GD.ANSWERBOARD(SEQ, ID, TITLE, 
							CONTENT, "REF", STEP,
						    "DEPTH", DELFLAG, REGDATE)
	VALUES('', '', '', 
			0, 0, 0, 
			'N', SYSDATE);
	   
UPDATE GD.ANSWERBOARD 
	SET ID='하이'
		WHERE NAME='하이'


INSERT INTO GD.ANSWERBOARD
	(SEQ, ID, TITLE, CONTENT, "REF", STEP,"DEPTH", DELFLAG, REGDATE)
	VALUES
	('', 
	'', '', '', 0, 0, 0, 'N', SYSDATE);

DELETE FROM GD.ANSWERBOARD
	WHERE SEQ=0;

