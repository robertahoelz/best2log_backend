package com.best2log.best2log.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.best2log.best2log.exception.CentroDistribuicaoDesativadoException;
import com.best2log.best2log.exception.CentroDistribuicaoNotFoundException;
import com.best2log.best2log.exception.EmpresaDesativadaException;
import com.best2log.best2log.exception.EmpresaNotFoundException;
import com.best2log.best2log.exception.PacoteNotFoundException;
import com.best2log.best2log.model.CentroDistribuicao;
import com.best2log.best2log.model.Pacote;
import com.best2log.best2log.model.dto.CentroDistribuicaoDTO;
import com.best2log.best2log.model.dto.EmpresaDTO;
import com.best2log.best2log.model.dto.PacoteDTO;
import com.best2log.best2log.repository.PacoteRepository;

@Service
public class PacoteService {

	@Autowired
	PacoteRepository repository;

	@Autowired
	EmpresaService service;

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	CentroDistribuicaoService cdService;

	public List<PacoteDTO> getAll(String data) throws EmpresaDesativadaException, EmpresaNotFoundException {
		List<Pacote> lista = repository.findAll();
		List<PacoteDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Pacote pacote : lista) {
				if (pacote.getEmpresa().isAtivo()) {
					PacoteDTO dto = new PacoteDTO();
					dto.setCep(pacote.getCep());
					dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
					dto.setDataEntrada(pacote.getDataEntrada());
					dto.setIdPacote(pacote.getIdPacote());
					dto.setStatusPacote(pacote.getStatusPacote());
					dto.setCd(cdService.getDTOByCd(pacote.getCd()));
					dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
					listaDTO.add(dto);
				}
			}

			return listaDTO;
		} else {
			Sort sort = Sort.by(data);
			lista = repository.findAll(sort);
		}
		for (Pacote pacote : lista) {
			if (pacote.getEmpresa().isAtivo()) {
				PacoteDTO dto = new PacoteDTO();
				dto.setCep(pacote.getCep());
				dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
				dto.setDataEntrada(pacote.getDataEntrada());
				dto.setIdPacote(pacote.getIdPacote());
				dto.setStatusPacote(pacote.getStatusPacote());
				dto.setCd(cdService.getDTOByCd(pacote.getCd()));
				dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	public List<PacoteDTO> getAllInverted(String data) throws EmpresaDesativadaException, EmpresaNotFoundException {
		List<Pacote> lista = repository.findAll();
		List<PacoteDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Pacote pacote : lista) {
				if (pacote.getEmpresa().isAtivo()) {
					PacoteDTO dto = new PacoteDTO();
					dto.setCep(pacote.getCep());
					dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
					dto.setDataEntrada(pacote.getDataEntrada());
					dto.setIdPacote(pacote.getIdPacote());
					dto.setStatusPacote(pacote.getStatusPacote());
					dto.setCd(cdService.getDTOByCd(pacote.getCd()));
					dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
					listaDTO.add(dto);
				}
			}

			return listaDTO;
		} else {
			Sort sort = Sort.by(data).descending();
			lista = repository.findAll(sort);
		}
		for (Pacote pacote : lista) {
			if (pacote.getEmpresa().isAtivo()) {
				PacoteDTO dto = new PacoteDTO();
				dto.setCep(pacote.getCep());
				dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
				dto.setDataEntrada(pacote.getDataEntrada());
				dto.setIdPacote(pacote.getIdPacote());
				dto.setStatusPacote(pacote.getStatusPacote());
				dto.setCd(cdService.getDTOByCd(pacote.getCd()));
				dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	public List<PacoteDTO> getAllLixeira(String data) throws EmpresaDesativadaException, EmpresaNotFoundException {
		List<Pacote> lista = repository.findAll();
		List<PacoteDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Pacote pacote : lista) {
				if (pacote.getEmpresa().isAtivo()) {
					if (pacote.isLixeira()) {
					PacoteDTO dto = new PacoteDTO();
					dto.setCep(pacote.getCep());
					dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
					dto.setDataEntrada(pacote.getDataEntrada());
					dto.setIdPacote(pacote.getIdPacote());
					dto.setStatusPacote(pacote.getStatusPacote());
					dto.setCd(cdService.getDTOByCd(pacote.getCd()));
					dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
					listaDTO.add(dto);
					}
				}
			}

			return listaDTO;
		} else {
			Sort sort = Sort.by(data);
			lista = repository.findAll(sort);
		}
		for (Pacote pacote : lista) {
			if (pacote.getEmpresa().isAtivo()) {
				if (pacote.isLixeira()) {
					PacoteDTO dto = new PacoteDTO();
					dto.setCep(pacote.getCep());
					dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
					dto.setDataEntrada(pacote.getDataEntrada());
					dto.setIdPacote(pacote.getIdPacote());
					dto.setStatusPacote(pacote.getStatusPacote());
					dto.setCd(cdService.getDTOByCd(pacote.getCd()));
					dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
					listaDTO.add(dto);
				}
			}
		}
		return listaDTO;
	}

	public List<PacoteDTO> getAllInvertedLixeira(String data)
			throws EmpresaDesativadaException, EmpresaNotFoundException {
		List<Pacote> lista = repository.findAll();
		List<PacoteDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Pacote pacote : lista) {
				if (pacote.getEmpresa().isAtivo()) {
					if (pacote.isLixeira()) {
						PacoteDTO dto = new PacoteDTO();
						dto.setCep(pacote.getCep());
						dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
						dto.setDataEntrada(pacote.getDataEntrada());
						dto.setIdPacote(pacote.getIdPacote());
						dto.setStatusPacote(pacote.getStatusPacote());
						dto.setCd(cdService.getDTOByCd(pacote.getCd()));
						dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
						listaDTO.add(dto);
					}
				}
			}

			return listaDTO;
		} else {
			Sort sort = Sort.by(data).descending();
			lista = repository.findAll(sort);
		}
		for (Pacote pacote : lista) {
			if (pacote.getEmpresa().isAtivo()) {
				if (pacote.isLixeira()) {
					PacoteDTO dto = new PacoteDTO();
					dto.setCep(pacote.getCep());
					dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
					dto.setDataEntrada(pacote.getDataEntrada());
					dto.setIdPacote(pacote.getIdPacote());
					dto.setStatusPacote(pacote.getStatusPacote());
					dto.setCd(cdService.getDTOByCd(pacote.getCd()));
					dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
					listaDTO.add(dto);
				}
			}
		}
		return listaDTO;
	}

	public List<PacoteDTO> getAllByEmpresa(String nome) throws EmpresaDesativadaException, EmpresaNotFoundException {
		List<Pacote> lista = repository.findAll();
		List<PacoteDTO> listaDTO = new ArrayList<>();
		for (Pacote Pacote : lista) {
			if (Pacote.getEmpresa().getNomeFantasia().equals(nome)) {
				if(!Pacote.isLixeira()) {
				PacoteDTO dto = new PacoteDTO();
				dto.setCep(Pacote.getCep());
				dto.setDataEntrada(Pacote.getDataEntrada());
				dto.setIdPacote(Pacote.getIdPacote());
				dto.setStatusPacote(Pacote.getStatusPacote());
				dto.setCd(cdService.getDTOByCd(Pacote.getCd()));
				dto.setEmpresa(service.getDTObyEmpresa(Pacote.getEmpresa()));
				dto.setEndereco(enderecoService.getDtoByEndereco(Pacote.getEndereco()));
				listaDTO.add(dto);
				}
			}
		}
		return listaDTO;
	}

	public PacoteDTO getOne(Integer id) throws PacoteNotFoundException, EmpresaDesativadaException {
		Optional<Pacote> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new PacoteNotFoundException();
		}
		Pacote pacote = optional.get();
		if (pacote.getEmpresa().isAtivo()) {
		
			PacoteDTO dto = new PacoteDTO();
			dto.setIdPacote(pacote.getIdPacote());
			dto.setStatusPacote(pacote.getStatusPacote());
			dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
			dto.setCep(pacote.getCep());
			dto.setCd(cdService.getDTOByCd(pacote.getCd()));
			dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
			return dto;
			
		}
		throw new EmpresaDesativadaException();
	}

	public List<PacoteDTO> getAllByCep(String cep) throws PacoteNotFoundException, EmpresaDesativadaException {
		List<Pacote> lista = repository.findByCep(cep);
		List<PacoteDTO> listaDTO = new ArrayList<>();
		if (lista.isEmpty()) {
			throw new PacoteNotFoundException();
		}
		for (Pacote pacote : lista) {
			if (pacote.getEmpresa().isAtivo()) {
				if(!pacote.isLixeira()) {
				PacoteDTO dto = new PacoteDTO();
				dto.setIdPacote(pacote.getIdPacote());
				dto.setStatusPacote(pacote.getStatusPacote());
				dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
				dto.setCd(cdService.getDTOByCd(pacote.getCd()));
				dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
				dto.setCep(pacote.getCep());
				dto.setDataEntrada(pacote.getDataEntrada());
				listaDTO.add(dto);
				}
			}
		}
		return listaDTO;
	}

	public List<PacoteDTO> getAllByData(LocalDate data) throws PacoteNotFoundException, EmpresaDesativadaException {

		List<Pacote> optional = repository.findByDataEntrada(data);
		List<PacoteDTO> listaDto = new ArrayList<>();
		if (optional.isEmpty()) {
			throw new PacoteNotFoundException();
		}
		for (Pacote pacote : optional) {
			if (pacote.getEmpresa().isAtivo()) {
				if(!pacote.isLixeira()) {
				PacoteDTO dto = new PacoteDTO();
				dto.setIdPacote(pacote.getIdPacote());
				dto.setStatusPacote(pacote.getStatusPacote());
				dto.setCd(cdService.getDTOByCd(pacote.getCd()));
				dto.setEmpresa(service.getDTObyEmpresa(pacote.getEmpresa()));
				dto.setEndereco(enderecoService.getDtoByEndereco(pacote.getEndereco()));
				dto.setCep(pacote.getCep());
				dto.setDataEntrada(pacote.getDataEntrada());
				listaDto.add(dto);
				}
			}
		}
		return listaDto;

	}

	public void post(PacoteDTO dto) throws EmpresaNotFoundException, EmpresaDesativadaException,
			CentroDistribuicaoNotFoundException, CentroDistribuicaoDesativadoException {

		EmpresaDTO empresa = service.getOne(dto.getEmpresa().getIdEmpresa());
		CentroDistribuicaoDTO cd = cdService.getOne(dto.getCd().getIdCentroDistribuicao());
		if (empresa != null) {
			Pacote pacote = new Pacote();
			pacote.setCd(cdService.getCdByDTO(cd));
			pacote.setCep(dto.getCep());
			pacote.setDataEntrada(LocalDate.now());
			pacote.setEmpresa(service.getEmpresaByDTO(empresa));
			System.out.println(dto.getEndereco());
			pacote.setEndereco(enderecoService.getEnderecoByDto(dto.getEndereco()));
			pacote.setStatusPacote(dto.getStatusPacote());
			enderecoService.addEndereco(pacote.getEndereco());
			repository.save(pacote);
			if (pacote.getEndereco().getPacotes() == null) {
				pacote.getEndereco().setPacotes(new ArrayList<>());
				pacote.getEndereco().getPacotes().add(pacote);
			} else {
				pacote.getEndereco().getPacotes().add(pacote);
			}
			repository.save(pacote);
		} else {
			throw new EmpresaNotFoundException();
		}
	}

	public void update(Integer id, PacoteDTO Dto) throws PacoteNotFoundException {
		Optional<Pacote> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new PacoteNotFoundException();
		}
		Pacote pacote = optional.get();

		if (Dto.getIdPacote() != null && Dto.getIdPacote() != 0) {
			pacote.setIdPacote(Dto.getIdPacote());
		}
		if (Dto.getCep() != null && !Dto.getCep().equals("")) {
			pacote.setCep(Dto.getCep());
		}
		if (Dto.getDataEntrada() != null) {
			pacote.setDataEntrada(Dto.getDataEntrada());
		}
		if (Dto.getEndereco() != null) {
			pacote.setEndereco(enderecoService.getEnderecoByDto(Dto.getEndereco()));
		}
		if (Dto.getStatusPacote() != null && !Dto.getStatusPacote().equals("")) {
			pacote.setStatusPacote(Dto.getStatusPacote());
		}
		repository.save(pacote);
	}

	public void delete(Integer id) throws PacoteNotFoundException {
		Optional<Pacote> pacote = repository.findById(id);
		if (pacote.isEmpty()) {
			throw new PacoteNotFoundException();
		}
		pacote.get().setLixeira(true);
		repository.save(pacote.get());
	}

	public Pacote findById(Integer id) throws PacoteNotFoundException {
		Optional<Pacote> pacote = repository.findById(id);
		if (pacote.isEmpty()) {
			throw new PacoteNotFoundException();
		}
		return pacote.get();
	}
}