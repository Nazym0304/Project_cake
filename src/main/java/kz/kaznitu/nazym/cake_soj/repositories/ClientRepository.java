package kz.kaznitu.nazym.cake_soj.repositories;

import kz.kaznitu.nazym.cake_soj.models.Client;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Override
    Optional<Client> findById(Integer id);
}
