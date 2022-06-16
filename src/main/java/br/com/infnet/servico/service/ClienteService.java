package br.com.infnet.servico.service;

import br.com.infnet.servico.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    void incluir(Cliente cliente);

    void alterar(Long id, Cliente cliente);

    void excluir(Long id);

    Optional<Cliente> buscarPeloId(Long id);

    List<Cliente> buscarTodos();
}
