package com.GerenciadorPedidos.GerenciadorPedidos.repositores;

import com.GerenciadorPedidos.GerenciadorPedidos.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
