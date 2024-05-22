package br.com.soften.softenclientes.repository;

import br.com.soften.softenclientes.model.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, UUID> {
    List<Cliente> findByNomeContaining(String nome);
}
