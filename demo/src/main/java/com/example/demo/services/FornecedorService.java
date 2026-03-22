package com.example.demo.services;

import com.example.demo.models.FornecedorModel;
import com.example.demo.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FornecedorService {

    private static final Logger log = Logger.getLogger(FornecedorService.class.getName());

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }

    public List<FornecedorModel> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Optional<FornecedorModel> buscarId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public FornecedorModel atualizarFornecedor(Long id, FornecedorModel fornecedorModel) {
        FornecedorModel newFornecedor = fornecedorRepository.findById(id).get();
        newFornecedor.setNomeFantasia(fornecedorModel.getNomeFantasia());
        return fornecedorRepository.save(newFornecedor);
    }
}
