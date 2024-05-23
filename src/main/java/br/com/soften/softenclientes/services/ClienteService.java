package br.com.soften.softenclientes.services;

import br.com.soften.softenclientes.model.entities.Cliente;
import br.com.soften.softenclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    public Cliente findById(UUID id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.orElse(null);
    }

    public Cliente createCliente(Cliente cliente) {
        cliente.setId(UUID.randomUUID());  // Set a new UUID for the new cliente
        return clienteRepository.save(cliente);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(UUID id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente not found with id " + id);
        }
    }

    public void deleteCliente(UUID id) {
        clienteRepository.deleteById(id);
    }
}
