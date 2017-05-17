package br.alfa.sales.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.repository.CrudRepository;

import br.alfa.sales.model.Entidade;

public abstract class AbstractService<T extends Entidade> implements IEntidadeServiceCustom<T> {

	@Override
	public List<T> listar() {
		return StreamSupport.stream(getCrudRepository().findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public void salvar(T entidade) {
		getCrudRepository().save(entidade);
	}

	@Override
	public void excluir(T entidade) {
		getCrudRepository().delete(entidade);
	}

	@Override
	public T consultar(Long id) {
		return getCrudRepository().findOne(id);
	}

	@Override
	public void salvar(List<T> entidades) {
		getCrudRepository().save(entidades);
	}
	
	protected abstract CrudRepository<T, Long> getCrudRepository();

}
