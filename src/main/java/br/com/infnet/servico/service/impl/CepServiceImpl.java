package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.Cep;
import br.com.infnet.servico.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
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

        numeroCep = numeroCep.replaceAll("[^0123456789]", "");

        if (numeroCep.trim().length() == 8) {
            String url = String.format("http://localhost:8081/cep/%s",numeroCep);

            LOGGER.info(String.format("Comunicando-se com a API Cep: %s ", url));

            Cep cep = restTemplate.getForObject(url, Cep.class);

            if (!Objects.isNull(cep)) {
                if (!Objects.isNull(cep.getCep())) {
                    return cep;
                }
            }

            throw new RuntimeException("O número do CEP " + numeroCep + " não se encontra cadastrado.");
        }

        throw new RuntimeException("Número do CEP inválido. Informe o número do CEP com 8 dígitos numéricos.");
    }
}
