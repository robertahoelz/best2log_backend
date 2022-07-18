package com.best2log.best2log.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.best2log.model.Pacote;

public interface PacoteRepository extends JpaRepository<Pacote, Integer> {

	List<Pacote> findByCep(String cep);

	List<Pacote> findByDataEntrada(LocalDate data);

}
