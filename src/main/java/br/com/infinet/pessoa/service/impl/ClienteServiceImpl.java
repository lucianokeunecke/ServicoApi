package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Cliente;
import br.com.infinet.pessoa.repository.ClienteRepository;
import br.com.infinet.pessoa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void incluir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> buscarPeloId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

}
