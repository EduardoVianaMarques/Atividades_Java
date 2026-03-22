package com.example.demo.services;

import com.example.demo.models.ProjetoModel;
import com.example.demo.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProjetoService {

    public static final Logger log = Logger.getLogger(ProjetoService.class.getName());

    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoModel criarProjeto(ProjetoModel projetoModel) {
        return projetoRepository.save(projetoModel);
    }

    public List<ProjetoModel> listarProjeto() {
        return projetoRepository.findAll();
    }

    public Optional<ProjetoModel> buscarId(Long id) {
        return projetoRepository.findById(id);
    }

    public void deletarProjeto(Long id) {
        projetoRepository.deleteById(id);
    }

    public ProjetoModel atualizarProjeto(Long id, ProjetoModel projetoModel) {
        ProjetoModel newProjeto = projetoRepository.findById(id).get();
        newProjeto.setNome(projetoModel.getNome());
        return projetoRepository.save(newProjeto);
    }
}
