package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.dto.KurlyBagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class KurlyBagService implements IKurlyBagService{

    private final RestTemplateService restTemplateService;

    @Override
    public ResponseEntity<?> getShoppingBasketInfo(long userId) {

        return null;
    }

    @Override
    public ResponseEntity<?> getKurlyBagInfo(long userId) {
        List<KurlyBagDto> MLReponseValue = restTemplateService.kurlyBagInfoReqToMLServer(userId);

        return ResponseEntity.ok(MLReponseValue);

    }

}
