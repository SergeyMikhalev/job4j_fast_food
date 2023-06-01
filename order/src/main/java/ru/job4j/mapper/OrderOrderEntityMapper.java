package ru.job4j.mapper;


import ru.job4j.model.Order;
import ru.job4j.model.OrderEntity;

public interface OrderOrderEntityMapper {
    OrderEntity orderToOrderEntity(Order order);

    Order orderEntityToOrder(OrderEntity orderEntity);
}
