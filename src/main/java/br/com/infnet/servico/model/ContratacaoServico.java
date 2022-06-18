package br.com.infnet.servico.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class ContratacaoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dataContratacao;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa cliente;
    @OneToOne
    @JoinColumn(name = "id_fornecedor_servico")
    private FornecedorServico fornecedorServico;
    private BigDecimal valor;
}
