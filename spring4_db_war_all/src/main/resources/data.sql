-- EMPLOYEE TABLE: INITIAL LOAD EXAMPLE DATA
INSERT INTO EMPLOYEE (ID, NAME, SURNAME) VALUES (1001, 'AEmployeeSampleName001','AEmployeeSampleSurname001');
INSERT INTO EMPLOYEE (ID, NAME, SURNAME) VALUES (1002, 'AEmployeeSampleName002','AEmployeeSampleSurname002');
INSERT INTO EMPLOYEE (ID, NAME, SURNAME) VALUES (1003, 'AEmployeeSampleName003','AEmployeeSampleSurname003');

-- EMPLOYEEFULL TABLE: INITIAL LOAD EXAMPLE DATA - ORACLE SYNTAX - START
-- INSERT INTO employeefull (ID, NAME, SURNAME, birthdate) VALUES (1, 'AFullSampleName001','AFullSampleSurname001',
-- TO_DATE('01/01/1980 21:02:44', 'dd/mm/yyyy hh24:mi:ss') );
INSERT INTO employeefull (ID, NAME, SURNAME, birth_date, creation_time) VALUES (1, 'AFullSampleName001','AFullSampleSurname001', TO_DATE('01/01/1980', 'dd/mm/yyyy'), TO_TIMESTAMP('20/09/2020 06:14:00.742000000', 'DD/MM/YYYY HH24:MI:SS.FF'));
-- Initial load of document
INSERT INTO employeefull (ID, NAME, SURNAME, document) VALUES (2, 'AFN_Name002_Document_InitialLoad','AFS_Surname002_Document_InitialLoad', FILE_READ('classpath:/org/lba/h2file/TXT_Sample_File.txt'));
-- Numeric fields
INSERT INTO employeefull (ID, NAME, SURNAME,salary_double,salary_big_decimal) VALUES (3, 'AFN_Name003_Numeric_2Dec','AFS_Surname003_Numeric_2Dec',1234.56,1234.56);
INSERT INTO employeefull (ID, NAME, SURNAME,salary_double,salary_big_decimal) VALUES (4, 'AFN_Name004_Numeric_4Dec','AFN_Surname004_Numeric_4Dec',91234.5678,91234.5678);
--
INSERT INTO employeefull (ID, NAME, SURNAME,useful_info) VALUES (5, 'AFN_Name005_Clob','AFN_Surname005_clob','1000_bytes_Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas porttitor accumsan libero, ut porttitor dui ultrices ut. Aliquam auctor est eget urna tempor, in lacinia lorem fringilla. Vivamus in est at dolor lacinia bibendum in eu tellus. Donec vulputate augue lacinia pharetra lacinia. Aliquam justo nulla, tristique id mauris ut, luctus gravida purus. Nunc iaculis quam a gravida mollis. Nullam id egestas mi. Nullam sit amet risus ac nibh finibus tempor id et enim. Suspendisse pulvinar, magna in varius efficitur, odio felis imperdiet nunc, sed finibus est dolor vel leo. Nulla ex massa, eleifend id lectus eu, elementum ullamcorper lorem. Proin vestibulum, massa sed euismod maximus, lectus lectus aliquet leo, a suscipit mauris odio id justo. In imperdiet sodales ultrices. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; In aliquam pulvinar pharetra. Aliquam erat volutpat. Phasellus eu quam et orci interdum aliquam. Morbi elementum ex.');

-- EMPLOYEEFULL TABLE: INITIAL LOAD EXAMPLE DATA - ORACLE SYNTAX - END

-- EMPLOYEEFULL TABLE: INITIAL LOAD EXAMPLE DATA - <DB TYPE> SYNTAX - START
-- EMPLOYEEFULL TABLE: INITIAL LOAD EXAMPLE DATA - <DB TYPE> SYNTAX - END
