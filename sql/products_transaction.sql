create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

select * from products;

delete from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);
commit;
select * from products;

begin transaction;
	insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 17, 45);
	savepoint first_savepoint;
	delete from products where price = 115;
	update products set price = 75 where name = 'product_1';
	select * from products;
	rollback to first_savepoint;
	select * from products;
commit;

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 20, 70);
savepoint first_savepoint;
delete from products where name = 'product_6';
select * from products;
savepoint second_savepoint;
update products set count = 10 where name = 'product_1';
select * from products;
rollback to first_savepoint;
select * from products;
rollback to second_savepoint;
commit;

select * from products;

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 20, 70);
savepoint first_savepoint;
update products set price = 75 where name = 'product_1';
savepoint second_savepoint;
delete from products where id = 4;
select * from products;
release savepoint first_savepoint;
savepoint third_savepoint;
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 20, 70);
select * from products;
rollback to third_savepoint;
commit;

select * from products;
