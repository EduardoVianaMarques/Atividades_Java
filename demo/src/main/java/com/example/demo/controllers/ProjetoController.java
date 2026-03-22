package com.example.demo.controllers;

import com.example.demo.models.ProjetoModel;
import com.example.demo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> listarProjeto() {
        List<ProjetoModel> lista = projetoService.listarProjeto();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public Optional<ProjetoModel> buscarId(@PathVariable Long id){
        return projetoService.buscarId(id);
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel) {
        ProjetoModel novo = projetoService.criarProjeto(projetoModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoModel> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoModel projetoModel){
        ProjetoModel atualizado = projetoService.atualizarProjeto(id, projetoModel);
        return ResponseEntity.ok().body(atualizado);
    }
}