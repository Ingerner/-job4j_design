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

insert into devices(name, price) values('asus', 50000), ('acer', 75000), ('lenovo', 120000), ('hp', 80000),('msi', 95000);

insert into people(name) values('Ivanov'), ('Petrov'), ('Alekseev');

insert into devices_people(devices_id, people_id) values(1, 1), (2, 2), (3, 3), (1, 3), (3, 2), (2, 1);

select avg(price) from devices;


select p.name, avg(d.price) from people p
join devices_people dp on p.id=dp.people_id
join devices d on d.id = dp.devices_id
group by p.name;

select p.name, avg(d.price) from people p
join devices_people dp on p.id=dp.people_id
join devices d on d.id = dp.devices_id
group by p.name
having avg(d.price)>50000;

SELECT  name, max(price) FROM product
GROUP BY name
ORDER BY max(price) DESC
LIMIT 1;