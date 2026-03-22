package com.atividade.atividade6.services;

import com.atividade.atividade6.controllers.ClienteController;
import com.atividade.atividade6.models.ClienteModel;
import com.atividade.atividade6.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteService {

    private static final Logger log = Logger.getLogger(ClienteService.class.getName());
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel criarCliente(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> listarClientesPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel clienteModel) {
        ClienteModel newCliente = clienteRepository.findById(id).get();
        newCliente.setNome(clienteModel.getNome());
        newCliente.setEmail(clienteModel.getEmail());
        newCliente.setTelefone(clienteModel.getTelefone());
        return clienteRepository.save(newCliente);
    }
}
