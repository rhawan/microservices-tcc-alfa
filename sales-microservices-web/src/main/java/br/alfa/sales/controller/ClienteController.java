package br.alfa.sales.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.alfa.sales.service.ClienteService;
import br.alfa.sales.vo.ClienteVO;
import br.alfa.sales.vo.TipoPessoa;
import br.alfa.sales.vo.UF;

@ManagedBean
@SessionScoped
public class ClienteController implements Serializable {
	
	private static final long serialVersionUID = 2558775246523510470L;

	private List<ClienteVO> clientes;
	
	private ClienteVO clienteEdicao;
	
	@ManagedProperty("#{clienteService}")
	private ClienteService clienteService;
	
	@PostConstruct
	public void init() {
		pesquisarClientes();
		this.clienteEdicao = new ClienteVO();
	}
	
	public String novoCliente() {
		this.clienteEdicao = new ClienteVO();
		return "cadastroCliente?faces-redirect=true";
	}
	
	public void salvar() {
		clienteService.salvarCliente(clienteEdicao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente salvo com sucesso!"));
	}
	
	public void excluirCliente() {
		clienteService.excluirCliente(clienteEdicao);
		pesquisarClientes();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente excluído com sucesso!"));
	}
	
	private void pesquisarClientes() {
		this.clientes = clienteService.listarClientes();
	}
	
	public UF[] getEstados() {
		return UF.values();
	}
	
	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
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
