package com.kurly.hack.festa.hallikurly.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kurly.hack.festa.hallikurly.dto.KurlyBagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RestTemplateService {

	@Autowired
	private RestTemplate restTemplate;

	public String getMLServerKurlyBagInfo(long userId) {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8090")
				.path("/kurlyBag")
				.queryParam("userId","12345")
				.encode()
				.build()
				.toUri();

		String jsonStr = restTemplate.getForObject(uri, String.class);

		Gson gson = new Gson();
		List<KurlyBagDto> kurlyBagDtoList = gson.fromJson(jsonStr, new TypeToken<List<KurlyBagDto>>(){}.getType());

		return jsonStr;
	}
}