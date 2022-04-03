package br.com.infinet.pessoa.controller;

import br.com.infinet.pessoa.model.Carro;
import br.com.infinet.pessoa.model.Cliente;
import br.com.infinet.pessoa.service.ClienteService;
import br.com.infinet.pessoa.service.GeradorNumerosAleatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    GeradorNumerosAleatoriosService geradorNumerosAleatoriosService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){

        geradorNumerosAleatoriosService.gerar();

        List<Cliente> all = clienteService.buscarTodos();

        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable  Long id){

        geradorNumerosAleatoriosService.gerar();

        Optional<Cliente> byId = clienteService.buscarPeloId(id);

        if(byId.isPresent()){
            return ResponseEntity.ok().body(byId);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void incluir(@RequestBody Cliente cliente){

        geradorNumerosAleatoriosService.gerar();

        clienteService.incluir(cliente);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable  Long id, @RequestBody Cliente cliente){

        //geradorNumerosAleatoriosService.gerar();

        clienteService.alterar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable  Long id){

        geradorNumerosAleatoriosService.gerar();

        clienteService.excluir(id);
    }

}
