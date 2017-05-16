package br.alfa.sales.repository;

import org.springframework.data.repository.CrudRepository;

import br.alfa.sales.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente findByCpfCnpj(String cpfCnpj);

}
