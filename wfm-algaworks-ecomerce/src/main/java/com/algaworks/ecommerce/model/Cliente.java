package com.algaworks.ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //usa a função auto incremento do banco de dados
    @EqualsAndHashCode.Include
    private Integer id;
    
    private String nome;
    
    @Transient //não cria campo primeiro_nome na tabela ele é ignorado tanto pta salvar, buscar e atualizar, pois é um campo transiente, neste caso o prenchemos no callback @PostLoad
    private String primeiroNome;
    
    @Enumerated(EnumType.STRING) // para guardar o nome da enumeração, caso contrario, por padrão é @Enumerated(EnumType.ORDINAL) 
    private Sexo sexo;
    
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    

    public Cliente() {} //pra funcionar com o JPA precisa ter um cosntrutor vazio

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nome, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
    }
    
    @PostLoad
    public void configurarPrimeiroNome() {
    	if(nome != null && !nome.isBlank()) {
    		int index = nome.indexOf(" ");
    		primeiroNome = nome.substring(0, index);
    	}
    }

}
