package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.BonusCard;
import ru.job4j.model.Order;
import ru.job4j.model.OrderStatus;
import ru.job4j.service.OrderService;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
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

}
