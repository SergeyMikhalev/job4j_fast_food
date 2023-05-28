package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Dish;
import ru.job4j.model.Order;
import ru.job4j.model.OrderStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final Map<Integer, Order> orders = new HashMap<>();

    public OrderRepositoryImpl() {
        /*
        Создание тестового заказа
         */
        List<Dish> dishes = List.of(
                Dish.of()
                        .id(1)
                        .build(),
                Dish.of()
                        .id(2)
                        .build()
        );

        Order order1 = Order.of()
                .id(1)
                .dishes(dishes)
                .status(OrderStatus.DONE)
                .deliveryAddress("Московский проспект 87")
                .build();

        orders.put(1, order1);
    }

    @Override
    public Optional<Order> getById(int orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }
}
