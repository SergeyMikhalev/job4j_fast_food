package ru.job4j.service;

import ru.job4j.model.Dish;

/**
 * Сервис работы со списком блюд, которые есть в нашем заведении.
 * Представляет собой CRUD interface.
 */
public interface DishService {
    void create(Dish dish);

    Dish find(int id);

    Dish findAll();

    void update(Dish dish);

    void delete(Dish dish);
}
