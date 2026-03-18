package com.atividade.atividade6.controllers;

import com.atividade.atividade6.models.ClienteModel;
import com.atividade.atividade6.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ClienteModel adicionarCliente(@RequestBody ClienteModel clienteModel) {
        return clienteService.criarCliente(clienteModel);
    }

    @GetMapping
    public List<ClienteModel> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping
    public List<ClienteModel> listarClientesPorId(Long id) {
        return clienteService.listarClientesPorId(id);
    }

    @DeleteMapping
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

    @PutMapping
    public ClienteModel atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteModel) {
        return clienteService.atualizarCliente(id, clienteModel);
    }
}
