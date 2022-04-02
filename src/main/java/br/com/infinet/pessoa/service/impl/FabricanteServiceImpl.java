package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Fabricante;
import br.com.infinet.pessoa.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class FabricanteServiceImpl implements FabricanteService {
    private static final Logger LOGGER = Logger.getLogger(FabricanteServiceImpl.class.getName());
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Fabricante getByNome(String nome) {
        String url = String.format("http://localhost:8081/fabricante/nome/%s",nome);
        LOGGER.info(String.format("URL CHAMADA:::::: %s ",url));
        Fabricante fabricante = restTemplate.getForObject(url, Fabricante.class);
        return fabricante;
    }
}
