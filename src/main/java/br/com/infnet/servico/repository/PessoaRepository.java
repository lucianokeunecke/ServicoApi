package br.com.infnet.servico.repository;

import br.com.infnet.servico.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Optional<Pessoa> findByCnpjCpf(String cnpjCpf);
}
