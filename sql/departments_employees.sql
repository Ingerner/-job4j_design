CREATE DATABASE departments_employees;

CREATE TABLE departments(
    id serial primary key;
    name vaechar(255);
)

CREATE TABLE employees(
    id serial primary key;
    name vaechar(255);
    departments_id int REFERENCES departments(id);
)

INSERT INTO departments(name) VALUES('department-1'), ('department-2'), ('department-3');
INSERT INTO employees(name, departments_id) VALUES('employee_1', 1), ('employee_2', null), ('employee_3', 2), ('employee_4', null), ('employee_5', 3);

SELECT * FROM employees e LEFT JOIN departments d on e.depertment_id=d.id ;
SELECT * FROM employees e RIGHT JOIN departments d on e.depertment_id=d.id ;
SELECT * FROM employees e FULL JOIN departments d on e.depertment_id=d.id ;