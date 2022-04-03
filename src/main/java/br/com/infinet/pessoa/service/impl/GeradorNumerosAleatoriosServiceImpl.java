package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.service.GeradorNumerosAleatoriosService;
import org.springframework.stereotype.Service;

import java.util.SplittableRandom;

@Service
public class GeradorNumerosAleatoriosServiceImpl implements GeradorNumerosAleatoriosService {

    @Override
    public void gerar() {

        SplittableRandom random = new SplittableRandom();
        int i = random.nextInt(1000);
        if(i > 500){
            throw new RuntimeException("Ocorreu um erro ao processar a sua solicitação.");
        }
    }
}
