package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.ContratacaoServico;
import br.com.infnet.servico.repository.ContratacaoServicoRepository;
import br.com.infnet.servico.service.ContratacaoServicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratacaoServicoServiceImpl implements ContratacaoServicoService {
    @Autowired
    ContratacaoServicoRepository contratacaoServicoRepository;

    @Override
    public void incluir(ContratacaoServico contratacaoServico) {
        contratacaoServicoRepository.save(contratacaoServico);
    }

    @Override
    public void alterar(Long id, ContratacaoServico contratacaoServico) {
        ContratacaoServico contratacaoServicoSalvo = contratacaoServicoRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(contratacaoServico, contratacaoServicoSalvo, "id");
        contratacaoServicoRepository.save(contratacaoServicoSalvo);
    }

    @Override
    public void excluir(Long id) {
        contratacaoServicoRepository.deleteById(id);
    }

    @Override
    public Optional<ContratacaoServico> buscarPeloId(Long id) {
        return contratacaoServicoRepository.findById(id);
    }

    @Override
    public List<ContratacaoServico> buscarTodos() {
        return contratacaoServicoRepository.findAll();
    }
}
