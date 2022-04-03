package br.com.infinet.pessoa.controller;

import br.com.infinet.pessoa.model.Cliente;
import br.com.infinet.pessoa.service.ClienteService;
import br.com.infinet.pessoa.service.GerarExcecaoAleatoriaService;
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
    GerarExcecaoAleatoriaService gerarExcecaoAleatoriaService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){

        gerarExcecaoAleatoriaService.gerar();

        List<Cliente> all = clienteService.buscarTodos();

        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable Long id){

        gerarExcecaoAleatoriaService.gerar();

        Optional<Cliente> cliente = clienteService.buscarPeloId(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok().body(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void incluir(@RequestBody Cliente cliente){

        gerarExcecaoAleatoriaService.gerar();

        clienteService.incluir(cliente);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable  Long id, @RequestBody Cliente cliente){

        gerarExcecaoAleatoriaService.gerar();

        clienteService.alterar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable  Long id){

        gerarExcecaoAleatoriaService.gerar();

        clienteService.excluir(id);
    }

}
