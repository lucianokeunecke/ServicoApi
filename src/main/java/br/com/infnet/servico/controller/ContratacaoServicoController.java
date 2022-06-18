package br.com.infnet.servico.controller;

import br.com.infnet.servico.model.ContratacaoServico;
import br.com.infnet.servico.model.Pessoa;
import br.com.infnet.servico.service.ContratacaoServicoService;
import br.com.infnet.servico.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contratacao-servico")
public class ContratacaoServicoController {
    @Autowired
    ContratacaoServicoService contratacaoServicoService;

    @PostMapping
    public void incluir(@RequestBody ContratacaoServico contratacaoServico){
        contratacaoServicoService.incluir(contratacaoServico);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable  Long id, @RequestBody ContratacaoServico contratacaoServico){
        contratacaoServicoService.alterar(id, contratacaoServico);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable  Long id){
        contratacaoServicoService.excluir(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity< ? > listarPeloId(@PathVariable Long id){

        Optional<ContratacaoServico> contratacaoServico = contratacaoServicoService.buscarPeloId(id);

        if(contratacaoServico.isPresent()){
            return ResponseEntity.ok().body(contratacaoServico);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ContratacaoServico>> listarTodos(){
        List<ContratacaoServico> all = contratacaoServicoService.buscarTodos();
        return ResponseEntity.ok().body(all);
    }
}
