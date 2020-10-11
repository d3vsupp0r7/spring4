--INSERT INTO employee VALUES (1, 'ASampleName001', 'ASampleSurname001');
--INSERT INTO employee VALUES (2, 'ASampleName002','ASampleSurname002');
--INSERT INTO employee VALUES (3, 'ASampleName003', 'ASampleSurname003');

-- SECURITY: IMPO H2: insert all on same line. If not, use hibernate property: hibernate.hbm2ddl.import_files_sql_extractor=org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor
INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES 
	(1,'normal_user_1', '$2a$10$Vfs8YMQx1YHI.d0x4WO8n.C.K3prfllnP2uS/j8ChpRirS17y.N42', 'User1_Name User1_Surname', 'ROLE_USER', 'India', 1);
INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES	
	(2,'admin_user', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', 'ADMIN_User1_Name ADMIN_User1_Surname', 'ROLE_ADMIN', 'India', 1);
INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES 
	(3,'admin_user_2', '$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q', 'ADMIN_User2_Name ADMIN_User2_Surname', 'ROLE_ADMIN', 'US', 1); 
--
INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES 
	(4,'admin_user_inactive', '$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q', 'ADMIN_UserInactive_Name ADMIN_UserInactive_Surname', 'ROLE_ADMIN', 'US', 0); 

INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES 
	(5,'user_inactive', '$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q', 'UserInactive_Name UserInactive_Surname', 'ROLE_USER', 'US', 0); 

-- IN MEMORY test example DB
INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES 
	(100,'user1', 'abc123', 'UserActive_Name UserActive_Surname', 'ROLE_USER', 'US', 1); 

	INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES 
	(101,'admin', 'root123', 'ADMIN_UserActive_Name ADMIN_UserActive_Surname', 'ROLE_USER', 'US', 1); 

	INSERT INTO users (id,username, password, full_name, role, country, enabled) VALUES 
	(102,'dba', 'rootDBA123', 'ADMIN_DBA_UserActive_Name ADMIN_DBA_UserActive_Surname', 'ROLE_USER', 'US', 1); 
