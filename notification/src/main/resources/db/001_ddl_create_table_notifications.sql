create table notifications (
id serial primary key,
recipient_id int not null,
message varchar(2000) not null
);

comment on table notifications is 'Таблица сообщений для пользователей';
comment on column notifications.id is 'Уникальный идентификатор сообщения';
comment on column notifications.recipient_id is 'Уникальный идентификатор получателя';
comment on column notifications.message is 'Текст сообщения';