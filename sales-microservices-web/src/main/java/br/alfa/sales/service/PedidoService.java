package br.alfa.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.alfa.sales.vo.PedidoVO;

@Service
public class PedidoService {
	
	@Autowired
	private IResourcePedido resourcePedido;
	
	public List<PedidoVO> listarPedidos() {
		return resourcePedido.listarPedidos().getBody();
	}
	
	public PedidoVO getPedido(Long id) {
		return resourcePedido.getPedido(id).getBody();
	}
	
	public void salvarPedido(PedidoVO pedidoVO) {
		resourcePedido.salvarPedido(pedidoVO);
	}

}
