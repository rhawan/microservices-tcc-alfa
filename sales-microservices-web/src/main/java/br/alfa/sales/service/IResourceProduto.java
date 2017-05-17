package br.alfa.sales.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.alfa.sales.config.SalesWebClientConfiguration;
import br.alfa.sales.vo.ProdutoVO;

@FeignClient(name = "resource-produto", configuration = SalesWebClientConfiguration.class)
public interface IResourceProduto {
	
	@RequestMapping(value = "/produto/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProdutoVO>> listarProdutos();
 
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProdutoVO> getproduto(@PathVariable("id") Long id);
 
    @RequestMapping(value = "/produto/", method = RequestMethod.POST)
    public ResponseEntity<String> salvarProduto(@RequestBody ProdutoVO produto);
 
    @RequestMapping(value = "/produto/", method = RequestMethod.DELETE)
    ResponseEntity<ProdutoVO> excluirProduto(@RequestBody ProdutoVO produto);

}
