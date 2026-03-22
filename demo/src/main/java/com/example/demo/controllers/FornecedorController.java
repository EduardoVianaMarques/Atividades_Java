package com.example.demo.controllers;

import com.example.demo.models.FornecedorModel;
import com.example.demo.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    public FornecedorModel criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
        return fornecedorService.criarFornecedor(fornecedorModel);
    }

    @GetMapping
    public List<FornecedorModel> listarFornecedores(){
        return fornecedorService.listarFornecedores();
    }

    @GetMapping("/{id}")
    public Optional<FornecedorModel> buscarId(@PathVariable Long id){
        return fornecedorService.buscarId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id){
        fornecedorService.deletarFornecedor(id);
    }

    @PutMapping("/{id}")
    public FornecedorModel atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel){
        return fornecedorService.atualizarFornecedor(id, fornecedorModel);
    }
}
