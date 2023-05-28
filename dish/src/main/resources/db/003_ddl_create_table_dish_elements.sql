create table dish_elements (
    id serial primary key,
    product_id int not null references products(id),
    amount real not null
);

comment on table dish_elements is 'Таблица порций продуктов, добавляемых в блюдо';
comment on column dish_elements.id is 'Уникальный идентификатор порции продукта';
comment on column dish_elements.product_id is 'Идентификатор продукта в порции';
comment on column dish_elements.amount is 'Количество продукта в порции';