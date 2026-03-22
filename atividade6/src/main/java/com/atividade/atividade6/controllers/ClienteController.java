package com.atividade.atividade6.controllers;

import com.atividade.atividade6.models.ClienteModel;
import com.atividade.atividade6.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarClientes(){
        List<ClienteModel> lista = clienteService.listarClientes();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> listarClientesPorId(@PathVariable Long id) {
        return clienteService.listarClientesPorId(id);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> adicionarCliente(@RequestBody ClienteModel clienteModel) {
        ClienteModel novo = clienteService.criarCliente(clienteModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteModel) {
        ClienteModel atualizado = clienteService.atualizarCliente(id, clienteModel);
        return ResponseEntity.ok().body(atualizado);
    }
}