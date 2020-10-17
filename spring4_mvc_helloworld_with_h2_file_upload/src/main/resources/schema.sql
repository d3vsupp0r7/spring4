-- EMPLOYEE TABLE
create table if not exists employee(

   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(255) not null,
   surname varchar(255) not null,
   primary key(id)

);

-- EMPLOYEE TABLE
create table if not exists employeefull(

   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(255) not null,
   surname varchar(255) not null,
   -- numerics
   salary_double number(10,2),
   salary_big_decimal number(10,2),
   -- dates
   birth_date date,
   creation_time timestamp,
   -- large data
   useful_info         clob,
   document blob
   --
   primary key(id)

);