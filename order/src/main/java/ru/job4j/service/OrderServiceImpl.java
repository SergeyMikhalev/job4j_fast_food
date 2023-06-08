package ru.job4j.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.mapper.OrderOrderEntityMapper;
import ru.job4j.model.*;
import ru.job4j.repository.OrderEntityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    public static final String DISH_SERVICE_URL = "http://localhost:8091/dishes/";
    private final OrderOrderEntityMapper mapper;
    private final OrderEntityRepository orderEntityRepository;

    private final RestTemplate client;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Order createOrder(Order order) {
        log.info("Запрос на создание заказа "+order);
        OrderEntity orderEntity = mapper.orderToOrderEntity(order);
        OrderEntity savedOrderEntity = orderEntityRepository.save(orderEntity);
        kafkaTemplate.send("job4j_orders", savedOrderEntity);
        kafkaTemplate.send("job4j_notifications",
                Notification.of()
                        .recipientId(order.getCustomerId())
                        .message("Создан заказ " + savedOrderEntity)
                        .build()
        );
        log.info("Заказ "+savedOrderEntity + " сохранен в БД.");
        order.setId(savedOrderEntity.getId());
        return order;
    }

    @Override
    public BonusCard buyBonusCard(BonusCard card) {
        throw new UnsupportedOperationException("Функционал покупки бонусной карты пока не реализован");
    }

    @Override
    public OrderStatus getOrderStatus(int orderId) {
        throw new UnsupportedOperationException("Функционал получения статуса заказа пока не реализован");
    }

    @Override
    public Optional<Order> getOrder(int orderId) {
        Optional<OrderEntity> orderEntity =  orderEntityRepository.findById(orderId);
        List<Dish> detailedDishes = new ArrayList<>();
        int totalCost = 0;
        Order order = null;
        if (orderEntity.isPresent()) {
            order = mapper.orderEntityToOrder(orderEntity.get());
            for (Dish dish : order.getDishes()) {
                Dish dishFromApi = client.getForEntity(DISH_SERVICE_URL + dish.getId(), Dish.class).getBody();
                if (null == dishFromApi) {
                    throw new IllegalStateException();
                }
                detailedDishes.add(dishFromApi);
                /*
                Проверка переполнения пока не реализована
                 */
                totalCost += dishFromApi.getPrice();
            }
            order.setCost(totalCost);
            order.setDishes(detailedDishes);

        }

        return Optional.ofNullable(order);
    }
}
