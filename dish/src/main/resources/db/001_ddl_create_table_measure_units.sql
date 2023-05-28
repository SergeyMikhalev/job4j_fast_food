create table measure_units (
id serial primary key,
name varchar(20) unique not null
);

comment on table measure_units is 'Таблица единиц измерений для колисчества продуктов';
comment on column measure_units.id is 'Уникальный идентификатор единицы измерения';
comment on column measure_units.name is 'Название единицы измерения';