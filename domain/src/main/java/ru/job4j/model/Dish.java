package ru.job4j.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Блюдо из меню заведения общественного питания.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dish {
    /**
     * Уникальный идентификатор блюда
     */
    @EqualsAndHashCode.Include
    private int id;
    /**
     * Название блюда
     */
    private String name;
    /**
     * Описание блюда
     */
    private String description;
    /**
     * Набор продуктов (с указанием необходимого количества),
     * входящих в состав блюда
     */
    private Set<DishElement> products = new HashSet<>();
    /**
     * Цена блюда за одну порцию (развесовка порций стандартная!)
     */
    private int price;
}
