CREATE DATABASE departments_employees;

CREATE TABLE departments(
    id serial primary key,
    name varchar(255)
)

CREATE TABLE employees(
    id serial primary key,
    name varchar(255),
    departments_id int REFERENCES departments(id)
)

INSERT INTO departments(name) VALUES('department-1'),
                                    ('department-2'),
                                    ('department-3'),
                                    ('department-4');
INSERT INTO employees(name, departments_id) VALUES  ('employee_1', 1),
                                                    ('employee_2', null),
                                                    ('employee_3', 2),
                                                    ('employee_4', null),
                                                    ('employee_5', 3);

SELECT * FROM employees e LEFT JOIN departments d on e.departments_id=d.id ;

SELECT * FROM employees e RIGHT JOIN departments d on e.departments_id=d.id ;

SELECT * FROM employees e FULL JOIN departments d on e.departments_id=d.id ;

SELECT * FROM employees  CROSS JOIN departments;

SELECT * FROM departments d LEFT JOIN employees e on e.departments_id=d.id
Where e.id is null;

SELECT e.id, e.name, e.departments_id, d.id, d.name FROM employees e LEFT JOIN departments d on e.departments_id=d.id ;
SELECT  e.id, e.name, e.departments_id, d.id, d.name FROM  departments d RIGHT JOIN employees e on d.id=e.departments_id;


CREATE TABLE teens(
	id serial primary key,
	name varchar(255),
	gender char(1)
)

INSERT INTO teens(name, gender) VALUES  ('Igor', 'm'), ('Sergey', 'm'), ('Egor', 'm'),
										('Oleg', 'm'), ('Petr', 'm'), ('Mihail', 'm'),
										('Andrey', 'm'), ('Stas', 'm'), ('Aleksey', 'm'),
										('Marina', 'w'), ('Ekaterina', 'w'), ('Anna', 'w'),
										('Anastasiya', 'w'), ('Ira', 'w'), ('Olga', 'w'),
										('Mariya', 'w'), ('Elena', 'w'), ('Natalya', 'w');

SELECT t1.name as M, t2.name as W FROM teens t1 CROSS JOIN teens t2
WHERE t1.gender != t2.gender;