package br.alfa.sales.util;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.alfa.sales.model.Cliente;
import br.alfa.sales.model.TipoPessoa;
import br.alfa.sales.model.UF;
import br.alfa.sales.repository.ClienteRepository;

@Component
public class CargaCliente {
	
	private static final String NOME_ARQUIVO = "carga_clientes.txt";
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
	
	public void realizarCargaArquivo() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(NOME_ARQUIVO).getFile());
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(file, "UTF-8");
			while(it.hasNext()) {
				String linha = it.nextLine();
				String[] dados = linha.split("\\|");
				inserirCliente(dados[0], dados[1], dados[2], dados[3], dados[4],
						dados[5], dados[6], dados[7], dados[8], dados[9]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			it.close();
		}
	}
	
	protected void inserirCliente(String nome, String cpfCnpj, String tipoPessoa,
			String telefone, String endereco, String cidade,
			String uf, String email, String valorLimiteCredito, String dataUltimaCompra) {
		try {
			Cliente cliente = getClienteExistente(cpfCnpj);
			if (cliente == null) {
				TipoPessoa tipoPessoaEnum = TipoPessoa.valueOf(tipoPessoa);
				UF ufEnum = UF.valueOf(uf);
				BigDecimal valorLimiteCred = new BigDecimal(valorLimiteCredito.replace(",", "."));
				LocalDate dataUltCompra = LocalDate.parse(dataUltimaCompra, FORMATTER);
				clienteRepository.save(criarCliente(nome, cpfCnpj, tipoPessoaEnum,
						telefone, endereco, cidade, ufEnum, email, valorLimiteCred, dataUltCompra));
				System.out.printf("Inserindo cliente -> CPF/CNPJ: %s Nome: %s ", cpfCnpj, nome);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	private Cliente getClienteExistente(String cpfCnpj) {
		return clienteRepository.findByCpfCnpj(cpfCnpj);
	}
	
	private Cliente criarCliente(String nome, String cpfCnpj, TipoPessoa tipoPessoa,
			String telefone, String endereco, String cidade, UF uf, 
			String email, BigDecimal valorLimiteCredito, LocalDate dataUltimaCompra) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpfCnpj(cpfCnpj);
		cliente.setTipoPessoa(tipoPessoa);
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);
		cliente.setCidade(cidade);
		cliente.setUF(uf);
		cliente.setEmail(email);
		cliente.setValorLimiteCredito(valorLimiteCredito);
		cliente.setDataUltimaCompra(dataUltimaCompra);
		return cliente;
	}

}
