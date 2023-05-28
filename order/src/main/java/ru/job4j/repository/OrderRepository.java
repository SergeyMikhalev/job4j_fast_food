package ru.job4j.repository;

import ru.job4j.model.Order;

import java.util.Optional;

public interface OrderRepository {

    /**
     * Получить детали заказа по номеру заказа
     * @param orderId номер заказа
     * @return детали заказа, если заказ с таким id присутствует в БД
     */
    Optional<Order> getById(int orderId);
}
