package br.alfa.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.alfa.sales.model.Pedido;
import br.alfa.sales.repository.PedidoRepository;

@Service
public class PedidoService extends AbstractService<Pedido> {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	protected CrudRepository<Pedido, Long> getCrudRepository() {
		return pedidoRepository;
	}
	
}
