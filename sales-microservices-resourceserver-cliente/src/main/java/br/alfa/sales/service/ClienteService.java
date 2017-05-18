package br.alfa.sales.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.alfa.sales.model.Cliente;
import br.alfa.sales.repository.ClienteRepository;
import br.alfa.sales.util.CargaCliente;

@Service
public class ClienteService extends AbstractService<Cliente> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CargaCliente cargaCliente;

	@Override
	protected CrudRepository<Cliente, Long> getCrudRepository() {
		return clienteRepository;
	}
	
	@PostConstruct
	void init() {
		cargaCliente.realizarCargaArquivo();
	}
	
	public Cliente consultarPorCpfCnpj(String cpfCnpj) {
		return clienteRepository.findByCpfCnpj(cpfCnpj);
	}
	
}
