package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Order;
import ru.job4j.model.OrderEntity;

import java.util.Optional;

public interface OrderEntityRepository extends CrudRepository<OrderEntity,Integer>
{
}
