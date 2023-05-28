package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Dish;
import ru.job4j.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository repository;

    @Override
    public void create(Dish dish) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Dish> find(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Dish dish) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Dish dish) {
        throw new UnsupportedOperationException();
    }
}
