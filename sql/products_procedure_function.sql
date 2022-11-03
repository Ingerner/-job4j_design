create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);
--//-----------------------------------//--
create or replace procedure insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
language 'plpgsql'
as $$
    BEGIN
    insert into products (name, producer, count, price)
    values (i_name, prod, i_count, i_price);
    END
$$;
--//-----------------------------------//--
call insert_data('product_2', 'producer_2', 15, 32);
--//-----------------------------------//--
select * from products;
--//-----------------------------------//--
create or replace procedure update_data(u_count integer, tax float, u_id integer)
language  'plpgsql'
as $$
	BEGIN
	IF u_count > 0 THEN
	update products set count = count - u_count WHERE id = u_id;
	end IF;
	if tax > 0 THEN
	update products set price = price + price * tax;
	end IF;
	END;
$$

call update_data(10, 0, 1);
	