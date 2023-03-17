package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Элемент блюда - количество продукта в блюде.
 * Например, 100г картофеля в порции салата "Оливье"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DishElement {
    /**
     * Уникальный идентификатор
     */
    private int id;
    /**
     * Продукт
     */
    private Product product;
    /**
     * Количество продукта
     */
    private double amount;
}
