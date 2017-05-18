package br.alfa.sales.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.alfa.sales.model.Produto;
import br.alfa.sales.repository.ProdutoRepository;
import br.alfa.sales.util.CargaProduto;

@Service
public class ProdutoService extends AbstractService<Produto> {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CargaProduto cargaProduto;

	@Override
	protected CrudRepository<Produto, Long> getCrudRepository() {
		return produtoRepository;
	}
	
	@PostConstruct
	void init() {
		cargaProduto.realizarCargaArquivo();
	}
	
	public Produto consultarPorCodigo(String codigo) {
		return produtoRepository.findByCodigo(codigo);
	}
	
}
