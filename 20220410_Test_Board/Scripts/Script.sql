SELECT JOB_ID ,JOB_TITLE ,MIN_SALARY ,MAX_SALARY 
FROM JOBS j ;

-- GD.JOBS definition

CREATE TABLE "GD"."JOBS" 
   (   "JOB_ID" VARCHAR2(10), 
   "JOB_TITLE" VARCHAR2(35) NOT NULL ENABLE, 
   "MIN_SALARY" NUMBER(6,0), 
   "MAX_SALARY" NUMBER(6,0), 
    CONSTRAINT "JOB_ID_PK" PRIMARY KEY ("JOB_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "GD"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "GD" ;

CREATE UNIQUE INDEX "GD"."JOB_ID_PK" ON "GD"."JOBS" ("JOB_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "GD" ;
  
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('AD_PRES','President',20000,40000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('AD_VP','Administration Vice President',15000,30000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('AD_ASST','Administration Assistant',3000,6000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('FI_MGR','Finance Manager',8200,16000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('FI_ACCOUNT','Accountant',4200,9000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('AC_MGR','Accounting Manager',8200,16000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('AC_ACCOUNT','Public Accountant',4200,9000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('SA_MAN','Sales Manager',10000,20000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('SA_REP','Sales Representative',6000,12000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('PU_MAN','Purchasing Manager',8000,15000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('PU_CLERK','Purchasing Clerk',2500,5500);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('ST_MAN','Stock Manager',5500,8500);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('ST_CLERK','Stock Clerk',2000,5000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('SH_CLERK','Shipping Clerk',2500,5500);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('IT_PROG','개발자',100000,10000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('MK_MAN','Marketing Manager',9000,15000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('MK_REP','Marketing Representative',4000,9000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('HR_REP','Human Resources Representative',4000,9000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('IT_GOO','it programmer',1000,10000);
INSERT INTO GD.JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('IT','Developer',1000,2000);