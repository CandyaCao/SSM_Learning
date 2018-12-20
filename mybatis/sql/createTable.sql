--创建Student表
create table candyacao_student(
	id int primary key,
	name varchar(20),
	age int,
	address varchar(50),
	phone varchar(20)
);
--创建Customer表
create table candyacao_customer(
	id int primary key,
	username varchar(20),
	password varchar(20),
	dob date,
	address varchar(50),
);

--一对一，在任意一方建立外键
create table wife(
	wid int primary key,
	name varchar(30)
);
create table husband(
	hid int primary key,
	name varchar(30),
	wife_id int references wife(wid)
);
--一对多，在多的一方建立外键
create table order(
	id int primary key,
	name varchar(50),
	price int,
	dob date
);

create table orderLine(
	id int primary key,
	name varchar(50),
	price int,
	nums int,
	order_id int references order(id)
);

--special
create table t_user(
	id int primary key,
	name varchar(50),
	gender varchar(10)
);

create table user_pics( 
	id int primary key, 
	name varchar(50) , 
	pic blob, 
	bio text
); 