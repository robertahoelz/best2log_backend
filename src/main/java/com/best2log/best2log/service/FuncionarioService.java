package com.best2log.best2log.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.best2log.best2log.exception.CodigoVerificacaoNotFoundException;
import com.best2log.best2log.exception.FuncionarioNotFoundException;
import com.best2log.best2log.model.Funcionario;
import com.best2log.best2log.model.dto.FuncionarioDTO;
import com.best2log.best2log.model.dto.RedefinirSenhaDTO;
import com.best2log.best2log.repository.FuncionarioRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository repository;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<FuncionarioDTO> getAll() {
		List<Funcionario> lista = repository.findAll();
		List<FuncionarioDTO> listaDTO = new ArrayList<>();
		for (Funcionario funcionario : lista) {
			FuncionarioDTO dto = new FuncionarioDTO();
			dto.setNome(funcionario.getNome());
			dto.setCpf(funcionario.getCpf());
			dto.setEmail(funcionario.getEmail());
			dto.setDataNascimento(funcionario.getDataNascimento());
			dto.setCelular(funcionario.getCelular());
			dto.setSenha(funcionario.getSenha());
			dto.setCargo(funcionario.getCargo());
			listaDTO.add(dto);
		}
		return listaDTO;
	}

	public FuncionarioDTO getOne(Integer id) throws FuncionarioNotFoundException {
		Optional<Funcionario> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new FuncionarioNotFoundException();
		}

		Funcionario oldFuncionario = optional.get();
		FuncionarioDTO newFuncionarioDTO = new FuncionarioDTO();
		newFuncionarioDTO.setNome(oldFuncionario.getNome());
		newFuncionarioDTO.setCpf(oldFuncionario.getCpf());
		newFuncionarioDTO.setEmail(oldFuncionario.getEmail());
		newFuncionarioDTO.setDataNascimento(oldFuncionario.getDataNascimento());
		newFuncionarioDTO.setCelular(oldFuncionario.getCelular());
		newFuncionarioDTO.setSenha(oldFuncionario.getSenha());
		newFuncionarioDTO.setCargo(oldFuncionario.getCargo());
		newFuncionarioDTO.setIdFuncionario(oldFuncionario.getIdFuncionario());
		return newFuncionarioDTO;
	}

	public void post(FuncionarioDTO dto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setCargo(dto.getCargo());
		funcionario.setCelular(dto.getCelular());
		funcionario.setCpf(dto.getCpf());
		funcionario.setDataNascimento(dto.getDataNascimento());
		funcionario.setEmail(dto.getEmail());
		funcionario.setNome(dto.getNome());
		funcionario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
		repository.save(funcionario);
	}

	public void update(Integer id, FuncionarioDTO Dto) throws FuncionarioNotFoundException {
		Optional<Funcionario> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new FuncionarioNotFoundException();
		}
		Funcionario oldFuncionario = optional.get();
		if (Dto.getNome() != null && !Dto.getNome().equals("")) {
			oldFuncionario.setNome(Dto.getNome());
		}
		if (Dto.getCpf() != null && !Dto.getCpf().equals("")) {
			oldFuncionario.setCpf(Dto.getCpf());
		}
		if (Dto.getDataNascimento() != null && !Dto.getDataNascimento().equals("")) {
			oldFuncionario.setDataNascimento(Dto.getDataNascimento());
		}
		if (Dto.getCelular() != null && !Dto.getCelular().equals("")) {
			oldFuncionario.setCelular(Dto.getCelular());
		}
		repository.save(oldFuncionario);
	}

	public void redefinirSenha(RedefinirSenhaDTO dto)
			throws FuncionarioNotFoundException, CodigoVerificacaoNotFoundException {
		Optional<Funcionario> optional = repository.findByEmail(dto.getEmail());
		if (optional.isEmpty()) {
			throw new FuncionarioNotFoundException();
		}
		Funcionario funcionario = optional.get();
		if (dto.getCodigo().equals(funcionario.getCodigo())) {
			funcionario.setSenha(bCryptPasswordEncoder.encode(dto.getNovaSenha()));
			funcionario.setCodigo(null);
			repository.save(funcionario);
		} else {
			throw new CodigoVerificacaoNotFoundException();
		}

	}

	public void sendCode(String email)
			throws FuncionarioNotFoundException, UnsupportedEncodingException, MessagingException {
		Optional<Funcionario> optional = repository.findByEmail(email);
		if (optional.isEmpty()) {
			throw new FuncionarioNotFoundException();
		}
		Funcionario funcionario = optional.get();
		String codigoRandom = RandomString.make(6);
		funcionario.setCodigo(codigoRandom);
		repository.save(funcionario);
		String subject = "Autorização para Redefinir Senha";
		String senderName = "Best2Log";
		String mailContent = "<p>Prezado(a) " + funcionario.getNome() + ", </p>";
		mailContent += "<p> Segue abaixo o codigo para redefinir sua senha: </p>";
		mailContent += "<h3>" + codigoRandom + "</h3>";
		mailContent += "<p> Atenciosamente<br>Best2Log</p>";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("carlos.pereira8@aluno.senai.com.br", senderName);
		helper.setTo(funcionario.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent, true);
		mailSender.send(message);
	}

	public FuncionarioDTO getOneByCpf(String cpf) throws FuncionarioNotFoundException {
		Optional<Funcionario> optional = repository.findByCpf(cpf);
		if (optional.isEmpty()) {
			throw new FuncionarioNotFoundException();
		}

		Funcionario oldFuncionario = optional.get();
		FuncionarioDTO newFuncionarioDTO = new FuncionarioDTO();
		newFuncionarioDTO.setNome(oldFuncionario.getNome());
		newFuncionarioDTO.setCpf(oldFuncionario.getCpf());
		newFuncionarioDTO.setEmail(oldFuncionario.getEmail());
		newFuncionarioDTO.setDataNascimento(oldFuncionario.getDataNascimento());
		newFuncionarioDTO.setCelular(oldFuncionario.getCelular());
		newFuncionarioDTO.setSenha(oldFuncionario.getSenha());
		newFuncionarioDTO.setCargo(oldFuncionario.getCargo());
		newFuncionarioDTO.setIdFuncionario(oldFuncionario.getIdFuncionario());
		return newFuncionarioDTO;
	}
	public Optional<Funcionario> findByCpf(String cpf){
		return repository.findByCpf(cpf);
	}

	public FuncionarioDTO getOneByEmail(String email) throws FuncionarioNotFoundException {
		Optional<Funcionario> optional = repository.findByEmail(email);
		if (optional.isEmpty()) {
			throw new FuncionarioNotFoundException();
		}

		Funcionario oldFuncionario = optional.get();
		FuncionarioDTO newFuncionarioDTO = new FuncionarioDTO();
		newFuncionarioDTO.setNome(oldFuncionario.getNome());
		newFuncionarioDTO.setCpf(oldFuncionario.getCpf());
		newFuncionarioDTO.setEmail(oldFuncionario.getEmail());
		newFuncionarioDTO.setDataNascimento(oldFuncionario.getDataNascimento());
		newFuncionarioDTO.setCelular(oldFuncionario.getCelular());
		newFuncionarioDTO.setSenha(oldFuncionario.getSenha());
		newFuncionarioDTO.setCargo(oldFuncionario.getCargo());
		newFuncionarioDTO.setIdFuncionario(oldFuncionario.getIdFuncionario());
		return newFuncionarioDTO;
	}

}
