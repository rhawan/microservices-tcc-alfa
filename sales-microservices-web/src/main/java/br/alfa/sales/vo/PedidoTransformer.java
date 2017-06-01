package br.alfa.sales.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.alfa.sales.service.ClienteService;
import br.alfa.sales.service.ProdutoService;

@Component
public class PedidoTransformer {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public PedidoVO toPedidoVO(PedidoVOTela tela) {
		PedidoVO pedido = new PedidoVO();
		pedido.setClienteId(tela.getCliente().getId());
		pedido.setNumero(tela.getNumero());
		pedido.setStatusPedido(tela.getStatusPedido());
		pedido.setValorTotal(tela.getValorTotal());
		
		for (ItemPedidoVOTela itemTela : tela.getItens()) {
			ItemPedidoVO item = new ItemPedidoVO();
			item.setProdutoId(itemTela.getProduto().getId());
			item.setQuantidadeItens(itemTela.getQuantidadeItens());
			item.setValorUnitario(itemTela.getValorUnitario());
			pedido.addItem(item);
		}
		return pedido;
	}
	
	public PedidoVOTela toPedidoTela(PedidoVO pedido) {
		PedidoVOTela tela = new PedidoVOTela();
		tela.setCliente(clienteService.getCliente(pedido.getClienteId()));
		tela.setNumero(pedido.getNumero());
		tela.setStatusPedido(pedido.getStatusPedido());
		tela.setValorTotal(pedido.getValorTotal());
		
		for(ItemPedidoVO item : pedido.getItens()) {
			ItemPedidoVOTela itemTela = new ItemPedidoVOTela();
			itemTela.setProduto(produtoService.getProduto(item.getProdutoId()));
			itemTela.setQuantidadeItens(item.getQuantidadeItens());
			itemTela.setValorUnitario(item.getValorUnitario());
			tela.addItemTela(itemTela);
		}
		return tela;
	}

}
