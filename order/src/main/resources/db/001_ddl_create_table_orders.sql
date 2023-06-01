create table orders (
id serial primary key,
customer_id int not null,
order_status int not null,
delivery_address varchar(200) not null
);

comment on table orders is 'таблица заказов клиентов';
comment on column orders.id is 'уникальный идентификатор заказа';
comment on column orders.customer_id is 'уникальный идентификатор заказчика';
comment on column orders.order_status is 'статус заказа - Оформляем, Готовим итд';
comment on column orders.delivery_address is 'Адрес доставки';
