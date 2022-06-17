package br.com.infnet.servico.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
public class FornecedorServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    @OneToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;
    private BigDecimal valor;
}
