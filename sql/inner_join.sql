create database lybrary;

create table reader(
	id serial primary key,
	surname varchar(255)
);

create table books(
	id serial primary key,
	book_title varchar(255),
	author varchar(255),
	reader_id int references reader(id)
);

insert into reader(surname) values('Ivanov');
insert into reader(surname) values('Petrov');
insert into reader(surname) values('Sidorov');
insert into reader(surname) values('Aleksev');

insert into books(book_title, author, reader_id) values('Voyna i mir', 'Tolstoy',1);
insert into books(book_title, author, reader_id) values('Graf montekristo', 'Duma', 1);
insert into books(book_title, author, reader_id) values('Na reke', 'Kuprin',2);
insert into books(book_title, author, reader_id) values('Na oblachnom beregu', 'Grin',3);

select *from books 
join reader r
on books.reader_id=r.id;


select b.book_title, b.author, r.surname from books as b
join reader as r
on b.reader_id=r.id;

select b.book_title as Название_книги, b.author as Автор, r.surname as Фамилия from books as b
join reader as r
on b.reader_id=r.id;
