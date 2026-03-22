package com.Gerenciador_Categorias.Gerenciador_Categorias.controller;

import com.Gerenciador_Categorias.Gerenciador_Categorias.model.CategoriaModel;
import com.Gerenciador_Categorias.Gerenciador_Categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll() {
        List<CategoriaModel> lista = categoriaService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public Optional<CategoriaModel> findById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> create(@RequestBody CategoriaModel categoriaModel) {
        CategoriaModel request = categoriaService.create(categoriaModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> atualizar(@PathVariable Long id,@PathVariable CategoriaModel categoriaModel){
        CategoriaModel categoria = categoriaService.update(id, categoriaModel);
        return ResponseEntity.ok().body(categoria);

    }
}