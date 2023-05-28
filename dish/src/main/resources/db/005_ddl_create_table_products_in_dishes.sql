create table products_in_dishes (
    id serial primary key,
    dish_id int not null references dishes(id),
    dish_element_id int not null references dish_elements(id)
);

comment on table products_in_dishes is 'Таблица для описания состава блюда';
comment on column products_in_dishes.id is 'Уникальный идентификатор записи';
comment on column products_in_dishes.dish_id is 'Идентификатор блюда';
comment on column products_in_dishes.dish_element_id is 'Идентификатор элемента блюда';