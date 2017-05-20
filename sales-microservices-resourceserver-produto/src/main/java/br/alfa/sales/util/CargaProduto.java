package br.alfa.sales.util;

import java.io.File;
import java.math.BigDecimal;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.alfa.sales.model.Produto;
import br.alfa.sales.repository.ProdutoRepository;

@Component
public class CargaProduto {
	
	private static final String NOME_ARQUIVO = "carga_produtos.txt";
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void realizarCargaArquivo() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(NOME_ARQUIVO).getFile());
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(file, "UTF-8");
			while(it.hasNext()) {
				String linha = it.nextLine();
				String[] dados = linha.split("\\|");
				inserirItemAvaliado(dados[0], dados[1], dados[2], dados[3], dados[4]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			it.close();
		}
	}
	
	protected void inserirItemAvaliado(String codigo, String descricao, String categoria,
			String quantidadeEstoque, String valorUnitario) {
		try {
			Produto produto = getProdutoExistente(codigo);
			if (produto == null) {
				BigDecimal valorUnit = new BigDecimal(valorUnitario.replace(",", "."));
				Integer qtdEstoque = new Integer(quantidadeEstoque);
				produtoRepository.save(criarProduto(codigo, descricao, valorUnit, qtdEstoque, categoria));
				System.out.printf("Inserindo produto -> Cod: %s Descricao: %s ", codigo, descricao);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	private Produto getProdutoExistente(String codigo) {
		return produtoRepository.findByCodigo(codigo);
	}
	
	private Produto criarProduto(String codigo, String descricao, BigDecimal valorUnitario,
			Integer quantidadeEstoque, String categoria) {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		produto.setQuantidadeEstoque(quantidadeEstoque);
		produto.setValorUnitario(valorUnitario);
		produto.setCategoria(categoria);
		return produto;
	}

}
