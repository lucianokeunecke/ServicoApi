package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Cep;
import br.com.infinet.pessoa.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CepServiceImpl implements CepService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Cep retornarDados(String numeroCep) {

        String url = String.format("http://localhost:8081/cep/%s",numeroCep);

        return restTemplate.getForObject(url, Cep.class);
    }
}
