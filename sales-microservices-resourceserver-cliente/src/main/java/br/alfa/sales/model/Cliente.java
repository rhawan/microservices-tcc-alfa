package br.alfa.sales.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Cliente extends Entidade {
	
	private String nome;
	
	private String cpfCnpj;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	
	private String telefone;
	
	private String endereco;
	
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private UF UF;
	
	private String email;
	
	private BigDecimal valorLimiteCredito;
	
	//@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDate dataUltimaCompra;

	public String getNome() {
		return nome;
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

	public UF getUF() {
		return UF;
	}

	public void setUF(UF uF) {
		UF = uF;
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

	public LocalDate getDataUltimaCompra() {
		return dataUltimaCompra;
	}

	public void setDataUltimaCompra(LocalDate dataUltimaCompra) {
		this.dataUltimaCompra = dataUltimaCompra;
	}
	
}
