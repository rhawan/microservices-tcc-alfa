package br.alfa.sales.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.alfa.sales.service.ClienteService;
import br.alfa.sales.vo.ClienteVO;
import br.alfa.sales.vo.UF;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {
	
	private static final long serialVersionUID = 2558775246523510470L;

	private List<ClienteVO> clientes;
	
	private ClienteVO clienteEdicao;
	
	@ManagedProperty("#{clienteService}")
	private ClienteService clienteService;
	
	@PostConstruct
	public void init() {
		this.clientes = clienteService.listarClientes();
		this.clienteEdicao = new ClienteVO();
	}
	
	public String novoCliente() {
		return "cadastroCliente?faces-redirect=true";
	}
	
	public void salvar() {
		clienteService.salvarCliente(clienteEdicao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente salvo com sucesso!"));
	}
	
	public UF[] getEstados() {
		return UF.values();
	}
	
	public List<ClienteVO> getClientes() {
		return clientes;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public ClienteVO getClienteEdicao() {
		return clienteEdicao;
	}

	public void setClienteEdicao(ClienteVO clienteEdicao) {
		this.clienteEdicao = clienteEdicao;
	}
	
	

}
