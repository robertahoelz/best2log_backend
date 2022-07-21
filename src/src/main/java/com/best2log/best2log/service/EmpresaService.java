package com.best2log.best2log.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.best2log.best2log.exception.EmpresaAtivadaException;
import com.best2log.best2log.exception.EmpresaDesativadaException;
import com.best2log.best2log.exception.EmpresaNotFoundException;
import com.best2log.best2log.model.Empresa;
import com.best2log.best2log.model.dto.EmpresaDTO;
import com.best2log.best2log.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository repository;

	@Autowired
	EnderecoService service;

	public List<EmpresaDTO> getAll(String data) {
		List<Empresa> lista = repository.findAll();
		List<EmpresaDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Empresa cd : lista) {
				if (cd.isAtivo()) {
					EmpresaDTO dto = new EmpresaDTO();
					dto.setCnpj(cd.getCnpj());
					dto.setRazaoSocial(cd.getRazaoSocial());
					dto.setNomeFantasia(cd.getNomeFantasia());
					dto.setIdEmpresa(cd.getIdEmpresa());
					dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
					dto.setDataCadastro(cd.getDataCadastro());
					dto.setAtivo(cd.isAtivo());
					listaDTO.add(dto);
				}
			}
			return listaDTO;
		} else {
			Sort sort = Sort.by(data);
			lista = repository.findAll(sort);
		}
		for (Empresa cd : lista) {
			if (cd.isAtivo()) {
				EmpresaDTO dto = new EmpresaDTO();
				dto.setCnpj(cd.getCnpj());
				dto.setRazaoSocial(cd.getRazaoSocial());
				dto.setNomeFantasia(cd.getNomeFantasia());
				dto.setIdEmpresa(cd.getIdEmpresa());
				dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
				dto.setDataCadastro(cd.getDataCadastro());
				dto.setAtivo(cd.isAtivo());
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	public List<EmpresaDTO> getAllInverted(String data) {
		List<Empresa> lista = repository.findAll();
		List<EmpresaDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Empresa cd : lista) {
				if (cd.isAtivo()) {
					EmpresaDTO dto = new EmpresaDTO();
					dto.setCnpj(cd.getCnpj());
					dto.setRazaoSocial(cd.getRazaoSocial());
					dto.setNomeFantasia(cd.getNomeFantasia());
					dto.setIdEmpresa(cd.getIdEmpresa());
					dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
					dto.setDataCadastro(cd.getDataCadastro());
					dto.setAtivo(cd.isAtivo());
					listaDTO.add(dto);
				}
			}
			return listaDTO;
		} else {
			Sort sort = Sort.by(data.toString()).descending();
			lista = repository.findAll(sort);
		}
		for (Empresa cd : lista) {
			if (cd.isAtivo()) {
				EmpresaDTO dto = new EmpresaDTO();
				dto.setCnpj(cd.getCnpj());
				dto.setRazaoSocial(cd.getRazaoSocial());
				dto.setNomeFantasia(cd.getNomeFantasia());
				dto.setIdEmpresa(cd.getIdEmpresa());
				dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
				dto.setDataCadastro(cd.getDataCadastro());
				dto.setAtivo(cd.isAtivo());
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	public List<EmpresaDTO> getAllInativo(String data) {
		List<Empresa> lista = repository.findAll();
		List<EmpresaDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Empresa cd : lista) {
				if (!cd.isAtivo()) {
					EmpresaDTO dto = new EmpresaDTO();
					dto.setCnpj(cd.getCnpj());
					dto.setRazaoSocial(cd.getRazaoSocial());
					dto.setNomeFantasia(cd.getNomeFantasia());
					dto.setIdEmpresa(cd.getIdEmpresa());
					dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
					dto.setDataCadastro(cd.getDataCadastro());
					dto.setAtivo(cd.isAtivo());
					listaDTO.add(dto);
				}
			}

			return listaDTO;
		} else {
			Sort sort = Sort.by(data);
			lista = repository.findAll(sort);
			listaDTO = new ArrayList<>();
			for (Empresa cd : lista) {
				if (!cd.isAtivo()) {
					EmpresaDTO dto = new EmpresaDTO();
					dto.setCnpj(cd.getCnpj());
					dto.setRazaoSocial(cd.getRazaoSocial());
					dto.setNomeFantasia(cd.getNomeFantasia());
					dto.setIdEmpresa(cd.getIdEmpresa());
					dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
					dto.setDataCadastro(cd.getDataCadastro());
					dto.setAtivo(cd.isAtivo());
					listaDTO.add(dto);
				}
			}
		}
		return listaDTO;
	}

	public List<EmpresaDTO> getAllInativosInverted(String data) {
		List<Empresa> lista = repository.findAll();
		List<EmpresaDTO> listaDTO = new ArrayList<>();
		if (data == null) {
			for (Empresa cd : lista) {
				if (!cd.isAtivo()) {
					EmpresaDTO dto = new EmpresaDTO();
					dto.setCnpj(cd.getCnpj());
					dto.setRazaoSocial(cd.getRazaoSocial());
					dto.setNomeFantasia(cd.getNomeFantasia());
					dto.setIdEmpresa(cd.getIdEmpresa());
					dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
					dto.setDataCadastro(cd.getDataCadastro());
					dto.setAtivo(cd.isAtivo());
					listaDTO.add(dto);
				}

			}
			return listaDTO;
		} else {
			Sort sort = Sort.by(data.toString()).descending();
			lista = repository.findAll(sort);
		}
		for (Empresa cd : lista) {
			if (!cd.isAtivo()) {
				EmpresaDTO dto = new EmpresaDTO();
				dto.setCnpj(cd.getCnpj());
				dto.setRazaoSocial(cd.getRazaoSocial());
				dto.setNomeFantasia(cd.getNomeFantasia());
				dto.setIdEmpresa(cd.getIdEmpresa());
				dto.setEndereco(service.getDtoByEndereco(cd.getEndereco()));
				dto.setDataCadastro(cd.getDataCadastro());
				dto.setAtivo(cd.isAtivo());
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	public EmpresaDTO getOne(Integer id) throws EmpresaNotFoundException, EmpresaDesativadaException {
		Optional<Empresa> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new EmpresaNotFoundException();
		}

		Empresa empresa = optional.get();
		EmpresaDTO newEmpresaDTO = new EmpresaDTO();
		newEmpresaDTO.setCnpj(empresa.getCnpj());
		newEmpresaDTO.setRazaoSocial(empresa.getRazaoSocial());
		newEmpresaDTO.setNomeFantasia(empresa.getNomeFantasia());
		newEmpresaDTO.setIdEmpresa(empresa.getIdEmpresa());
		newEmpresaDTO.setDataCadastro(empresa.getDataCadastro());
		newEmpresaDTO.setEndereco(service.getDtoByEndereco(empresa.getEndereco()));
		newEmpresaDTO.setAtivo(empresa.isAtivo());
		return newEmpresaDTO;
	}

	public EmpresaDTO getOneByNomeFantasia(String nome) throws EmpresaNotFoundException, EmpresaDesativadaException {
		Optional<Empresa> optional = repository.findByNomeFantasia(nome);
		if (optional.isEmpty()) {
			throw new EmpresaNotFoundException();
		}

		Empresa empresa = optional.get();
		if (!empresa.isAtivo()) {
			throw new EmpresaDesativadaException();
		}
		EmpresaDTO newEmpresaDTO = new EmpresaDTO();
		newEmpresaDTO.setCnpj(empresa.getCnpj());
		newEmpresaDTO.setRazaoSocial(empresa.getRazaoSocial());
		newEmpresaDTO.setNomeFantasia(empresa.getNomeFantasia());
		newEmpresaDTO.setIdEmpresa(empresa.getIdEmpresa());
		newEmpresaDTO.setDataCadastro(empresa.getDataCadastro());
		newEmpresaDTO.setEndereco(service.getDtoByEndereco(empresa.getEndereco()));
		newEmpresaDTO.setAtivo(empresa.isAtivo());
		return newEmpresaDTO;
	}

	public List<EmpresaDTO> getAllByData(LocalDate data) throws EmpresaNotFoundException {
		List<Empresa> lista = repository.findByDataCadastroAndAtivo(data, true);
		List<EmpresaDTO> listaDTO = new ArrayList<>();
		for (Empresa empresaLista : lista) {
			if (empresaLista.isAtivo()) {
				Empresa empresa = empresaLista;
				EmpresaDTO newEmpresaDTO = new EmpresaDTO();
				newEmpresaDTO.setCnpj(empresa.getCnpj());
				newEmpresaDTO.setRazaoSocial(empresa.getRazaoSocial());
				newEmpresaDTO.setNomeFantasia(empresa.getNomeFantasia());
				newEmpresaDTO.setDataCadastro(data);
				newEmpresaDTO.setIdEmpresa(empresa.getIdEmpresa());
				newEmpresaDTO.setEndereco(service.getDtoByEndereco(empresa.getEndereco()));
				newEmpresaDTO.setAtivo(empresa.isAtivo());
				listaDTO.add(newEmpresaDTO);
			}
		}
		return listaDTO;
	}

	public void post(EmpresaDTO dto) {
		Empresa empresa = new Empresa();
		empresa.setAtivo(true);
		empresa.setCnpj(dto.getCnpj());
		empresa.setNomeFantasia(dto.getNomeFantasia());
		empresa.setRazaoSocial(dto.getRazaoSocial());
		empresa.setDataCadastro(LocalDate.now());
		empresa.setEndereco(service.getEnderecoByDto(dto.getEndereco()));
		service.addEndereco(empresa.getEndereco());
		repository.save(empresa);
		empresa.getEndereco().setEmpresa(empresa);
		repository.save(empresa);
	}

	public void update(Integer id, EmpresaDTO dto) throws EmpresaNotFoundException {
		Optional<Empresa> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new EmpresaNotFoundException();
		}
		Empresa oldEmpresa = optional.get();
		if (dto.getCnpj() != null && !dto.getCnpj().equals("")) {
			oldEmpresa.setCnpj(dto.getCnpj());
		}
		if (dto.getRazaoSocial() != null && !dto.getRazaoSocial().equals("")) {
			oldEmpresa.setRazaoSocial(dto.getRazaoSocial());
		}
		if (dto.getNomeFantasia() != null && !dto.getNomeFantasia().equals("")) {
			oldEmpresa.setNomeFantasia(dto.getNomeFantasia());
		}
		repository.save(oldEmpresa);
	}

	public void desativarEmpresa(Integer id) throws EmpresaNotFoundException, EmpresaDesativadaException {
		Optional<Empresa> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new EmpresaNotFoundException();
		}

		Empresa empresa = optional.get();
		if (!empresa.isAtivo()) {
			throw new EmpresaDesativadaException();
		}
		empresa.setAtivo(false);
		repository.save(empresa);
	}

	public void ativarEmpresa(Integer id) throws EmpresaNotFoundException, EmpresaAtivadaException {
		Optional<Empresa> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new EmpresaNotFoundException();
		}

		Empresa empresa = optional.get();
		if (empresa.isAtivo()) {
			throw new EmpresaAtivadaException();
		}
		empresa.setAtivo(true);
		repository.save(empresa);
	}

	public Empresa getEmpresaByDTO(EmpresaDTO dto) {
		Empresa empresa = new Empresa();
		empresa.setAtivo(dto.isAtivo());
		empresa.setCnpj(dto.getCnpj());
		empresa.setDataCadastro(dto.getDataCadastro());
		empresa.setIdEmpresa(dto.getIdEmpresa());
		empresa.setNomeFantasia(dto.getNomeFantasia());
		empresa.setRazaoSocial(dto.getRazaoSocial());
		empresa.setEndereco(service.getEnderecoByDto(dto.getEndereco()));
		return empresa;
	}

	public EmpresaDTO getDTObyEmpresa(Empresa dto) {
		EmpresaDTO empresa = new EmpresaDTO();
		empresa.setAtivo(dto.isAtivo());
		empresa.setCnpj(dto.getCnpj());
		empresa.setDataCadastro(dto.getDataCadastro());
		empresa.setIdEmpresa(dto.getIdEmpresa());
		empresa.setNomeFantasia(dto.getNomeFantasia());
		empresa.setRazaoSocial(dto.getRazaoSocial());
		empresa.setEndereco(service.getDtoByEndereco(dto.getEndereco()));
		return empresa;
	}
}
