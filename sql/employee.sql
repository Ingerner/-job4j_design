insert into employee(surname, phone, age, sex, employment_date)
values('Ivanov', '32-890', 40, 'm', '2020,08, 25');
select * from employee;
update employee set surname = 'Petrov',
				phone = '49-4342',
				age = '25',
				employment_date = '2021, 05, 07';
delete from employee;
