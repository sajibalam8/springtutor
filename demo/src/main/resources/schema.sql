create table users
(
   id int PRIMARY KEY auto_increment,
   userName varchar (50) unique not null,
   password varchar (50)
);


create table tracking
(
    id int PRIMARY KEY auto_increment,
   apiName varchar (50)  not null,
   startTime timestamp, 
   responseTime int 
);