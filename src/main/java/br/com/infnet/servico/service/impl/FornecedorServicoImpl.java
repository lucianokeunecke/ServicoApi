package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.FornecedorServico;
import br.com.infnet.servico.repository.FornecedorServicoRepository;
import br.com.infnet.servico.service.FornecedorServicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServicoImpl implements FornecedorServicoService {

    @Autowired
    FornecedorServicoRepository fornecedorServicoRepository;

    @Override
    public void incluir(FornecedorServico fornecedorServico) {
        fornecedorServicoRepository.save(fornecedorServico);
    }

    @Override
    public void alterar(Long id, FornecedorServico fornecedorServico) {
        FornecedorServico fornecedorServicoSalvo = fornecedorServicoRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(fornecedorServico, fornecedorServicoSalvo, "id");
        fornecedorServicoRepository.save(fornecedorServicoSalvo);
    }

    @Override
    public void excluir(Long id) {

        fornecedorServicoRepository.deleteById(id);
    }

    @Override
    public Optional<FornecedorServico> buscarPeloId(Long id) {

        return fornecedorServicoRepository.findById(id);
    }

    @Override
    public List<FornecedorServico> buscarTodos() {

        return fornecedorServicoRepository.findAll();
    }
}
