CREATE DATABASE products;

CREATE TABLE type(
    id serial primary key,
    name text
)

CREATE TABLE product(
    id serial primary key,
    name text,
    date timestamp,
    price float,
    type_id int REFERENCES type(id)
)

INSERT INTO type(name) VALUES('сыр'), ('мороженное'),('молоко');

INSERT INTO product(name, date, price, type_id) VALUES('сыр плавленный', date '2022-01-10',90.50, 1),
                                                    ('маздам', date '2022-05-20',100, 1),
                                                    ('адыгейский', date '2022-03-15',75.90, 1),
                                                    ('российский', date '2022-06-01',95, 1),
                                                    ('мороженное максибом', date '2022-07-15',60, 2),
                                                    ('мороженное экстрем', date '2022-03-05',70, 2),
                                                    ('мороженное щербет', date '2022-08-10',90, 2),
                                                    ('мороженное пломбир', date '2022-06-25',50, 2),
                                                    ('амка', date '2022-05-10',80.50, 3),
                                                    ('простоквашино', date '2022-09-11',85, 3),
                                                    ('домик в деревне', date '2022-03-10',70, 3),
                                                    ('кифир', date '2022-07-12',90, 3),
                                                    ('ряженка', date '2022-08-09',90, 3);

SELECT p.name FROM product p
JOIN type t ON p.type_id = t.id
WHERE t.name like 'сыр';

SELECT name FROM product
WHERE name LIKE '%мороженное%';

SELECT name FROM product
WHERE date < current_date;

SELECT  name, price FROM product
WHERE price = (select max(price) from product);

SELECT  t.name, count(p.name) FROM type t
JOIN product p ON t.id=p.type_id
GROUP BY t.name;

SELECT  t.name, count(p.name) FROM type t
JOIN product p ON t.id=p.type_id
WHERE t.name LIKE 'сыр' OR t.name LIKE 'молоко'
GROUP BY t.name;

SELECT   t.name  FROM type t
JOIN product p ON t.id=p.type_id
GROUP BY t.name
having count(t.name)<10;

SELECT  p.name, t.name  FROM type t
JOIN product p ON t.id=p.type_id;