package com.best2log.best2log.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.best2log.best2log.exception.CentroDistribuicaoAtivadoException;
import com.best2log.best2log.exception.CentroDistribuicaoDesativadoException;
import com.best2log.best2log.exception.CentroDistribuicaoExistenteException;
import com.best2log.best2log.exception.CentroDistribuicaoNotFoundException;
import com.best2log.best2log.model.CentroDistribuicao;
import com.best2log.best2log.model.dto.CentroDistribuicaoDTO;
import com.best2log.best2log.repository.CentroDistribuicaoRepository;

@Service
public class CentroDistribuicaoService {

	@Autowired
	CentroDistribuicaoRepository repository;

	@Autowired
	EnderecoService service;

	public List<CentroDistribuicaoDTO> getAll(LocalDate data) {
		List<CentroDistribuicao> lista = repository.findAll();
		List<CentroDistribuicaoDTO> listaDTO = new ArrayList<>();
		if(data==null) {
		for (CentroDistribuicao cd : lista) {
			if (cd.isAtivo()) {
				CentroDistribuicaoDTO dto = new CentroDistribuicaoDTO();
				dto.setCnpj(cd.getCnpj());
				dto.setRazaoSocial(cd.getRazaoSocial());
				dto.setNomeFantasia(cd.getNomeFantasia());
				dto.setIdCentroDistribuicao(cd.getIdCentroDistribuicao());
				dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
				listaDTO.add(dto);
			}
		}
		return listaDTO;
		}else {
			Sort sort= Sort.by(data.toString());
			lista=repository.findAll(sort);
		}for (CentroDistribuicao cd : lista) {
			if (cd.isAtivo()) {
				CentroDistribuicaoDTO dto = new CentroDistribuicaoDTO();
				dto.setCnpj(cd.getCnpj());
				dto.setRazaoSocial(cd.getRazaoSocial());
				dto.setNomeFantasia(cd.getNomeFantasia());
				dto.setIdCentroDistribuicao(cd.getIdCentroDistribuicao());
				dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	public CentroDistribuicaoDTO getOne(Integer id)
			throws CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {
		Optional<CentroDistribuicao> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new CentroDistribuicaoNotFoundException();
		}

		CentroDistribuicao oldCentroDistribuicaoDTO = optional.get();
		if (oldCentroDistribuicaoDTO.isAtivo()) {
			CentroDistribuicaoDTO newCentroDistribuicaoDTO = new CentroDistribuicaoDTO();
			newCentroDistribuicaoDTO.setCnpj(oldCentroDistribuicaoDTO.getCnpj());
			newCentroDistribuicaoDTO.setRazaoSocial(oldCentroDistribuicaoDTO.getRazaoSocial());
			newCentroDistribuicaoDTO.setNomeFantasia(oldCentroDistribuicaoDTO.getNomeFantasia());
			newCentroDistribuicaoDTO.setIdCentroDistribuicao(oldCentroDistribuicaoDTO.getIdCentroDistribuicao());
			newCentroDistribuicaoDTO.setEndereco(service.getDtoByEndereco(oldCentroDistribuicaoDTO.getEndereco()));
			return newCentroDistribuicaoDTO;
		}
		throw new CentroDistribuicaoDesativadoException();
	}

	public CentroDistribuicaoDTO getOneByCnpj(String cnpj)
			throws CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {
		Optional<CentroDistribuicao> optional = repository.findByCnpj(cnpj);
		if (optional.isEmpty()) {
			throw new CentroDistribuicaoNotFoundException();
		}
		CentroDistribuicao oldCentroDistribuicaoDTO = optional.get();
		if (oldCentroDistribuicaoDTO.isAtivo()) {
			CentroDistribuicaoDTO newCentroDistribuicaoDTO = new CentroDistribuicaoDTO();
			newCentroDistribuicaoDTO.setCnpj(oldCentroDistribuicaoDTO.getCnpj());
			newCentroDistribuicaoDTO.setRazaoSocial(oldCentroDistribuicaoDTO.getRazaoSocial());
			newCentroDistribuicaoDTO.setNomeFantasia(oldCentroDistribuicaoDTO.getNomeFantasia());
			newCentroDistribuicaoDTO.setAtivo(oldCentroDistribuicaoDTO.isAtivo());
			newCentroDistribuicaoDTO.setEndereco(service.getDtoByEndereco(oldCentroDistribuicaoDTO.getEndereco()));
			newCentroDistribuicaoDTO.setIdCentroDistribuicao(oldCentroDistribuicaoDTO.getIdCentroDistribuicao());
			return newCentroDistribuicaoDTO;
		}
		throw new CentroDistribuicaoDesativadoException();
	}

	public void post(CentroDistribuicaoDTO dto) throws CentroDistribuicaoExistenteException {
		verificarCentroDistribuicao(dto.getCnpj());
		CentroDistribuicao cd = new CentroDistribuicao();
		cd.setAtivo(true);
		cd.setCnpj(dto.getCnpj());
		cd.setEndereco(service.getEnderecoByDto(dto.getEndereco()));
		cd.setNomeFantasia(dto.getNomeFantasia());
		cd.setRazaoSocial(dto.getRazaoSocial());
		service.addEndereco(cd.getEndereco());
		repository.save(cd);
		cd.getEndereco().setCd(cd);
		repository.save(cd);
	}

	public void update(Integer id, CentroDistribuicaoDTO CentroDistribuicao)
			throws CentroDistribuicaoNotFoundException {
		Optional<CentroDistribuicao> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new CentroDistribuicaoNotFoundException();
		}
		CentroDistribuicao oldCentroDistribuicao = optional.get();
		if (CentroDistribuicao.getCnpj() != null && !CentroDistribuicao.getCnpj().equals("")) {
			oldCentroDistribuicao.setCnpj(CentroDistribuicao.getCnpj());
		}
		if (CentroDistribuicao.getRazaoSocial() != null && !CentroDistribuicao.getRazaoSocial().equals("")) {
			oldCentroDistribuicao.setRazaoSocial(CentroDistribuicao.getRazaoSocial());
		}
		if (CentroDistribuicao.getNomeFantasia() != null && !CentroDistribuicao.getNomeFantasia().equals("")) {
			oldCentroDistribuicao.setNomeFantasia(CentroDistribuicao.getNomeFantasia());
		}
		repository.save(oldCentroDistribuicao);
	}

	public void desativarCD(Integer id)
			throws CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {
		Optional<CentroDistribuicao> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new CentroDistribuicaoNotFoundException();
		}
		if (!optional.get().isAtivo()) {
			throw new CentroDistribuicaoDesativadoException();
		}
		CentroDistribuicao cd = optional.get();
		cd.setAtivo(false);
		repository.save(cd);
	}

	public void ativarCD(Integer id) throws CentroDistribuicaoNotFoundException, CentroDistribuicaoAtivadoException {
		Optional<CentroDistribuicao> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new CentroDistribuicaoNotFoundException();
		}
		if (optional.get().isAtivo()) {
			throw new CentroDistribuicaoAtivadoException();
		}
		CentroDistribuicao cd = optional.get();
		cd.setAtivo(true);
		repository.save(cd);
	}

	public CentroDistribuicao getCdByDTO(CentroDistribuicaoDTO dto) {
		CentroDistribuicao cd = new CentroDistribuicao();
		cd.setAtivo(dto.isAtivo());
		cd.setCnpj(dto.getCnpj());
		cd.setIdCentroDistribuicao(dto.getIdCentroDistribuicao());
		cd.setNomeFantasia(dto.getNomeFantasia());
		cd.setRazaoSocial(dto.getRazaoSocial());
		cd.setEndereco(service.getEnderecoByDto(dto.getEndereco()));
		return cd;
	}

	public CentroDistribuicaoDTO getDTOByCd(CentroDistribuicao dto) {
		CentroDistribuicaoDTO cd = new CentroDistribuicaoDTO();
		cd.setAtivo(dto.isAtivo());
		cd.setCnpj(dto.getCnpj());
		cd.setIdCentroDistribuicao(dto.getIdCentroDistribuicao());
		cd.setNomeFantasia(dto.getNomeFantasia());
		cd.setRazaoSocial(dto.getRazaoSocial());
		cd.setEndereco(service.getDtoByEndereco(dto.getEndereco()));
		return cd;
	}

	public void verificarCentroDistribuicao(String cnpj) throws CentroDistribuicaoExistenteException {
		Optional<CentroDistribuicao> optional = repository.findByCnpj(cnpj);
		if (optional.isPresent()) {
			throw new CentroDistribuicaoExistenteException();
		}
	}

}
