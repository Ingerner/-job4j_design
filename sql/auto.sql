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
	id_kuzon int references kuzov(id),
	id_egine int references engine(id),
	id_transmission int references transmission(id)
)

insert into kuzov(name) values('седан'), ('купе'), ('универсал'), ('хетчбэк'), ('минивен');

insert into engine(name) values('бензиновый'), ('газовый'), ('дизельный'), ('электрический');

insert into transmission(name) values('механическая'), ('роботизированная'), ('гидромеханическая'), ('вариатор');

insert into car(name, id_kuzon, id_egine, id_transmission) values('бмв', 2, 1, 3),
																	('ауди', 1, 3, 4),
																	('форд', 3, 1, 1),
																	('тойота', 3, 4, null),
																	('шевроле', null, null, null);



