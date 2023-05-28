package ru.job4j.service;

import ru.job4j.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * Сервис работы со списком блюд, которые есть в нашем заведении.
 * Представляет собой CRUD interface.
 */
public interface DishService {
    void create(Dish dish);

    Optional<Dish> find(int id);

    List<Dish> findAll();

    void update(Dish dish);

    void delete(Dish dish);
}
