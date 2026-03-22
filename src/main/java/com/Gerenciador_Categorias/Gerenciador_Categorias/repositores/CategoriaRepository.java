package com.Gerenciador_Categorias.Gerenciador_Categorias.repositores;

import com.Gerenciador_Categorias.Gerenciador_Categorias.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
