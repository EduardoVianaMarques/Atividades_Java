package com.GerenciadorProdutos.GerenciadorProdutos.services;

import com.GerenciadorProdutos.GerenciadorProdutos.model.ProdutoModel;
import com.GerenciadorProdutos.GerenciadorProdutos.repositores.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> findById(Long id ){
        return produtoRepository.findById(id);
    }

    public ProdutoModel cadastroProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public void  deleteById(Long id){
        produtoRepository.deleteById(id);
    }

    public ProdutoModel atualizar(Long id ,ProdutoModel produtoModel){
        ProdutoModel newProduto = produtoRepository.findById(id).get();
        newProduto.setNome(produtoModel.getNome());
        newProduto.setPreco(produtoModel.getPreco());

        return produtoRepository.save(newProduto);
    }
}
