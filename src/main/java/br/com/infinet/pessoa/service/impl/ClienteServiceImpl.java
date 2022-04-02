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
    public void insert(Cliente cliente) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> top3() {
        return null;
    }
}
