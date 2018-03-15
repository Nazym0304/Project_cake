package kz.kaznitu.nazym.cake_soj.repositories;

import kz.kaznitu.nazym.cake_soj.models.Sales;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SalesRepository extends CrudRepository<Sales, Integer> {
    @Override
    Optional<Sales> findById(Integer id);
}
