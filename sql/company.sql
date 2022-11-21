CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

select * from company;
select * from person;

insert into company(id, name) values(1, 'Anderson');
insert into company(id, name) values(2, 'Luxoft');
insert into company(id, name) values(3, 'Альфабанк');
insert into company(id, name) values(4, 'ВТБ');
insert into company(id, name) values(5, 'Ростелеком');

insert into person(id, name,  company_id) values(1, 'Igor', 1);
insert into person(id, name,  company_id) values(2, 'Sergey', 2);
insert into person(id, name,  company_id) values(3, 'Oleg', 3);
insert into person(id, name,  company_id) values(4, 'Natalya', 4);
insert into person(id, name,  company_id) values(5, 'Olga', 5);
insert into person(id, name,  company_id) values(6, 'Aleksandr', 2);
insert into person(id, name,  company_id) values(7, 'Matvey', 4);

select p.name from person p left join company c
on p.company_id=c.id
where c.id != 5;

select c.name as company, p.name as person from person p left join company c
on p.company_id=c.id;

select c.name, count(p.name) from person p left join company c
on p.company_id=c.id
GROUP BY c.name;


