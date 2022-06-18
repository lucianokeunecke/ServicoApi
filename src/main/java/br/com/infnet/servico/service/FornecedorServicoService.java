package br.com.infnet.servico.service;

import br.com.infnet.servico.model.FornecedorServico;

import java.util.List;
import java.util.Optional;

public interface FornecedorServicoService {

    void incluir(FornecedorServico fornecedorServico);

    void alterar(Long id, FornecedorServico fornecedorServico);

    void excluir(Long id);

    Optional<FornecedorServico> buscarPeloId(Long id);

    List<FornecedorServico> buscarTodos();
}
