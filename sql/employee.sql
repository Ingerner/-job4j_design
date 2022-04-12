create table employee (
	id serial primary key,
	surname varchar(255),
	phone text,
	age int,
	sex char(1),
	employment_date date
);
insert into employee(surname, phone, age, sex, employment_date)
values('Ivanov', '32-890', 40, 'm', '2020,08, 25');
select * from employee;
update employee set surname = 'Petrov',
				phone = '49-4342',
				age = '25',
				employment_date = '2021, 05, 07';
delete from employee;
