create table kuzov(
    id serial primary key,
    name text
);

create table engine(
    id serial primary key,
    name text  
);

create table transmission(
    id serial primary key,
    name text
);

create table car(
    id serial primary key,
    name text,
	id_kuzov int references kuzov(id),
	id_egine int references engine(id),
	id_transmission int references transmission(id)
);

insert into kuzov(name) values('седан'), ('купе'), ('универсал'), ('хетчбэк'), ('минивен');
insert into kuzov(name) values('пикап');


insert into engine(name) values('бензиновый'), ('газовый'), ('дизельный'), ('электрический');
insert into engine(name) values('водородный');

insert into transmission(name) values('механическая'), ('роботизированная'), ('гидромеханическая'), ('вариатор');

insert into car(name, id_kuzov, id_egine, id_transmission) values('бмв', 2, 1, 3),
																	('ауди', 1, 3, 4),
																	('форд', 3, 1, 1),
																	('тойота', 3, 4, null),
																	('шевроле', null, null, null);
select c.name, k.name, e.name, t.name from car c left join kuzov k
on c.id_kuzov=k.id
left join engine e
on c.id_egine=e.id
left join transmission t
on c.id_transmission=t.id;

select k.name from kuzov k left join car c
on k.id=c.id_kuzov
where c.name is null;

select e.name from engine e left join car c
on e.id=c.id_egine
where c.name is null;

select t.name from transmission t left join car c
on t.id=c.id_transmission
where c.name is null;

