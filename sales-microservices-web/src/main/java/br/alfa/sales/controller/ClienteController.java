package br.alfa.sales.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.alfa.sales.service.ClienteService;
import br.alfa.sales.vo.ClienteVO;

@Controller
public class ClienteController {
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping("/clientes")
	public String listarClientes(Model model) {
		List<ClienteVO> clientes = clienteService.listarClientes();
		model.addAttribute("clientes", clientes);
		return "pesquisaCliente";
	}
	
	@GetMapping("/novoCliente")
	public String novoCliente(Model model) {
		model.addAttribute("cliente", new ClienteVO());
		return "cadastroCliente";
	}
	
	@PostMapping(value="/salvarCliente")
	public String salvarCliente(@ModelAttribute("cliente") @Valid ClienteVO cliente, BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		logger.info("Salvando cliente: {}", cliente);
		if(result.hasErrors()) {
			model.addAttribute("cliente", cliente);
			return "cadastroCliente";
		}
		
		logger.info("Cliente salvo.", cliente);
		clienteService.salvarCliente(cliente);
		redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");	
		
		return "redirect:/novoCliente";
	}
	
}
