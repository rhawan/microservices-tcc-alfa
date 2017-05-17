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

import br.alfa.sales.model.Cliente;
import br.alfa.sales.service.ClienteService;
import br.alfa.sales.util.CustomErrorType;

@RestController
public class ClienteController {
	
	public static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
    @RequestMapping(value = "/cliente/", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listarClientes() {
    	logger.info("Listando todos clientes");
        List<Cliente> clientes = clienteService.listar();
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id) {
    	logger.info("Consultando cliente com id " + id);
        Cliente cliente = clienteService.consultar(id);
        if (cliente == null) {
            return new ResponseEntity(new CustomErrorType("Cliente com id " + id 
                    + " nao encontrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/cliente/", method = RequestMethod.POST)
    public ResponseEntity<String> salvarCliente(@RequestBody Cliente cliente, UriComponentsBuilder ucBuilder) {
        logger.info("Criando cliente : {}", cliente);
        
        clienteService.salvar(cliente);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    @RequestMapping(value = "/cliente/", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> excluirCliente(@RequestBody Cliente cliente) {
        logger.info("Excluindo Cliente com id {}", cliente.getId());
 
        clienteService.excluir(cliente);
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
    }
 
}
