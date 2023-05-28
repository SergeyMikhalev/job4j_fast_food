package ru.job4j.model;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Блюдо из меню заведения общественного питания.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "dishes")
public class Dish {
    /**
     * Уникальный идентификатор блюда
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_in_dishes",
            joinColumns = {@JoinColumn(name = "dish_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_element_id")}
    )
    private Set<DishElement> products = new HashSet<>();
    /**
     * Цена блюда за одну порцию (развесовка порций стандартная!)
     */
    private int price;
}
