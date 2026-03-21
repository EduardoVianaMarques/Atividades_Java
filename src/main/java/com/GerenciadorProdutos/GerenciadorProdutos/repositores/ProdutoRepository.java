package com.GerenciadorProdutos.GerenciadorProdutos.repositores;

import com.GerenciadorProdutos.GerenciadorProdutos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
