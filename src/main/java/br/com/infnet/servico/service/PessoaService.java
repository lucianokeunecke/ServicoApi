package br.com.infnet.servico.service;

import br.com.infnet.servico.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    void incluir(Pessoa pessoa);

    void alterar(Long id, Pessoa pessoa);

    void excluir(Long id);

    Optional<Pessoa> buscarPeloId(Long id);

    List<Pessoa> buscarTodos();
}
