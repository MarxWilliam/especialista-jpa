package com.algaworks.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //usa a função auto incremento do banco de dados
    @EqualsAndHashCode.Include
    private Integer id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id") //quem tem o @JoinColumn é o Owner
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    List<ItemPedido> itens;
    
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    
    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;
    
//    @OneToOne(mappedBy = "pedido") //a volta fica igual mesmo com @JoinTable no Owner para @OneToOne
    @OneToOne(mappedBy = "pedido") //nem sempre que eu tenho um pedido eu tenho a nota fiscal então optional fica true que é o padrão quando não é declarado
    private NotaFiscal notaFiscal;
    
    private BigDecimal total;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamento;
    
    public Pedido() {} //pra funcionar com o JPA precisa ter um cosntrutor vazio

    public Pedido(Integer id) {
        this.id = id;
    }


}
