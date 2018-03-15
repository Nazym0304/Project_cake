package kz.kaznitu.nazym.cake_soj.repositories;

import kz.kaznitu.nazym.cake_soj.models.Cake;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CakeRepository extends CrudRepository<Cake, Integer> {
    @Override
    Optional<Cake> findById(Integer id);
}
