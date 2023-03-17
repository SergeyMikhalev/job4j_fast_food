package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Класс описывает продукт питания, входящий в состав блюда.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    /**
     * Уникальный идентификатор продукта
     */
    @EqualsAndHashCode.Include
    private int id;
    /**
     * Название продукта
     */
    private String name;
    /**
     * Единица измерения (кг. , шт. и.т.д.)
     */
    private String unit;
}
