package br.com.infinet.pessoa.controller;

import br.com.infinet.pessoa.service.CepService;
import br.com.infinet.pessoa.service.GerarExcecaoAleatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    CepService cepService;

    @Autowired
    GerarExcecaoAleatoriaService gerarExcecaoAleatoriaService;

    @GetMapping("/{numeroCep}")
    public ResponseEntity< ? > pesquisar(@PathVariable String numeroCep){

        gerarExcecaoAleatoriaService.gerar();

        return ResponseEntity.ok().body(cepService.pesquisar(numeroCep));
    }
}
