package br.alfa.sales.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class ItemPedido extends Entidade {
	
	private Long produtoId;
	
	private BigDecimal valorUnitario;
	
	private Integer quantidadeItens;
	
	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(Integer quantidade) {
		this.quantidadeItens = quantidade;
	}

}
