package br.com.infnet.servico.service;

import br.com.infnet.servico.model.ContratacaoServico;

import java.util.List;
import java.util.Optional;

public interface ContratacaoServicoService {
    void incluir(ContratacaoServico contratacaoServico);

    void alterar(Long id, ContratacaoServico contratacaoServico);

    void excluir(Long id);

    Optional<ContratacaoServico> buscarPeloId(Long id);

    List<ContratacaoServico> buscarTodos();
}