package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.service.GerarExcecaoAleatoriaService;
import org.springframework.stereotype.Service;

import java.util.SplittableRandom;

@Service
public class GerarExcecaoAleatoriaServiceImpl implements GerarExcecaoAleatoriaService {

    /* Este método irá gerar excecao de forma aleatória servindo como base para gerar métricas */
    @Override
    public void gerar() {

        SplittableRandom random = new SplittableRandom();
        int i = random.nextInt(1000);
        if(i > 900){
            throw new RuntimeException("Ocorreu um erro ao processar a sua solicitação.");
        }
    }
}
