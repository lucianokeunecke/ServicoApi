package br.com.infinet.pessoa.service;

import br.com.infinet.pessoa.model.Cidade;

public interface CidadeService {

    Cidade getByNome(String nome);
}
