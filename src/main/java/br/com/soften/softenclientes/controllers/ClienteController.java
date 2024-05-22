package br.com.soften.softenclientes.controllers;

import br.com.soften.softenclientes.model.entities.Cliente;
import br.com.soften.softenclientes.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public  ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String getAllClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "create";
    }

    @PostMapping("/create")
    public String createCliente(@ModelAttribute Cliente cliente) {
        clienteService.createCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente == null) {
            return "redirect:/clientes";
        }
        model.addAttribute("cliente", cliente);
        return "update";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable UUID id, @RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.update(id, cliente));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable UUID id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes";
    }
}