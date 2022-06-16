package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.repository.ClienteRepository;
import br.com.infnet.servico.service.ClienteService;
import org.springframework.beans.BeanUtils;
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
    public void alterar(Long id, Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.findById(id).orElse(null);

        BeanUtils.copyProperties(cliente, clienteSalvo, "id");

        clienteRepository.save(clienteSalvo);
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
