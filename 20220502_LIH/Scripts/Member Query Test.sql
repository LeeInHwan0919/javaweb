-- 샘플 데이터 입력

INSERT INTO GD.SPRINGMEMBER
(ID, PW, NAME,EMAIL ,AUTH, DELFLAG, REGDATE)
VALUES('ADMIN', '1234', '이인환', '1234@naver.com' , 'A', 'N', SYSDATE);

--회원 전체 조회 (등록일순 내림차순)
SELECT ID, AUTH, DELFLAG , REGDATE 
	FROM SPRINGMEMBER s 
		WHERE AUTH = 'U'
		ORDER BY REGDATE DESC;
	

--회원가입
INSERT INTO GD.SPRINGMEMBER
(ID, PW, AUTH, DELFLAG, REGDATE)
VALUES('ADMIN', '1234', 'A', 'N', SYSDATE);

--로그인
SELECT COUNT(ID)
	FROM SPRINGMEMBER s 
		WHERE ID='USER' AND PW = '1234'
		AND DELFLAG = 'N';
		
-- 비밀번호 확인
SELECT PW 
	FROM SPRINGMEMBER s 
		WHERE ID = 'USER';

--아이디 찾기
SELECT ID
	FROM SPRINGMEMBER s 
	WHERE NAME ='테스트' AND EMAIL ='test@naver.com';

SELECT * FROM SPRINGMEMBER s ;

--비밀번호 변경
SELECT COUNT(*) FROM SPRINGMEMBER s
WHERE ID='test' AND NAME='테스트' AND EMAIL='test@naver.com';

UPDATE SPRINGMEMBER SET PW='1234' WHERE ID='test';