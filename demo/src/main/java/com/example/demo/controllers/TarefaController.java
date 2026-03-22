package com.example.demo.controllers;

import com.example.demo.models.TarefaModel;
import com.example.demo.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @PostMapping
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefaModel){
        return tarefaService.criarTarefa(tarefaModel);
    }

    @GetMapping
    public List<TarefaModel> listarTarefa(){
        return tarefaService.listarTarefa();
    }

    @GetMapping("/{id}")
    public Optional<TarefaModel> buscarId(@PathVariable Long id){
        return tarefaService.buscarId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }

    @PutMapping
    public TarefaModel atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel){
        return tarefaService.atualizarTarefa(id, tarefaModel);
    }
}
