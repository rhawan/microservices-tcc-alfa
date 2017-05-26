package br.alfa.sales.vo;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class ClienteVO {
	
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "CPF / CNPJ é obrigatório")
	private String cpfCnpj;
	
	@NotNull(message = "Informe o Tipo Pessoa")
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message = "Telefone é obrigatório")
	private String telefone;
	
	@NotBlank(message = "Endereço é obrigatório")
	private String endereco;
	
	@NotBlank(message = "Cidade é obrigatório")
	private String cidade;
	
	@NotNull(message = "UF é obrigatório")
	private UF uf;

	@Email(message = "Email inválido")
	private String email;
	
	private BigDecimal valorLimiteCredito;
	
	//private LocalDateTime dataUltimaCompra;

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getValorLimiteCredito() {
		return valorLimiteCredito;
	}

	public void setValorLimiteCredito(BigDecimal valorLimiteCredito) {
		this.valorLimiteCredito = valorLimiteCredito;
	}

//	public LocalDateTime getDataUltimaCompra() {
//		return dataUltimaCompra;
//	}
//
//	public void setDataUltimaCompra(LocalDateTime dataUltimaCompra) {
//		this.dataUltimaCompra = dataUltimaCompra;
//	}

}
