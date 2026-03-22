package com.Gerenciador_Autores.Gerenciador_Autores.repositore;

import com.Gerenciador_Autores.Gerenciador_Autores.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel,Long> {
}
