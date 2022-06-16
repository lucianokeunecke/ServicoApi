package br.com.infnet.servico.service;

import br.com.infnet.servico.model.Cep;

public interface CepService {

    Cep pesquisar(String numeroCep);
}
