create table if not exists employee(

   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(255) not null,
   surname varchar(255) not null,
   primary key(id)

);

create table if not exists users (

  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username varchar(50) not null,
  password varchar(100) not null,
  full_name varchar(100) not null,
  role varchar(50) not null,
  country varchar(100) not null,
  enabled int(1) not null,
  primary key(id)
  
);