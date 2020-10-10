-- ORACLE SQL USER & PERMISSION --
user: oracle_user_app
pass: oracle_user_app_pwd

CREATE USER oracle_user_app IDENTIFIED BY oracle_user_app_pwd;

GRANT CONNECT TO oracle_user_app;
GRANT UNLIMITED TABLESPACE TO oracle_user_app;
GRANT CREATE SESSION TO oracle_user_app;

CREATE USER oracle_user_app IDENTIFIED BY oracle_user_app_pwd;

GRANT CONNECT TO oracle_user_app;
GRANT UNLIMITED TABLESPACE TO oracle_user_app;
GRANT CREATE SESSION TO oracle_user_app;
grant create table, create view, create procedure, create sequence to oracle_user_app;

-- ORACLE SQL --

CREATE TABLE EMPLOYEE (
  id      NUMBER(10)   NOT NULL,
  name   VARCHAR2(100) ,
  surname   VARCHAR2(100) ,
  birth_date DATE,
  email   VARCHAR2(100) ,
  CREATION_TIME  TIMESTAMP,
  CONSTRAINT PK_EMPLOYEE PRIMARY KEY(id)
);

CREATE SEQUENCE employee_seq
    INCREMENT BY 1
    START WITH 1
    NOMINVALUE
    NOMAXVALUE ;

-- alter add
ALTER TABLE EMPLOYEE 
ADD sample_date_col DATE NOT NULL;

select * from EMPLOYEE;
   
-- drop
ALTER TABLE EMPLOYEE 
DROP COLUMN sample_date_col;

select * from EMPLOYEE;