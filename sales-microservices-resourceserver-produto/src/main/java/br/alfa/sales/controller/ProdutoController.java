package br.alfa.sales.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.alfa.sales.model.Produto;
import br.alfa.sales.service.ProdutoService;
import br.alfa.sales.util.CustomErrorType;

@RestController
public class ProdutoController {
	
	public static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutoService produtoService;
	
    @RequestMapping(value = "/produto/", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listarProdutos() {
    	logger.info("Listando todos produtos");
        List<Produto> produtos = produtoService.listar();
        if (produtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> getproduto(@PathVariable("id") Long id) {
    	logger.info("Consultando produto com id " + id);
        Produto produto = produtoService.consultar(id);
        if (produto == null) {
            return new ResponseEntity(new CustomErrorType("produto com id " + id 
                    + " nao encontrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/produto/", method = RequestMethod.POST)
    public ResponseEntity<String> salvarProduto(@RequestBody Produto produto, UriComponentsBuilder ucBuilder) {
        logger.info("Criando produto : {}", produto);
        
        produtoService.salvar(produto);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    @RequestMapping(value = "/produto/", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> excluirProduto(@RequestBody Produto produto) {
        logger.info("Excluindo produto com id {}", produto.getId());
 
        produtoService.excluir(produto);
        return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
    }
 
}
