package br.com.infnet.servico.service;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.model.Fornecedor;

import java.util.Optional;

public interface FornecedorService {
    Optional<Fornecedor> buscarPeloId(Long id);
}
