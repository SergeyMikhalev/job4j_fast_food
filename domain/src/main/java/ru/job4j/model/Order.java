package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Заказ еды.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {
    /**
     * Уникальный идентификатор заказа
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Уникальный идентификато клиента-заказчика
     */
    private int customerId;

    /**
     * Статус заказа
     */
    private OrderStatus status;

    /**
     * Сптсок блюд в заказе
     */
    private List<Dish> dishes = new ArrayList<>();

    /**
     * Адрес доставки
     */
    private String deliveryAddress;

    /**
     * Стоимост заказа
     */
    private int cost;
}
