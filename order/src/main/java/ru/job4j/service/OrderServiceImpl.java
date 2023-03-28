package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.BonusCard;
import ru.job4j.model.Order;
import ru.job4j.model.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public BonusCard buyBonusCard(BonusCard card) {
        return null;
    }

    @Override
    public OrderStatus getOrderStatus(int orderId) {
        return null;
    }
}
