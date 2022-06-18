package br.com.infnet.servico.repository;

import br.com.infnet.servico.model.FornecedorServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorServicoRepository extends JpaRepository<FornecedorServico, Long> {
}
