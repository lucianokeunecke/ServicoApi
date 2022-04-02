package br.com.infinet.pessoa.controller;

import br.com.infinet.pessoa.model.Cliente;
import br.com.infinet.pessoa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        /*SplittableRandom random = new SplittableRandom();
        int i = random.nextInt(1000);
        if(i > 900){
            throw new RuntimeException("Um Erro Ocorreu");
        }*/
        List<Cliente> all = clienteService.getAll();
        return ResponseEntity.ok().body(all);
    }

}
