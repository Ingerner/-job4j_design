create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people (
	id serial primary key,
	name varchar(255)
);

create table devices_people(
	id serial primary key,
	devices_id int references devices(id),
	people_id int references people(id)
)

insert into devices(name, price) values('asus', 50000), ('acer', 50000), ('lenovo', 50000), ('hp', 50000),('msi', 50000);

insert into people(name) values('Ivanov'), ('Petrov'), ('Alekseev');

insert into devices_people(devices_id, people_id) values(1, 1), (2, 2), (3, 3), (1, 3), (3, 2), (2, 1);

select avg(price) from devices;

select p.name, avg(d.price) from devices as d
join people as p
on p.id = d.id
group by p.name;