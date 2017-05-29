package br.alfa.sales.vo;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

public class ProdutoVO {
	
	private Long id;
	
	@NotBlank(message = "Código é obrigatório")
	private String codigo;
	
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	
	private BigDecimal valorUnitario;
	
	private Integer quantidadeEstoque;
	
	@NotBlank(message = "Categoria é obrigatória")
	private String categoria;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
