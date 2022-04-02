package br.com.infinet.pessoa.service;

import br.com.infinet.pessoa.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    void insert(Pessoa pessoa);

    void delete(Long id);

    Optional<Pessoa> getById(Long id);

    List<Pessoa> getAll();

    List<Pessoa> top3();
}
