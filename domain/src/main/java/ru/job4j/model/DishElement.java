package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Элемент блюда - количество продукта в блюде.
 * Например, 100г картофеля в порции салата "Оливье"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "dish_elements")
public class DishElement {
    /**
     * Уникальный идентификатор
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Продукт
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    /**
     * Количество продукта
     */
    private double amount;
}
