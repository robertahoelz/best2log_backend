package com.best2log.best2log.service;

import org.springframework.stereotype.Service;
import com.best2log.best2log.model.Endereco;
import com.best2log.best2log.model.dto.EnderecoDTO;
import com.best2log.best2log.model.dto.ViaCepDTO;
import com.best2log.best2log.repository.EnderecoRepository;
import com.best2log.best2log.restclient.RestViaCep;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	RestViaCep viaCep;

	@Autowired
	PacoteService pacoteService;

	public Endereco addEndereco(Endereco endereco) {
		ViaCepDTO enderecoNovo = viaCep.getViaCep(endereco.getCep());
		endereco.setRua(enderecoNovo.getLogradouro());
		endereco.setCidade(enderecoNovo.getLocalidade());
		endereco.setUf(enderecoNovo.getUf());
		endereco.setBairro(enderecoNovo.getBairro());
		return enderecoRepository.save(endereco);
	}

	public EnderecoDTO getDtoByEndereco(Endereco endereco) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setBairro(endereco.getBairro());
		dto.setCep(endereco.getCep());
		dto.setCidade(endereco.getCidade());
		dto.setComplemento(endereco.getComplemento());
		dto.setIdEndereco(endereco.getIdEndereco());
		dto.setNumeroEndereco(endereco.getNumeroEndereco());
		dto.setRua(endereco.getRua());
		dto.setUf(endereco.getUf());
		return dto;
	}

	public Endereco getEnderecoByDto(EnderecoDTO endereco) {
		Endereco dto = new Endereco();
		dto.setBairro(endereco.getBairro());
		dto.setCep(endereco.getCep());
		dto.setCidade(endereco.getCidade());
		dto.setComplemento(endereco.getComplemento());
		dto.setIdEndereco(endereco.getIdEndereco());
		dto.setNumeroEndereco(endereco.getNumeroEndereco());
		dto.setRua(endereco.getRua());
		dto.setUf(endereco.getUf());
		return dto;
	}

}
