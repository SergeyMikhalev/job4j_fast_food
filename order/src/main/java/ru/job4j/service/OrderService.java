package ru.job4j.service;

import ru.job4j.model.BonusCard;
import ru.job4j.model.Order;
import ru.job4j.model.OrderStatus;

import java.util.Optional;

/**
 * Сервис оформления заказов еды
 */
public interface OrderService {
    /**
     * Создание заказа
     * @param order - заказ, который будет создан
     * @return - созданный заказ для отображения клиенту
     */
    Order createOrder(Order order);

    /**
     * Покупка бонусной карты
     * @param card - бонусная карта, которую покупаем
     * @return - купленная карта, для отображения клиенту
     */
    BonusCard buyBonusCard(BonusCard card);

    /**
     * Узнать статус заказа
     * @param orderId - идентификатор заказа
     * @return enum OrderStatus статус заказа
     */
    OrderStatus getOrderStatus(int orderId);

    Optional<Order> getOrder(int orderId);
}
