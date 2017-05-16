package br.alfa.sales.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.alfa.sales.config.SalesWebClientConfiguration;
import br.alfa.sales.vo.ClienteVO;

@FeignClient(name = "resource-cliente", configuration = SalesWebClientConfiguration.class)
public interface IResourceCliente {
	
	@RequestMapping(value = "/cliente/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<ClienteVO>> listarClientes();
	
	@RequestMapping(value = "/cliente/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ClienteVO> getCliente(@RequestParam("id") Long id);
	
	@RequestMapping(value = "/cliente/", method = RequestMethod.POST)
    ResponseEntity<String> salvarCliente(@RequestBody ClienteVO clienteVO);
	
	@RequestMapping(value = "/cliente/", method = RequestMethod.DELETE)
    ResponseEntity<ClienteVO> excluirCliente(@RequestBody ClienteVO clienteVO);

}
