create table reader(
	id serial primary key,
	name varchar(255)
);

create table books(
	id serial primary key,
	name varchar(255),
	author varchar(255),
	reader_id int references reader(id)
);
