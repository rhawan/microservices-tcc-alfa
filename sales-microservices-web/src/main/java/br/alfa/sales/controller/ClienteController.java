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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
	
	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(clienteFormValidator);
	}*/
	
	@RequestMapping("/clientes")
	public String listarClientes(Model model) {
		List<ClienteVO> clientes = clienteService.listarClientes();
		model.addAttribute("clientes", clientes);
		return "pesquisaCliente";
	}
	
	@GetMapping("/novoCliente")
	public ModelAndView novoCliente(ClienteVO cliente) {
		ModelAndView mv = new ModelAndView("cadastroCliente");
		mv.addObject(cliente);
		return mv;
	}
	
	@PostMapping(value="/salvarCliente")
	public ModelAndView salvarCliente(@Valid ClienteVO cliente, BindingResult result,
			RedirectAttributes redirectAttributes) {
		logger.info("Salvando cliente: {}", cliente);
		if(result.hasErrors()) {
			logger.info("Ocorreu erros durante a insercao do cliente: {}", cliente);
			return novoCliente(cliente);
		}
		
		logger.info("Cliente salvo.", cliente);
		clienteService.salvarCliente(cliente);
		ModelAndView mv = new ModelAndView("redirect:/novoCliente");
		redirectAttributes.addFlashAttribute("mensagem", "Registro salvo com sucesso!");	
		
		return mv;
	}
	
}
