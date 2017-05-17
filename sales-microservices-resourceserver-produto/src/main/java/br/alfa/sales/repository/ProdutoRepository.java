package br.alfa.sales.repository;

import org.springframework.data.repository.CrudRepository;

import br.alfa.sales.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	Produto findByCodigo(String codigo);

}
