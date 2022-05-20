CREATE TABLE CONTRACT_MANAGEMENT(
  CT_CODE NUMBER PRIMARY KEY,
  CLI_NUM VARCHAR(100),
  STATUS VARCHAR(10) NOT NULL,
  CT_DATE_SUM DATE NOT NULL,
  CONSTRAINT "CLI_NUM_FK" FOREIGN KEY ("CLI_NUM") REFERENCES CLIENT("CLI_NUM")
);
 
 
SELECT * FROM CONTRACT_MANAGEMENT;

DROP TABLE CONTRACT_MANAGEMENT;

INSERT INTO GD.CONTRACT_MANAGEMENT
(CT_CODE, CLI_NUM, STATUS, CT_DATE_SUM)
VALUES(1234567, '212-46-37311', '테스트', SYSDATE);

SELECT * FROM CLIENT ;

DROP TABLE CONTRACT;