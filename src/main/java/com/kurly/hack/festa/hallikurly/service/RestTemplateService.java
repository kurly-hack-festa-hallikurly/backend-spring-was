package com.kurly.hack.festa.hallikurly.service;

import java.net.URI;
import java.util.List;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kurly.hack.festa.hallikurly.dto.KurlyBagDto;
import com.kurly.hack.festa.hallikurly.dto.StockDto;
import com.kurly.hack.festa.hallikurly.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RestTemplateService {

	@Autowired
	private RestTemplate restTemplate;


	public List<KurlyBagDto> kurlyBagInfoReqToMLServer(long userId) {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8090")
				.path("/kurlyBag")
				.encode()
				.build()
				.toUri();

		UserRequestDto userRequestDto =
						UserRequestDto
								.builder()
								.userId(userId)
								.build();

		String jsonStr = restTemplate.postForObject(uri, userRequestDto, String.class);

		Gson gson = new Gson();
		List<KurlyBagDto> kurlyBagDtoList = gson.fromJson(jsonStr, new TypeToken<List<KurlyBagDto>>(){}.getType());

		return kurlyBagDtoList;
	}

	//매일 매시 정각 한번 실행
	public void stockSyncToMLServer() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8090")
				.path("/stock/synchroniztion")
				.encode()
				.build()
				.toUri();

		StockDto stockDto =
				StockDto
						.builder()
						.productNo(1)
						.dateDiff(2)
						.build();

		try{
			String jsonStr = restTemplate.postForObject(uri, stockDto, String.class);
		}catch (Exception ex){
			System.err.println(ex.toString());
		}


	}
}