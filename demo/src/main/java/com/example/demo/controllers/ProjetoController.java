package com.example.demo.controllers;

import com.example.demo.models.ProjetoModel;
import com.example.demo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/projetos")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @PostMapping
    public ProjetoModel criarProjeto(@RequestBody ProjetoModel projetoModel) {
        return projetoService.criarProjeto(projetoModel);
    }

    @GetMapping
    public List<ProjetoModel> listarProjeto() {
        return projetoService.listarProjeto();
    }

    @GetMapping("/{îd}")
    public Optional<ProjetoModel> buscarId(Long id){
        return projetoService.buscarId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
    }

    @PutMapping("/{id}")
    public ProjetoModel atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoModel projetoModel){
        return projetoService.atualizarProjeto(id, projetoModel);
    }
}
