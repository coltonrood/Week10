create database if not exists fish;

use fish;

drop table if exists fishes;

create table fishes ( 
	id int not null auto_increment,
	name varchar(50) not null,
	primary key(id)
	);
	