package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Cep;
import br.com.infinet.pessoa.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class CepServiceImpl implements CepService {

    private static final Logger LOGGER = Logger.getLogger(CepServiceImpl.class.getName());

    @Autowired
    RestTemplate restTemplate;

    /* Este método irá consultar a API Cep, passando como parâmetro o número do Cep
     *  e terá como retorno as informações do endereço do CEP. */
    @Override
    public Cep pesquisar(String numeroCep) {

        String url = String.format("http://localhost:8081/cep/%s",numeroCep);

        LOGGER.info(String.format("Comunicando-se com a API Cep: %s ", url));

        return restTemplate.getForObject(url, Cep.class);
    }
}
