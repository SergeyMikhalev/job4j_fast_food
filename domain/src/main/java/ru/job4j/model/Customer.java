package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Клиент заведения "Быстро и в точку"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
    /**
     * Уникальный идентификатор клиента
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Имя клиента
     */
    private String firstName;

    /**
     * Фамилия клиента
     */
    private String lastName;

    /**
     * Адрес, на который устанавливается доставка "по умолчанию".
     * Например дом или работа.
     */
    private String homeAddress;

    /**
     * День рождения клиента
     */
    private LocalDate birthday;

    /**
     * Бонусная карта клиента
     */
    private BonusCard bonusCard;
}
