package br.com.infinet.pessoa.repository;

import br.com.infinet.pessoa.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Long> {

}
