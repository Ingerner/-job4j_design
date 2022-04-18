
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

create table reles_role(
    id serial primary key,
    rules_id int references rules(id),
    role_id int references role(id)
)

create table item(
    id serial primary key,
    item text,
    users_id int references users(id),
    cotegory_id int references cotegory,
    state_id int references state(id)
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

create table state (
    id serial primary key,
    state  text
);

create table category(
    id serial primary key,
    category   text
);


