create table cars
(id int not null primary key auto_increment,
brand varchar(30),speed int,color varchar(30),price int,made_date date
);

insert into cars(brand,speed,color,price,made_date)
values
('Kia', 240, 'Red', 52000,'2018-05-05'),
('Bmw', 260, 'Black', 45000,'2019-05-06'),
('Mercedes', 220, 'White', 75000,'2016-07-03'),
('Ford', 200, 'Blue', 13500,'2018-05-07'),
('Nissan', 240, 'Yellow', 37000,'2021-03-09'),
('Tesla', 320, 'Green', 102000,'2013-07-06'),
('Honda', 300, 'Black', 23000,'2007-12-12'),
('Tayota', 310, 'White', 36500,'2018-10-04');

create table students
(id int not null primary key auto_increment,
name varchar(20), surname varchar(30),brithday date, email varchar(40), phone varchar(25));

insert into students(name,surname,brithday,email,phone) 
values
('Rufat','Qarayev','1989-04-18','qarayev.rufat@gmail.com','+994-51-996-3116'),
('Huseyin','Humabtov','2010-02-15','Huseyin.Humabtov@gmail.com','+994-51-996-3116'),
('Xeyal','Xellov','2010-09-26','Xellov.Xeyal@gmail.com','+994-51-996-3116'),
('Uqur','Humabtov','2012-03-15','Uqur.Humabtov@gmail.com','+994-51-996-3116'),
('Leyla','Qarayeva','2018-10-04','qarayeva.leyla@gmail.com','+994-51-996-3116');

create table users
( username varchar(30) not null primary key,
password varchar(100) not null,
enabled int
);

insert into users(username,password,enabled) values
('rufat','{noop}1',1);


create table authorities
( username varchar(30) not null,
authority varchar(30) not null
);


insert into authorities (username,authority)
values
('rufat','admin'),
('rufat','list:cars'),
('rufat','list:students'),
('rufat','show-save-page:students'),
('rufat','save:students'),
('rufat','edit:students'),
('rufat','delete:students'),

('rufat','list:books'),
('rufat','save:book'),
('rufat','open:save:book'),
('rufat','open:edit:book'),
('rufat','delete:book'),
('rufat','edit:book'); 


 

insert into books (name,price,page_count,publish_date)
values
('java',300,2,'2022-01-01'),
('css',300,2,'2022-01-01'),
('python',300,2,'2022-01-01'),
('html',300,2,'2022-01-01'),
('spring',300,2,'2022-01-01'),
('react',300,2,'2022-01-01'),
('angular',300,2,'2022-01-01'),
('vue',300,2,'2022-01-01'),
('sql',300,2,'2022-01-01');

insert into authors (name)
values
('Rufat'),('Anar'),('Vusal'),('Orxan'),('Nicat'),('Akber');




