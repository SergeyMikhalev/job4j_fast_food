
-- Единицы измерения
insert into measure_units (name) values ('грамм');      --1
insert into measure_units (name) values ('милилитр');   --2

-- Продукты
insert into products (name, unit_id) values ('Картофель',1);            --1
insert into products (name, unit_id) values ('Соль повареная',1);       --2
insert into products (name, unit_id) values ('Масло подсолнечное',2);   --3
insert into products (name, unit_id) values ('Масло оливковое',2);      --4
insert into products (name, unit_id) values ('Огруцы',1);               --5
insert into products (name, unit_id) values ('Помидоры',1);             --6

--Порции прокутов
insert into dish_elements (product_id, amount) values (1, 300.0);   --1
insert into dish_elements (product_id, amount) values (2, 10.0);    --2
insert into dish_elements (product_id, amount) values (3, 50.0);    --3

insert into dish_elements (product_id, amount) values (5 ,200.0);   --4
insert into dish_elements (product_id, amount) values (6 ,200.0);   --5
insert into dish_elements (product_id, amount) values (4, 70.0);    --6

--Блюда
insert into dishes (name, description, price) values ('Картошка жареная', 'Картошка жареная на подсолнечном масле', 100);   --1

insert  into products_in_dishes (dish_id, dish_element_id) values (1,1);
insert  into products_in_dishes (dish_id, dish_element_id) values (1,2);
insert  into products_in_dishes (dish_id, dish_element_id) values (1,3);

insert into dishes (name, description, price) values ('Салат летний', 'Салат из огурцов и помидоров', 150);   --2

insert  into products_in_dishes (dish_id, dish_element_id) values (2,2);
insert  into products_in_dishes (dish_id, dish_element_id) values (2,4);
insert  into products_in_dishes (dish_id, dish_element_id) values (2,5);
insert  into products_in_dishes (dish_id, dish_element_id) values (2,6);
