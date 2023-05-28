create table products (
    id serial primary key,
    name varchar(200) not null,
    unit_id int references measure_units(id)
);

comment on table products is 'Таблица продуктов из которых состоят блюда';
comment on column products.id is 'Уникальный идентификатор продукта';
comment on column products.name is 'Название продукта';
comment on column products.unit_id is 'Единица измерения продукта';