package br.alfa.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.alfa.sales.vo.ClienteVO;

@Service
public class ClienteService {
	
	@Autowired
	private IResourceCliente resourceCliente;
	
	public List<ClienteVO> listarClientes() {
		return resourceCliente.listarClientes().getBody();
	}
	
	public ClienteVO getCliente(Long id) {
		return resourceCliente.getCliente(id).getBody();
	}
	
	public void salvarCliente(ClienteVO clienteVO) {
		resourceCliente.salvarCliente(clienteVO);
	}
	
	public void excluirCliente(ClienteVO clienteVO) {
		resourceCliente.excluirCliente(clienteVO);
	}

}
