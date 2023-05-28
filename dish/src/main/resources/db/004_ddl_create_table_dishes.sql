create table dishes (
    id serial primary key,
    name varchar(200) not null,
    description varchar(2000) not null,
    price int not null
);

comment on table dishes is 'Таблица блюд, предлагаемых заведением';
comment on column dishes.id is 'Уникальный идентификатор блюда';
comment on column dishes.name is 'Название блюда';
comment on column dishes.description is 'Описание блюда';
comment on column dishes.price is 'Цена блюда';