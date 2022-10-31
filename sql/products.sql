create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5 AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger discount_trigger
    after insert
    on products
    for each row
    execute procedure discount();
	
	
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
	
select * from products;
	
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
	
alter table products disable trigger discount_trigger;

delete from products;

-- триггер 1 --
  
create or replace function tax_with_price()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
		where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';
	

create trigger tax_stat
	 AFTER insert on products
	 referencing new table as inserted
	 for each statement
   	 execute procedure tax_with_price();
	 
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
	
select * from products;

-- триггер 2 --

create or replace function tax_row()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_with_price_row
    BEFORE insert
    on products
    for each row
    execute procedure tax_row();
	
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
	
select * from products;

-- триггер 3 --
create view product_view as select * from products

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function product_addition()
    returns trigger as
$$
    BEGIN
        insert into history_of_price(name, price)
		values (new.name, new.price);
		return price_name_and_date;
    END;
$$
LANGUAGE 'plpgsql';

create trigger price_name_and_date
	INSTEAD OF insert
	on product_view 
	for each row
    execute procedure product_addition();

drop trigger price_name_and_date on product_view ;

insert into products(name, producer, count, price) values ('11', '123', 1, 15)

select * from history_of_price

	