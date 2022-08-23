package com.kurly.hack.festa.hallikurly.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kurly.hack.festa.hallikurly.domain.OrderEntity;
import com.kurly.hack.festa.hallikurly.dto.*;
import com.kurly.hack.festa.hallikurly.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
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

	private final OrderRepository orderRepository;
	private final ProductService productService;

	public List<KurlyBagDto> kurlyBagInfoReqToMLServer(long userId) {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:5000")
				.path("/predict")
				.encode()
				.build()
				.toUri();

		List<OrderEntity> orderEntity = orderRepository.findTop12ByOrderByCreatedDtmDesc(userId);

		if (ObjectUtils.isEmpty(orderEntity))
			return null;

		List<Long> productNoList = new ArrayList<>();
		List<Integer> orderDowList = new ArrayList<>();
		List<Integer> orderHourOfDayList = new ArrayList<>();
		for (int i = 0; i < orderEntity.size(); i++) {
			productNoList.add(orderEntity.get(i).getProductNo());
			orderDowList.add(orderEntity.get(i).getOrderDow());
			orderHourOfDayList.add(orderEntity.get(i).getOrderHourOfDay());
		}

		KurlyBagInfoRequestDto kurlyBagInfoRequestDto = KurlyBagInfoRequestDto
					.builder()
					.userId(userId)
					.productNo(productNoList)
					.orderDow(orderDowList)
					.orderHourOfDay(orderHourOfDayList)
					.build();

		System.out.println(kurlyBagInfoRequestDto);

		String jsonStr = "";
		try{
			jsonStr = restTemplate.postForObject(uri, kurlyBagInfoRequestDto, String.class);
		}catch (Exception ex){
			System.err.println(ex.toString());
		}

		Gson gson = new Gson();
		List<KurlyBagDto> kurlyBagDtoList = gson.fromJson(jsonStr, new TypeToken<List<KurlyBagDto>>(){}.getType());

		return kurlyBagDtoList;
	}

	//매일 매시 정각 한번 실행
	public void stockSyncToMLServer() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:5000")
				.path("/stocks")
				.encode()
				.build()
				.toUri();


		List<Long> productNoList = new ArrayList<>();

		List<ProductDto> productDtoList = productService.soldOutProductEntityToDto();

		for (int i = 0; i < productDtoList.size(); i++) {
			productNoList.add(productDtoList.get(i).getProductNo());
		}

		SoldOutProductInfoDto stockDto =
				SoldOutProductInfoDto
						.builder()
						.productNo(productNoList)
						.build();

		String jsonStr = "";
//		try{
//			jsonStr = restTemplate.postForObject(uri, stockDto, String.class);
//		}catch (Exception ex){
//			System.err.println(ex.toString());
//		}
	}

	//5분마다 판매완료 된 재고 ML 서버로 송신
	public void soldOutProductInfoToMLServer() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:5000")
				.path("/products/soldout")
				.encode()
				.build()
				.toUri();

//		List<ProductDto> productDtoList = productService.soldOutProductEntityToDto();

//
//		SoldOutProductInfoDto stockDto =
//				SoldOutProductInfoDto
//						.builder()
//						.productNo(1)
//						.dateDiff(2)
//						.build();

//		try{
//			String jsonStr = restTemplate.postForObject(uri, stockDto, String.class);
//		}catch (Exception ex){
//			System.err.println(ex.toString());
//		}
	}
}