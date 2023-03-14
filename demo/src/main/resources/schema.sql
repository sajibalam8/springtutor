create table users
(
   id int PRIMARY KEY auto_increment,
   userName varchar (50) unique not null,
   password varchar (50)
);