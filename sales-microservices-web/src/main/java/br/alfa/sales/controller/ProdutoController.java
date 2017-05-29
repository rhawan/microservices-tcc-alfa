package br.alfa.sales.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.alfa.sales.service.ProdutoService;
import br.alfa.sales.vo.ProdutoVO;

@ManagedBean
@SessionScoped
public class ProdutoController implements Serializable {
	
	private static final long serialVersionUID = 3395739575632715694L;

	private List<ProdutoVO> produtos;
	
	private ProdutoVO produtoEdicao;
	
	@ManagedProperty("#{produtoService}")
	private ProdutoService produtoService;
	
	@PostConstruct
	public void init() {
		pesquisarProdutos();
		this.produtoEdicao = new ProdutoVO();
	}
	
	public String novoProduto() {
		this.produtoEdicao = new ProdutoVO();
		return "cadastroProduto?faces-redirect=true";
	}
	
	public void salvar() {
		produtoService.salvarProduto(produtoEdicao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto salvo com sucesso!"));
	}
	
	public void excluirProduto() {
		produtoService.excluirProduto(produtoEdicao);
		pesquisarProdutos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto excluído com sucesso!"));
	}
	
	private void pesquisarProdutos() {
		this.produtos = produtoService.listarProdutos();
	}

	public ProdutoVO getProdutoEdicao() {
		return produtoEdicao;
	}

	public void setProdutoEdicao(ProdutoVO produtoEdicao) {
		this.produtoEdicao = produtoEdicao;
	}

	public List<ProdutoVO> getProdutos() {
		return produtos;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
}
