package br.com.infnet.servico.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String logradouro;
    private long numeroEndereco;
    //private String complemento;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @Embedded
    private Bairro bairro;
}
