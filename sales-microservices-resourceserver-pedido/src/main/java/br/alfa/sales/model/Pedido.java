package br.alfa.sales.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Pedido extends Entidade {
	
	private Long numero;
	
	private Long clienteId;
	
	private BigDecimal valorTotal;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pedido_id")
	private List<ItemPedido> itens;

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

	public List<ItemPedido> getItens() {
		return itens;
	}
	
}
