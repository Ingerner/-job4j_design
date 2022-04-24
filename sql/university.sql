create database university;
select * from students;
select name, course, speciality from students;
select * from students where course = 2;
select * from students where course != 2;
select * from students where name is null;
select * from students where course > 2;
select * from students where name like 'D%';
select * from students where name like 'D%' AND course > 2;
select * from students where name like 'D%' OR course > 2;
select current_date;
select current_date > '10.09.2020';
select current_date + interval '1 month';
select current_date + interval '1 day';
select current_date + interval '1 week';
select current_date + interval '1 hour';
select * from students ORDER BY speciality ASC;
select * from students ORDER BY speciality DESC;
select distinct course from students;
select * from students limit 5;