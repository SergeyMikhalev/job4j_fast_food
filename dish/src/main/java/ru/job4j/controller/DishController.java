package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.model.Dish;
import ru.job4j.service.DishService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping()
    public ResponseEntity<List<Dish>> getAll() {
        return new ResponseEntity<>(dishService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getById(@PathVariable int id) {
        Optional<Dish> dish = dishService.find(id);
        if (dish.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dish.get(), HttpStatus.OK);
    }
}
