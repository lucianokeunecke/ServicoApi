package br.com.infinet.pessoa.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpjCpf;
    private String nome;
    private String endereco;
    private Long numeroEndereco;
    private String bairro;
    private String cep;
    private Long id_cidade;
}
