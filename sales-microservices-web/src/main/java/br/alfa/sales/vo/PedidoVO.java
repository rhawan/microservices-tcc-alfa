package br.alfa.sales.vo;

import java.math.BigDecimal;
import java.util.List;

public class PedidoVO {
	
	private Long numero;
	
	private Long clienteId;
	
	private BigDecimal valorTotal;
	
	private StatusPedido statusPedido;
	
	private List<ItemPedidoVO> itens;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public List<ItemPedidoVO> getItens() {
		return itens;
	}
	
}
