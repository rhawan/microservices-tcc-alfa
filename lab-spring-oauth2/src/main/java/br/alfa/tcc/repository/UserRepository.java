package br.alfa.tcc.repository;

import org.springframework.data.repository.CrudRepository;

import br.alfa.tcc.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
