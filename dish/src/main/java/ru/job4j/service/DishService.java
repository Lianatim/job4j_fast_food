package ru.job4j.service;

import ru.job4j.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    void save(Dish dish);
    boolean delete(int id);
    Dish update(Dish dish);
    Optional<Dish> findById(int id);
    Optional<Dish> findByName(String name);
    List<Dish> findAll();
}
