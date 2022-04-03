package br.com.infinet.pessoa.service;

import br.com.infinet.pessoa.model.Cep;
import org.springframework.stereotype.Service;

@Service
public interface CepService {

    Cep retornarDados(String numeroCep);
}
