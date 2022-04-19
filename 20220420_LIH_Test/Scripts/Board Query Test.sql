-- 샘플데이터 입력하기
INSERT INTO GD.SPRINGBOARD
(SEQ, ID, TITLE, CONTENT, STEP, "DEPTH", REFER, READCOUNT, DELFLAG, REGDATE)
VALUES(SPRINGBOARD_SEQ.NEXTVAL, 'ADMIN', '스프링 보드', '스프링 보드입니다..', 0, 0, 
		(SELECT NVL(MAX(REFER),0) FROM SPRINGBOARD s)+1, 0, 'N', SYSDATE);

-- 새글 쓰기
SELECT  SPRINGBOARD_SEQ.NEXTVAL SEQ FROM DUAL

INSERT INTO SPRINGBOARD
	(SEQ, ID, TITLE,
	<if test="content != null">
		CONTENT,
	</if>
		STEP, "DEPTH", REFER, READCOUNT, DELFLAG, REGDATE)
		VALUES(#{seq} , #{id}, #{title}, 
	<if test="content != null">
		#{content},
	</if>
		0,0,(SELECT NVL(MAX(REFER),0) FROM SPRINGBOARD s)+1, 0, 'N', SYSDATE)

ALTER TABLE SPRINGBOARD MODIFY CONTENT DEFAULT '작성된 글이 없습니다';

	
--답글 쓰기(업데이트, 답글입력 Transaction)
UPDATE  SPRINGBOARD SET STEP = STEP +1
WHERE REFER = (SELECT REFER FROM SPRINGBOARD s WHERE SEQ='1')
AND STEP > (SELECT STEP FROM SPRINGBOARD s2 WHERE SEQ='1');

INSERT INTO GD.SPRINGBOARD
(SEQ, ID, TITLE, CONTENT, STEP, "DEPTH", REFER, READCOUNT, DELFLAG, REGDATE)
VALUES(SPRINGBOARD_SEQ.NEXTVAL, 'USER', '답글제목', '답글내용'
		,(SELECT STEP+1 FROM SPRINGBOARD s2 WHERE SEQ='1')
		,(SELECT "DEPTH"+1 FROM SPRINGBOARD s3 WHERE SEQ='1')
		,(SELECT REFER FROM SPRINGBOARD s WHERE SEQ='1')
		, 0, 'N', SYSDATE)
		
-- 상세글 보기
SELECT SEQ, ID, TITLE, CONTENT, READCOUNT, REGDATE 
	FROM SPRINGBOARD s 
		WHERE SEQ = '2';

--조회수(상세조회와 동시 진행)
UPDATE SPRINGBOARD 
	SET READCOUNT = READCOUNT+1
		WHERE SEQ = '2';

-- 글수정 
UPDATE SPRINGBOARD 
	SET TITLE = '수정된 제목', CONTENT = '수정 내용'
		WHERE SEQ = '2';


--글삭제 > [] 로 쓸 쿼리
UPDATE SPRINGBOARD  SET DELFLAG ='Y' WHERE DELFLAG='N' AND SEQ = '3';


-- 글삭제 2 > [] 로 쓸 쿼리
DELETE FROM SPRINGBOARD WHERE SEQ = '3';


-- 게시글 전체조회(삭제된글을 볼수있는 관리자와 아닌 사용자로 나뉨 , test는 LPAD로 작성 (dao는 그냥작성))
--LPAD 게시글 전체조회
SELECT SEQ, ID, LPAD(' ', 3*"DEPTH") || TITLE AS TITLE, STEP, "DEPTH" , REFER, READCOUNT, DELFLAG, REGDATE
	FROM SPRINGBOARD s
		ORDER BY REFER DESC, STEP;
--일반 게시글 전체조회
SELECT SEQ, ID, TITLE, STEP, "DEPTH" , REFER, READCOUNT, DELFLAG, REGDATE
	FROM SPRINGBOARD s
		ORDER BY REFER DESC, STEP;
