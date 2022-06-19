package br.com.infnet.servico.model;

import br.com.infnet.servico.enumerator.EnumTipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpjCpf;
    private String nome;
    private String nomeFantasia;
    private String nomeContato;
    private String telefone;
    private String email;

    @JsonIgnoreProperties("pessoa")
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @JsonIgnoreProperties
    public boolean EhPessoaJuridica() {
        return tipoPessoa.getId() == EnumTipoPessoa.PESSOA_JURIFICA.getValor();
    }

    @JsonIgnoreProperties
    public boolean EhPessoaFisica() {
        return tipoPessoa.getId() == EnumTipoPessoa.PESSOA_FISICA.getValor();
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo_cadastro")
    private TipoCadastro tipoCadastro;
}
