package ru.job4j.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.BonusCard;
import ru.job4j.model.Order;
import ru.job4j.model.OrderStatus;
import ru.job4j.service.OrderService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PostMapping("/bonus")
    public ResponseEntity<BonusCard> buyBonus(@RequestBody BonusCard card) {
        return new ResponseEntity<>(orderService.buyBonusCard(card), HttpStatus.CREATED);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<OrderStatus> getOrderStatus(@PathVariable int id) {
        return new ResponseEntity<>(orderService.getOrderStatus(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable int id) {
        Optional<Order> order = orderService.getOrder(id);
        if (order.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }

}
