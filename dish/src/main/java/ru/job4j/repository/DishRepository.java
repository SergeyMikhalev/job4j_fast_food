package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Dish;


import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    @Override
    Optional<Dish> findById(Integer integer);

    List<Dish> findAll();


}
