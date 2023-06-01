package ru.job4j.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "orders")
public class OrderEntity {
    /**
     * Уникальный идентификатор заказа
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Уникальный идентификато клиента-заказчика
     */
    @Column(name = "customer_id")
    private int customerId;

    /**
     * Статус заказа
     */
    @Column(name = "order_status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    /**
     * Сптсок блюд в заказе
     */
    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "dish_ids_in_orders", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "dish_id")
    private List<Integer> dishIds = new ArrayList<>();

    /**
     * Адрес доставки
     */
    @Column(name = "delivery_address")
    private String deliveryAddress;


}
