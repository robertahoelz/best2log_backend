package com.best2log.best2log.restclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.best2log.best2log.model.dto.ViaCepDTO;

@Component
public class RestViaCep {
	public ViaCepDTO getViaCep(String cep) {
		String url = "https://viacep.com.br/ws/" + cep + "/json/";

		RestTemplate rest = new RestTemplate();
		ViaCepDTO enderecoRetornado = rest.getForObject(url, ViaCepDTO.class);
		return enderecoRetornado;

	}

}
