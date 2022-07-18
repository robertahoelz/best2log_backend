package com.best2log.best2log.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.best2log.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	Optional<Empresa> findByNomeFantasia(String nome);

	Optional<Empresa> findByDataCadastro(LocalDate data);

	List<Empresa> findByDataCadastroAndAtivo(LocalDate data, boolean ativo);

	List<Empresa> findAllByAtivo(Sort sort,boolean ativo);

}
