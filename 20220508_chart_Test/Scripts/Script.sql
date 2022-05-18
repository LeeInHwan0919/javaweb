CREATE TABLE test1(
area_code varchar(20) NOT NULL
CONSTRAINT area_code PRIMARY KEY,
area varchar(20) NOT NULL
);

DROP TABLE test2;


CREATE TABLE test2(
seq varchar(5) NOT NULL
CONSTRAINT PK_seq PRIMARY KEY,
client varchar(20) NOT NULL,
area_code varchar(20) NOT null
);


ALTER TABLE test2 ADD CONSTRAINT FKarea_code
    FOREIGN KEY (area_code) REFERENCES test1(area_code);

INSERT INTO TEST1 (AREA_CODE, AREA) VALUES('001', '서울');
INSERT INTO TEST1 (AREA_CODE, AREA) VALUES('002', '부산');
INSERT INTO TEST1 (AREA_CODE, AREA) VALUES('003', '울산');

INSERT INTO TEST2 (seq, client, area_code) VALUES('1', '거래처1', '001');
INSERT INTO TEST2 (seq, client, area_code) VALUES('2', '거래처2', '002');
INSERT INTO TEST2 (seq, client, area_code) VALUES('3', '거래처3', '003');
 SELECT * FROM test2;
 SELECT seq, client, 
   (SELECT area FROM test1
   WHERE area_code = (SELECT AREA_CODE FROM test2))FROM test2;
   
   SELECT seq, client, area FROM test2 LEFT JOIN test1 ON test2.area_code=test1.AREA_CODE;
   
 

select<열 목록>

From < 첫 번째 테이블 >

        Inner join <두 번째 테이블>

       on<조인될 조건>

[where 검색 조건]
  
  