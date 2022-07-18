package com.best2log.best2log.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.best2log.model.CentroDistribuicao;

public interface CentroDistribuicaoRepository extends JpaRepository<CentroDistribuicao, Integer> {

	Optional<CentroDistribuicao> findByCnpj(String cnpj);
}
