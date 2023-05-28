package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.model.BonusCard;
import ru.job4j.model.Dish;
import ru.job4j.model.Order;
import ru.job4j.model.OrderStatus;
import ru.job4j.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    public static final String DISH_SERVICE_URL = "http://localhost:80/dishes/";
    private final OrderRepository orderRepository;

    private final RestTemplate client;

    @Override
    public Order createOrder(Order order) {
        throw new UnsupportedOperationException("Функционал создания заказа пока не реализован");
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
        Optional<Order> order = orderRepository.getById(orderId);
        List<Dish> detailedDishes = new ArrayList<>();
        int totalCost = 0;
        if (order.isPresent()) {
            for (Dish dish : order.get().getDishes()) {
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
            order.get().setCost(totalCost);
            order.get().setDishes(detailedDishes);

        }

        return order;
    }
}
