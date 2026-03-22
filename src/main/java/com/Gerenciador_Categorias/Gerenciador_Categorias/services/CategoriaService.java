package com.Gerenciador_Categorias.Gerenciador_Categorias.services;

import com.Gerenciador_Categorias.Gerenciador_Categorias.model.CategoriaModel;
import com.Gerenciador_Categorias.Gerenciador_Categorias.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaModel> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaModel> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public CategoriaModel create(CategoriaModel categoriaModel) {
        return categoriaRepository.save(categoriaModel);
    }

    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
    public CategoriaModel update (Long id ,CategoriaModel categoriaModel){
        CategoriaModel newCategoria = categoriaRepository.findById(id).get();
        newCategoria.setNome(categoriaModel.getNome());
        newCategoria.setDescricao(categoriaModel.getDescricao());
        return categoriaRepository.save(newCategoria);
    }
}