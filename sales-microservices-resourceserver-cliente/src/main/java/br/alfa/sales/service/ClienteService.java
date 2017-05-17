package br.alfa.sales.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.alfa.sales.model.Cliente;
import br.alfa.sales.model.TipoPessoa;
import br.alfa.sales.model.UF;
import br.alfa.sales.repository.ClienteRepository;

@Service
public class ClienteService extends AbstractService<Cliente> {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	protected CrudRepository<Cliente, Long> getCrudRepository() {
		return clienteRepository;
	}
	
	@PostConstruct
	void init() {
		Cliente cliente1 = new Cliente();
		cliente1.setNome("JOAO SILVA");
		cliente1.setCpfCnpj("99999999999");
		cliente1.setEmail("aaa@aaa.com");
		cliente1.setValorLimiteCredito(new BigDecimal("5000"));
		cliente1.setEndereco("Rua 10, Praça Universitária, Setor Universitário");
		cliente1.setCidade("GOIANIA");
		cliente1.setUF(UF.GO);
		cliente1.setTipoPessoa(TipoPessoa.FISICA);
		//cliente1.setDataUltimaCompra(LocalDateTime.now());
		cliente1.setTelefone("6212345678");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("LARISSA MARCAL");
		cliente2.setCpfCnpj("44444444444");
		cliente2.setEmail("bbb@bbb.com");
		cliente2.setValorLimiteCredito(new BigDecimal("1340"));
		cliente2.setEndereco("Av 136, Ed Nasa Business Style, Setor Marista");
		cliente2.setCidade("GOIANIA");
		cliente2.setUF(UF.GO);
		cliente2.setTipoPessoa(TipoPessoa.FISICA);
		//cliente2.setDataUltimaCompra(LocalDateTime.now());
		cliente2.setTelefone("62987654321");
		
		if(consultarPorCpfCnpj(cliente1.getCpfCnpj()) == null) {
			clienteRepository.save(cliente1);
		}
		
		if(consultarPorCpfCnpj(cliente2.getCpfCnpj()) == null) {
			clienteRepository.save(cliente2);
		}
	}
	
	public Cliente consultarPorCpfCnpj(String cpfCnpj) {
		return clienteRepository.findByCpfCnpj(cpfCnpj);
	}
	
}
