package br.alfa.sales.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.alfa.sales.service.PedidoService;
import br.alfa.sales.vo.PedidoVO;

@ManagedBean
@SessionScoped
public class PedidoController implements Serializable {

	private static final long serialVersionUID = -2383245505333669329L;

	private List<PedidoVO> pedidos;
	
	private PedidoVO pedidoEdicao;
	
	@ManagedProperty("#{pedidoService}")
	private PedidoService pedidoService;
	
	@PostConstruct
	public void init() {
		pesquisarPedidos();
		this.pedidoEdicao = new PedidoVO();
	}
	
	public String novoPedido() {
		this.pedidoEdicao = new PedidoVO();
		return "cadastroPedido?faces-redirect=true";
	}
	
	public void salvar() {
		pedidoService.salvarPedido(pedidoEdicao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido salvo com sucesso!"));
	}
	
	private void pesquisarPedidos() {
		this.pedidos = pedidoService.listarPedidos();
	}

	public PedidoVO getPedidoEdicao() {
		return pedidoEdicao;
	}

	public void setPedidoEdicao(PedidoVO pedidoEdicao) {
		this.pedidoEdicao = pedidoEdicao;
	}

	public List<PedidoVO> getPedidos() {
		return pedidos;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
}
