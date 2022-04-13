create table driver(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255)
);

create table driver_car(
	id serial primary key,
	driver_id int references driver(id),
	car_id int references car(id)
);