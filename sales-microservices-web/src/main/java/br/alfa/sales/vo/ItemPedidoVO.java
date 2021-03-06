package br.alfa.sales.vo;

import java.math.BigDecimal;

public class ItemPedidoVO {
	
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
