package br.alfa.sales.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.alfa.sales.service.ClienteService;
import br.alfa.sales.service.PedidoService;
import br.alfa.sales.service.ProdutoService;
import br.alfa.sales.vo.ClienteVO;
import br.alfa.sales.vo.ItemPedidoVOTela;
import br.alfa.sales.vo.PedidoTransformer;
import br.alfa.sales.vo.PedidoVO;
import br.alfa.sales.vo.PedidoVOTela;
import br.alfa.sales.vo.ProdutoVO;
import br.alfa.sales.vo.StatusPedido;

@ManagedBean
@ViewScoped
public class PedidoController implements Serializable {

	private static final long serialVersionUID = -2383245505333669329L;

	private List<PedidoVOTela> pedidos;
	
	private PedidoVOTela pedidoEdicao;
	private List<ClienteVO> clientes;
	private ProdutoVO produtoSelecionado;
	private List<ProdutoVO> produtos;
	
	@ManagedProperty("#{pedidoService}")
	private PedidoService pedidoService;
	
	@ManagedProperty("#{clienteService}")
	private ClienteService clienteService;
	
	@ManagedProperty("#{produtoService}")
	private ProdutoService produtoService;
	
	@ManagedProperty("#{pedidoTransformer}")
	private PedidoTransformer pedidoTransformer;
	
	@PostConstruct
	public void init() {
		pesquisarPedidos();
		this.pedidoEdicao = new PedidoVOTela();
		this.clientes = clienteService.listarClientes();
		this.produtos = produtoService.listarProdutos();
	}
	
	public String novoPedido() {
		this.pedidoEdicao = new PedidoVOTela();
		return "cadastroPedido?faces-redirect=true";
	}
	
	public void salvar() {
		try {
			PedidoVO pedido = pedidoTransformer.toPedidoVO(pedidoEdicao);
			pedido.setStatusPedido(StatusPedido.PENDENTE);
			pedido.setNumero(getUltimoNumeroPedido() + 1);
			
			pedidoService.salvarPedido(pedido);
			this.limparTela();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido salvo com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar pedido!\n" + e.getMessage(), null));
		}
	}
	
	public void calcularValorTotal() {
		//TODO verificar se quantidade solicitada é maior que estoque
		
		BigDecimal valorTotal = BigDecimal.ZERO;
		for(ItemPedidoVOTela item: pedidoEdicao.getItens()) {
			valorTotal = valorTotal.add(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidadeItens())));
		}
		pedidoEdicao.setValorTotal(valorTotal);
	}
	
	public void pesquisarPedidos() {
		List<PedidoVO> pedidosVO = pedidoService.listarPedidos();
		
		if(this.pedidos == null) {
			this.pedidos = new ArrayList<>();
		}
		if(pedidosVO != null && !pedidosVO.isEmpty()) {
			for(PedidoVO pedido : pedidosVO) {
				pedidos.add(pedidoTransformer.toPedidoTela(pedido));
			}
		}
		
	}
	
	private Long getUltimoNumeroPedido() {
		if(pedidos != null && pedidos.isEmpty()) {
			return 0l;
		}
		return pedidos.stream().max((p1, p2) -> Long.compare(p1.getNumero(), p2.getNumero())).get().getNumero();
	}
	
	public void addItemPedido() {
		if(produtoSelecionado == null) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selecione um produto para adicionar!", null));
			return;
		}
		this.pedidoEdicao.addItem(produtoSelecionado);
	}
	
	private void limparTela() {
		this.pedidoEdicao = new PedidoVOTela();
		this.produtoSelecionado = null;
	}

	public PedidoVOTela getPedidoEdicao() {
		return pedidoEdicao;
	}

	public void setPedidoEdicao(PedidoVOTela pedidoEdicao) {
		this.pedidoEdicao = pedidoEdicao;
	}

	public List<PedidoVOTela> getPedidos() {
		return pedidos;
	}
	
	public List<ClienteVO> getClientes() {
		return clientes;
	}
	
	public List<ProdutoVO> getProdutos() {
		return produtos;
	}
	
	public ProdutoVO getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(ProdutoVO produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public void setPedidoTransformer(PedidoTransformer pedidoTransformer) {
		this.pedidoTransformer = pedidoTransformer;
	}
	
}
