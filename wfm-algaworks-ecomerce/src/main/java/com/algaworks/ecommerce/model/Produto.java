package com.algaworks.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="produto")
public class Produto {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    
    private String nome;
    
    private String descricao;
    
    private BigDecimal preco;
    
}
