package com.Gerenciador_Autores.Gerenciador_Autores.services;

import com.Gerenciador_Autores.Gerenciador_Autores.model.AutorModel;
import com.Gerenciador_Autores.Gerenciador_Autores.repositore.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> findAll() {
        return autorRepository.findAll();
    }

    public Optional<AutorModel> findById(Long id) {
        return autorRepository.findById(id);
    }

    public AutorModel criarAutor(AutorModel autorModel) {
        return autorRepository.save(autorModel);
    }

    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }
    public AutorModel atualizar(Long id, AutorModel autorModel){
        AutorModel newAutor = autorRepository.findById(id).get();
        newAutor.setNome(autorModel.getNome());
        newAutor.setDataNascimento(autorModel.getDataNascimento());
        newAutor.setNacionalidade(autorModel.getNacionalidade());
        return  autorRepository.save(newAutor);
    }
}
