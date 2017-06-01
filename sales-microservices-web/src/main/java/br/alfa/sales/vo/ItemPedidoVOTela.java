package br.alfa.sales.vo;

import java.math.BigDecimal;

public class ItemPedidoVOTela {
	
	private ProdutoVO produto;
	
	private BigDecimal valorUnitario;
	
	private Integer quantidadeItens;
	

	public ProdutoVO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
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
