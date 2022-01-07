package com.algaworks.ecommerce.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.StatusPedido;

public class RelacionamentoManyToManyTest extends EntityManagerTest {
	
	@Test
	public void verificaRelacionamento() {
		Produto produto = entityManager.find(Produto.class, 1);
		Categoria categoria = entityManager.find(Categoria.class, 1);
		
		
		
		entityManager.getTransaction().begin();
//		categoria.setProdutos(Arrays.asList(produto));	//exempo com não owner da relação, não funciona
		produto.setCategorias(Arrays.asList(categoria)); //só pode salvar o relacionamento o owner da reelação, neste caso produto
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId()); //pra utilizar a relação depois de salva pode ser por qualquer uma das duas entidades envolvidas
		Assertions.assertFalse(categoriaVerificacao.getProdutos().isEmpty());

	}
	
}
