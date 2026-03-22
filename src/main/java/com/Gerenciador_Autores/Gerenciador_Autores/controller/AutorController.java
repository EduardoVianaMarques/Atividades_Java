package com.Gerenciador_Autores.Gerenciador_Autores.controller;

import com.Gerenciador_Autores.Gerenciador_Autores.model.AutorModel;
import com.Gerenciador_Autores.Gerenciador_Autores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorModel>> findAll() {
        List<AutorModel> lista = autorService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public Optional<AutorModel> findById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<AutorModel> criarAutor(@RequestBody AutorModel autorModel) {
        AutorModel request = autorService.criarAutor(autorModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        autorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorModel> update(@PathVariable Long id, @RequestBody AutorModel autorModel){
        AutorModel autor = autorService.atualizar(id, autorModel);
        return ResponseEntity.ok().body(autor);


    }
}