package br.com.infnet.servico.repository;

import br.com.infnet.servico.model.ContratacaoServico;
import br.com.infnet.servico.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratacaoServicoRepository extends JpaRepository<ContratacaoServico, Long> {
}