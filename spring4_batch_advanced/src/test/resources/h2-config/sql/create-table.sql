create table if not exists employee(

   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name varchar(255) not null,
   surname varchar(255) not null,
   bornDate DATE, 
   primary key(id)

);