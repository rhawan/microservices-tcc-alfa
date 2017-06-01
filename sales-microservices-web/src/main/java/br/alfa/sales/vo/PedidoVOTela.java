package br.alfa.sales.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoVOTela {
	
	private Long numero;
	
	private ClienteVO cliente;
	
	private BigDecimal valorTotal;
	
	private StatusPedido statusPedido;
	
	private List<ItemPedidoVOTela> itens;
	
	public void addItem(ProdutoVO produto) {
		if(this.itens == null) {
			this.itens = new ArrayList<>();
		}
		ItemPedidoVOTela item = new ItemPedidoVOTela();
		item.setProduto(produto);
		item.setValorUnitario(produto.getValorUnitario());
		this.itens.add(item);
	}
	
	public void addItemTela(ItemPedidoVOTela item) {
		if(this.itens == null) {
			this.itens = new ArrayList<>();
		}
		this.itens.add(item);
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
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

	public List<ItemPedidoVOTela> getItens() {
		return itens;
	}
	
}
