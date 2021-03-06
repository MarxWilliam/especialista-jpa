package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="estoque")
public class Estoque extends EntidadeBaseInteger{
    
    @OneToOne(optional = false) // sempre que eu salvar um estoque eu quero salvar um mproduto, por isso optional false, sempre é necessário informar produto
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    
    @Column(columnDefinition = "int(11) not null") //esse ddl deve ser feito de acordo com o banco// neste caso int(11) é o padrão para inteiro no MySQL
    private Integer quantidade;
    

    public Estoque() {} //pra funcionar com o JPA precisa ter um cosntrutor vazio

    public Estoque(Integer id) {
        this.id = id;
    }

}
