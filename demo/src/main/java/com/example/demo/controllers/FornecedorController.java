package com.example.demo.controllers;

import com.example.demo.models.FornecedorModel;
import com.example.demo.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listarFornecedores() {
        List<FornecedorModel> lista = fornecedorService.listarFornecedores();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public Optional<FornecedorModel> buscarId(@PathVariable Long id) {
        return fornecedorService.buscarId(id);
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel) {
        FornecedorModel novo = fornecedorService.criarFornecedor(fornecedorModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorModel> atualizarFornecedor(
            @PathVariable Long id,
            @RequestBody FornecedorModel fornecedorModel) {

        FornecedorModel atualizado = fornecedorService.atualizarFornecedor(id, fornecedorModel);
        return ResponseEntity.ok().body(atualizado);
    }
}