package br.alfa.sales.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.alfa.sales.service.ClienteService;
import br.alfa.sales.validator.ClienteFormValidator;
import br.alfa.sales.vo.ClienteVO;

@Controller
public class ClienteController {
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;

	
	@Autowired
	private ClienteFormValidator clienteFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(clienteFormValidator);
	}
	
	@RequestMapping("/clientes")
	public String listarClientes(Model model) {
		List<ClienteVO> clientes = clienteService.listarClientes();
		model.addAttribute("clientes", clientes);
		return "pesquisaCliente";
	}
	
	@RequestMapping("/novocliente")
	public String novoCliente(Model model) {
		ClienteVO cliente = new ClienteVO();
		model.addAttribute("cliente", cliente);
		return "cadastroCliente";
	}
	
	@PostMapping(value="/gravacliente")
	public String salvarCliente(@Valid ClienteVO clientevo,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("Salvando cliente: {}", clientevo);
		if(result.hasErrors()) {
			logger.info("Ocorreu erros durante a insercao do cliente: {}", clientevo);
			return "cadastroCliente";
		} else {
			logger.info("Cliente salvo.", clientevo);
			clienteService.salvarCliente(clientevo);
			redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");	
		}
		
		return listarClientes(model);
	}
	
}
