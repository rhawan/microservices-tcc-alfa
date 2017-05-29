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
import br.alfa.sales.vo.PedidoVO;

@FeignClient(name = "resource-pedido", configuration = SalesWebClientConfiguration.class)
public interface IResourcePedido {
	
	@RequestMapping(value = "/pedido/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<PedidoVO>> listarPedidos();
	
	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PedidoVO> getPedido(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/pedido/", method = RequestMethod.POST)
    ResponseEntity<String> salvarPedido(@RequestBody PedidoVO pedido);

}
