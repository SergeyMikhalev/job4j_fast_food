create table dish_ids_in_orders (
id serial primary key,
order_id int not null references orders(id),
dish_id int not null
);

comment on table dish_ids_in_orders is 'таблица идентификаторов блюд в заказе';
comment on column dish_ids_in_orders.id is 'уникальный идентификатор записи';
comment on column dish_ids_in_orders.order_id is 'идентификатор заказа';
comment on column dish_ids_in_orders.dish_id is 'идентификатор блюда';