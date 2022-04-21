create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values('scdfish',15000, date '1950-03-01');
insert into fauna(name, avg_age, discovery_date) values('dfish', 10000, date '1800-05-01');
insert into fauna(name, avg_age, discovery_date) values('scd', 20000, date '2000-02-03');
insert into fauna(name, avg_age, discovery_date) values('fishscd', 5000, date '1000-08-04');

select * from fauna where name  like '%fish%';
select * from fauna where avg_age >= 10000 AND  avg_age <= 21000;
select * from fauna where discovery_date is null;
select name from fauna where discovery_date < '1950-01-01';