package br.com.infnet.servico.service;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.model.Fornecedor;

import java.util.List;
import java.util.Optional;

public interface FornecedorService {
    void incluir(Fornecedor fornecedor);

    void alterar(Long id, Fornecedor fornecedor);

    void excluir(Long id);

    Optional<Fornecedor> buscarPeloId(Long id);

    List<Fornecedor> buscarTodos();
}
