package com.GerenciadorPedidos.GerenciadorPedidos.services;

import com.GerenciadorPedidos.GerenciadorPedidos.model.PedidoModel;
import com.GerenciadorPedidos.GerenciadorPedidos.repositores.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosServices {
    @Autowired
    private PedidoRepository pedidoRepository;


    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }
    public Optional<PedidoModel> findById(Long id){
        return  pedidoRepository.findById(id);

    }

    public PedidoModel cadastroPedido(PedidoModel pedidoModel){
        return pedidoRepository.save(pedidoModel);
    }

    public void deleteById(Long id){
        pedidoRepository.deleteById(id);
    }

    public PedidoModel atualizar(Long id , PedidoModel pedidoModel){
        PedidoModel newPedido = pedidoRepository.findById(id).get();
        newPedido.setData(pedidoModel.getData());
        newPedido.setValorTotal(pedidoModel.getValorTotal());
        newPedido.setStatus(pedidoModel.getStatus());
        return pedidoRepository.save(newPedido);

    }



}
