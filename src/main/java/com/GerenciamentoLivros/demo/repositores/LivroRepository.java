package com.GerenciamentoLivros.demo.repositores;

import com.GerenciamentoLivros.demo.model.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository  extends JpaRepository<LivrosModel, Long> {
}
