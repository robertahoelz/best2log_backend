package com.best2log.best2log.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.best2log.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	Optional<Funcionario> findByCpf(String cpf);

	Optional<Funcionario> findByEmail(String email);

}
