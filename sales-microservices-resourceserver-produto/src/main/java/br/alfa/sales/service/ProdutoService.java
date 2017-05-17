package br.alfa.sales.service;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.alfa.sales.model.Produto;
import br.alfa.sales.repository.ProdutoRepository;

@Service
public class ProdutoService extends AbstractService<Produto> {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	protected CrudRepository<Produto, Long> getCrudRepository() {
		return produtoRepository;
	}
	
	@PostConstruct
	void init() {
		Produto produto1 = new Produto();
		produto1.setCodigo("242382");
		produto1.setDescricao("Smartphone Samsung Galaxy S7");
		produto1.setQuantidadeEstoque(23);
		produto1.setValorUnitario(new BigDecimal("3245.60"));
		produto1.setCategoria("CELULARES");
		
		Produto produto2 = new Produto();
		produto2.setCodigo("226161");
		produto2.setDescricao("Roteador Wireless D-link 809");
		produto2.setQuantidadeEstoque(5);
		produto2.setValorUnitario(new BigDecimal("89.90"));
		produto2.setCategoria("ROTEADORES");
		
		if(consultarPorCodigo(produto1.getCodigo()) == null) {
			produtoRepository.save(produto1);
		}
		
		if(consultarPorCodigo(produto2.getCodigo()) == null) {
			produtoRepository.save(produto2);
		}
	}
	
	public Produto consultarPorCodigo(String codigo) {
		return produtoRepository.findByCodigo(codigo);
	}
	
}
