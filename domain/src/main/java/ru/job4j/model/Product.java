package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Класс описывает продукт питания, входящий в состав блюда.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "products")
public class Product {
    /**
     * Уникальный идентификатор продукта
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Название продукта
     */
    private String name;
    /**
     * Единица измерения (кг. , шт. и.т.д.)
     */
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private MeasureUnit unit;
}
