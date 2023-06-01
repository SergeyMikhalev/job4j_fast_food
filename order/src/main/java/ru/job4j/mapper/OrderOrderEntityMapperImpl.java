package ru.job4j.mapper;

import org.springframework.stereotype.Component;
import ru.job4j.model.Dish;
import ru.job4j.model.Order;
import ru.job4j.model.OrderEntity;
import ru.job4j.model.OrderStatus;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderOrderEntityMapperImpl implements OrderOrderEntityMapper {
    @Override
    public OrderEntity orderToOrderEntity(Order order) {
        if (null == order) {
            return null;
        }

        List<Integer> dishIds = order
                .getDishes()
                .stream()
                .map(dish -> dish.getId()).collect(Collectors.toList());

        OrderEntity orderEntity = OrderEntity.of()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .status(order.getStatus())
                .deliveryAddress(order.getDeliveryAddress())
                .dishIds(dishIds)
                .build();

        return orderEntity;
    }

    @Override
    public Order orderEntityToOrder(OrderEntity orderEntity) {
        if (null == orderEntity) {
            return null;
        }
        List<Dish> dishes = orderEntity
                .getDishIds()
                .stream()
                .map(id -> Dish.of().id(id).build()).collect(Collectors.toList());
        Order order = Order
                .of()
                .id(orderEntity.getId())
                .customerId(orderEntity.getCustomerId())
                .deliveryAddress(orderEntity.getDeliveryAddress())
                .dishes(dishes)
                .status(orderEntity.getStatus())
                .build();

        return order;
    }
}
