package br.com.infinet.pessoa.service;

import br.com.infinet.pessoa.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    void insert(Cliente cliente);

    void delete(Long id);

    Optional<Cliente> getById(Long id);

    List<Cliente> getAll();

    List<Cliente> top3();
}
