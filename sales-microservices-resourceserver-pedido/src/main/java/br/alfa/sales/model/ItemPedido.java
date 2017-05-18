package br.alfa.sales.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class ItemPedido extends Entidade {
	
	private Long produtoId;
	
	private BigDecimal valorUnitario;
	
	private Integer quantidadeItens;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "fk_pedido_id"))
	private Pedido pedido;

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

	public Integer getQuantidade() {
		return quantidadeItens;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidadeItens = quantidade;
	}

}
