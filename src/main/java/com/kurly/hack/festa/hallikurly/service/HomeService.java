package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.KurlyBagEntity;
import com.kurly.hack.festa.hallikurly.dto.KurlyBagDto;
import com.kurly.hack.festa.hallikurly.repository.KurlyBagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HomeService implements IHomeService{

    private final RestTemplateService restTemplateService;
    private final KurlyBagRepository kurlyBagRepository;

    @Override
    public ResponseEntity<?> homeAccess(long userId) {
        //1.  s -> ml 컬리백 데이터 요청
        List<KurlyBagDto> MLReponseKurlyBagList = restTemplateService.kurlyBagInfoReqToMLServer(userId);

        //2. 응답받은 컬리백 데이터 DB 적재
        List<KurlyBagEntity> kurlyBagEntityList = new ArrayList<>();
        for (int i = 0; i < MLReponseKurlyBagList.size(); i++) {
            kurlyBagEntityList.add(KurlyBagEntity
                    .builder()
                    .userId(userId)
                    .productNo(MLReponseKurlyBagList.get(i).getProductNo())
                    .productNm(MLReponseKurlyBagList.get(i).getProductNm())
                    .price(MLReponseKurlyBagList.get(i).getPrice())
                    .productImgPath(MLReponseKurlyBagList.get(i).getProductImgPath())
                    .build());
        }

        kurlyBagRepository.saveAll(kurlyBagEntityList);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
