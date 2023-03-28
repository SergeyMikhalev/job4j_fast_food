package ru.job4j.model;

import lombok.Getter;

/**
 * Статус заказа
 */
@Getter
public enum OrderStatus {
    REGISTRATION("Оформляем"),
    COOKING("Готовим"),
    DELIVERY("Доставляем"),
    DONE("Доставлен");

    /**
     * Русскоязычное описание статуса заказа
     */
    private final String label;

    OrderStatus(String label) {
        this.label = label;
    }
}
