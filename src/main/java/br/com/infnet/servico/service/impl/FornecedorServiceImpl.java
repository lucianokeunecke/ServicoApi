package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.model.Fornecedor;
import br.com.infnet.servico.repository.FornecedorRepository;
import br.com.infnet.servico.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public Optional<Fornecedor> buscarPeloId(Long id) {
        return fornecedorRepository.findById(id);
    }
}
