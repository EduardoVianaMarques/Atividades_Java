package com.GerenciadorPedidos.GerenciadorPedidos.controller;

import com.GerenciadorPedidos.GerenciadorPedidos.model.PedidoModel;
import com.GerenciadorPedidos.GerenciadorPedidos.services.PedidosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Pedidos")
public class PedidoController {
    @Autowired
    private PedidosServices pedidosServices;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> request = pedidosServices.findAll();
        return ResponseEntity.ok().body(request);
    }
    @GetMapping("/{id}")
    public Optional<PedidoModel> findById(@PathVariable Long id) {
        return pedidosServices.findById(id);
    }
    @PostMapping
    public ResponseEntity<PedidoModel> cadastroProduto(@RequestBody PedidoModel pedidoModel) {
        PedidoModel request = pedidosServices.cadastroPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id) {
        pedidosServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizar(@PathVariable Long id, @RequestBody PedidoModel pedidoModel){
        PedidoModel pedido = pedidosServices.atualizar(id, pedidoModel);
        return  ResponseEntity.ok().body(pedido);
    }
}
