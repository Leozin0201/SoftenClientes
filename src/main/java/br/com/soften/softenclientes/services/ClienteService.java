package br.com.soften.softenclientes.services;

import br.com.soften.softenclientes.model.entities.Cliente;
import br.com.soften.softenclientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(UUID id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(UUID id, Cliente cliente) throws Exception {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new Exception("Cliente não encontrado");
        }
    }

    public void deleteCliente(UUID id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
    }
}
