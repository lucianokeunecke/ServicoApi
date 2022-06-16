package br.com.infnet.servico.repository;

import br.com.infnet.servico.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
