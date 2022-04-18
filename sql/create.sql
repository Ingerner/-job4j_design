
create table role(
    id serial primary key,
    name text,
);

create table users(
    id serial primary key,
    name text,
    role_id int references role(id)
);

create table rules(
    id serial primary key,
    role_rights text
);

create table role_rules(
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id)
);

create table item(
    id serial primary key,
    item text,
    users_id int references users(id)
);

create table comments(
    id serial primary key,
    comments_on_applications text,
    item_id int references item(id)
);

create table attachs(
    id serial primary key,
    attached_files text,
    item_id int references item(id)
);

create table category(
    id serial primary key,
    category   text
);

alter table item add column category_id int references category(id);

create table state (
    id serial primary key,
    state  text
);

alter table item add column state_id text;




