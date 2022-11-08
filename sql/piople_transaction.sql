create table human(
	last_name varchar(50),
	first_name varchar(50),
	age integer
);

insert into human(last_name, first_name, age) values('Sergey', 'Petrov', 30);
insert into human(last_name, first_name, age) values('Andrey', 'Ivanov', 25);
insert into human(last_name, first_name, age) values('Ivan', 'Sidorov', 35);

select * from human;