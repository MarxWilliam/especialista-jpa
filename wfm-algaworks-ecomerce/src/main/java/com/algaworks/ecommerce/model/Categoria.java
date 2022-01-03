package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="categoria")
public class Categoria {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    
    private String nome;
    
    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
    

    public Categoria() {} //pra funcionar com o JPA precisa ter um cosntrotor vazio

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String nome, Integer categoriaPaiId) {
        this.id = id;
        this.nome = nome;
        this.categoriaPaiId = categoriaPaiId;
    }

}
