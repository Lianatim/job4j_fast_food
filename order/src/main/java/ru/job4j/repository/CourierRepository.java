package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Courier;

import java.util.Optional;

public interface CourierRepository extends CrudRepository<Courier, Integer> {

    Optional<Courier> findByStatus(String status);
}
