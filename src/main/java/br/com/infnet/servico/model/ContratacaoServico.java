package br.com.infnet.servico.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
