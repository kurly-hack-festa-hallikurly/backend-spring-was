package com.kurly.hack.festa.hallikurly.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KurlyBagService implements IKurlyBagService{

    private final RestTemplateService restTemplateService;

    @Override
    public ResponseEntity<?> getKurlyBagInfo(long userId) {
        String MLReponseValue = restTemplateService.kurlyBagInfoReqToMLServer(userId);

        return ResponseEntity.ok(MLReponseValue);

    }
}
