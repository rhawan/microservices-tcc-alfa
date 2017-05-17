package br.alfa.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.alfa.sales.service.ClienteService;
import br.alfa.sales.vo.ClienteVO;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/cliente")
	public String listarClientes(Model model) {
		List<ClienteVO> clientes = clienteService.listarClientes();
		model.addAttribute("clientes", clientes);
		return "pesquisaCliente";
	}
	
}
