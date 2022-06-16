package br.com.infnet.servico.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Fornecedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cnpjCpf;
    private String razaoSocial;
    private String nomeFantasia;
    private String nomeContato;
    private String telefone;
    private String email;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}