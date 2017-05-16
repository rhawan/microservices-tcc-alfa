package br.alfa.sales.service;

import java.util.List;

import br.alfa.sales.model.Entidade;

public interface IEntidadeServiceCustom<T extends Entidade> {
	
	List<T> listar();
	
	void salvar(T entidade);
	
	void excluir(T entidade);
	
	T consultar(Long id);
	
	void salvar(List<T> entidades);
	
}
