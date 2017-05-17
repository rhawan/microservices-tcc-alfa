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

import br.alfa.sales.model.Pedido;
import br.alfa.sales.service.PedidoService;
import br.alfa.sales.util.CustomErrorType;

@RestController
public class PedidoController {
	
	public static final Logger logger = LoggerFactory.getLogger(PedidoController.class);
	
	@Autowired
	private PedidoService pedidoservice;
	
    @RequestMapping(value = "/pedido/", method = RequestMethod.GET)
    public ResponseEntity<List<Pedido>> listarPedidos() {
    	logger.info("Listando todos pedidos");
        List<Pedido> pedidos = pedidoservice.listar();
        if (pedidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> getPedido(@PathVariable("id") Long id) {
    	logger.info("Consultando pedido com id " + id);
        Pedido pedido = pedidoservice.consultar(id);
        if (pedido == null) {
            return new ResponseEntity(new CustomErrorType("pedido com id " + id 
                    + " nao encontrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/pedido/", method = RequestMethod.POST)
    public ResponseEntity<String> salvarPedido(@RequestBody Pedido pedido, UriComponentsBuilder ucBuilder) {
        logger.info("Criando pedido : {}", pedido);
        
        pedidoservice.salvar(pedido);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
}
