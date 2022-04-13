create table avto(
	id serial primary key,
	name varchar(255)
);

create table ingine(
	id serial primary key,
	name varchar(255)
);

create table car_ingine(
    id serial primary key,
    car_id int references car(id) unique,
    ingine_id int references ingine(id) unique
);