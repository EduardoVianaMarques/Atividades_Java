package com.GerenciadorProdutos.GerenciadorProdutos.controller;

import com.GerenciadorProdutos.GerenciadorProdutos.model.ProdutoModel;
import com.GerenciadorProdutos.GerenciadorProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> request = produtoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> cadastroProduto(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.cadastroProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        ProdutoModel produto = produtoService.atualizar(id, produtoModel);
        return  ResponseEntity.ok().body(produto);
    }



}
