package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Бонусная карта клиента. Определяет процент скидки на заказы.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BonusCard {
    /**
     * Уникальный идентификатор бонусной карты
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Размер скидки в процентах.
     */
    private int discount;
}
