package br.com.infnet.servico.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String endereco;
    private long numeroEndereco;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}
