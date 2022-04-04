package br.com.infinet.pessoa.service;

import br.com.infinet.pessoa.model.Cep;

public interface CepService {

    Cep pesquisar(String numeroCep);
}
