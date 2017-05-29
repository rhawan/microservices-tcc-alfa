package br.alfa.sales.vo;

import java.math.BigDecimal;

public class ItemPedidoVO {
	
	private Long produtoId;
	
	private BigDecimal valorUnitario;
	
	private Integer quantidadeItens;
	
	private PedidoVO pedido;

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
	
	public PedidoVO getPedido() {
		return pedido;
	}

}
