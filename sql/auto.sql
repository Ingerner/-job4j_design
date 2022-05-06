create table машина(
    id serial primary key,
    name text
)

create table кузов(
    id serial primary key,
    кузов text,
    id_машина int references машина(id)
);

create table двигатель(
    id serial primary key,
    двигатель text,
    id_машина int references машина(id)
);

create table коробка_передач(
    id serial primary key,
    коробка_передач text,
    id_машина int references машина(id)
);

insert into машина(name) values('бмв'), ('ауди'), ('форд'), ('тойота'), ('шевроле');

insert into кузов(кузов, id_машина) values('седан', 1), ('купе', 3), ('универсал', 5), ('хетчбэк',2), ('минивен', 3);

insert into двигатель(двигатель, id_машина) values('бензиновый', 1), ('газовый', 3), ('дизельный', 2), ('электрический',5);

insert into коробка_передач(коробка_передач, id_машина) values('механическая', 5), ('роботизированная', 1), ('гидромеханическая', 4), ('вариатор',3);
