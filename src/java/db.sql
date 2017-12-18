create database machine;
use machine;
#用户
create table users(
  int id auto_increment primary key,
  name varchar(32),
  password varchar(32)
);
insert into users(1,'feng','123456');
insert into users(2,'xiaoming','123456');
#操作
create table operation(
 id int auto_increment primary key,
 name varchar(32) not null unique,
 sentence_class varchar(32) not null unique,
 operation_class varchar(32) not null unique
);
insert into operation values(1,'add','sentence.AddSentence','operation.Add');
insert into operation values(2,'weather','sentence.WeatherSentence','operation.WeatherOperation')
insert into operation values(3,'abs','sentence.AbsSentence','operation.Abs');
insert into operation values(4,'max','sentence.MaxSentence','operation.Max');

#资源
create table resource(
 int id auto_increment primary key,
 int user_id,
 int operation_id,
 foreign key (operation_id) references operation(id),
 unique key(user_id,operation_id)
);
insert into resource(1,1,1);
insert into resource(2,1,2);
insert into resource(3,1,3);
insert into resource(4,1,4);
#关键字
create table keyword(
  id int auto_increment primary key,
  word varchar(32) not null unique,
  operation_id int not null,
  foreign key (operation_id) references operation(id)
);
insert into keyword values(1,'加',1);
insert into keyword values(2,'天气',1);
insert into keyword values(3,'绝对值',3);
#天气表
CREATE TABLE weather (
  id int auto_increment primary key,
  city varchar(64) NOT NULL,
  situation varchar(64) NOT NULL
);
insert into weather values(1,'北京','天气晴朗，温度25°');


