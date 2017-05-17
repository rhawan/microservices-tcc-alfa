package br.alfa.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.alfa.sales.vo.ProdutoVO;

@Service
public class ProdutoService {
	
	@Autowired
	private IResourceProduto resourceProduto;
	
	public List<ProdutoVO> listarProdutos() {
		return resourceProduto.listarProdutos().getBody();
	}
	
	public ProdutoVO getProduto(Long id) {
		return resourceProduto.getproduto(id).getBody();
	}
	
	public void salvarProduto(ProdutoVO produtoVO) {
		resourceProduto.salvarProduto(produtoVO);
	}
	
	public void excluirProduto(ProdutoVO produtoVO) {
		resourceProduto.excluirProduto(produtoVO);
	}

}
