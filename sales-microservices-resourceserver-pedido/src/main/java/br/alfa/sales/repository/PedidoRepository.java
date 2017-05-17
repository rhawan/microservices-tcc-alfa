package br.alfa.sales.repository;

import org.springframework.data.repository.CrudRepository;

import br.alfa.sales.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	
	Pedido findByNumero(String numero);
	
}
