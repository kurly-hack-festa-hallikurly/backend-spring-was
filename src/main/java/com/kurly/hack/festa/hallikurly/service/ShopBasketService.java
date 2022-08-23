package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.KurlyBagEntity;
import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import com.kurly.hack.festa.hallikurly.domain.ShopBasketEntity;
import com.kurly.hack.festa.hallikurly.dto.KurlyBagDto;
import com.kurly.hack.festa.hallikurly.dto.ProductDto;
import com.kurly.hack.festa.hallikurly.dto.ShopBasketDto;
import com.kurly.hack.festa.hallikurly.repository.KurlyBagRepository;
import com.kurly.hack.festa.hallikurly.repository.ShopBasketRepository;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShopBasketService implements IShopBasketService {

    private final ShopBasketRepository shopBasketRepository;
    private final KurlyBagRepository kurlyBagRepository;

    @Override
    public ResponseEntity<?> getShoppingBasketInfo(long userId) {
        List<ShopBasketDto> shopBasketDtoList = shopBasketEntityToDto(userId);

        if (ObjectUtils.isEmpty(shopBasketDtoList)) {
            return ResponseEntity.ok("요청 ID의 장바구니 데이터가 존재하지 않습니다.");
        }

        return ResponseEntity.ok(shopBasketDtoList);
    }

    @Override
    public ResponseEntity<?> createShopBasketInfo(ShopBasketDto shopBasketDto) {
        //이미 등록한 장바구니인지 체크로직 필요함. 화요일날 구현할것.

        ShopBasketEntity shopBasketexistCheckEntity = shopBasketRepository.findByUserIdAndProductNo(
                shopBasketDto.getUserId(), shopBasketDto.getProductNo()
        );

        if (!ObjectUtils.isEmpty(shopBasketexistCheckEntity)) {
            return ResponseEntity.ok("해당 상품이 이미 장바구니에 있습니다.");
        }

        ShopBasketEntity shopBasketEntity = ShopBasketEntity
                .builder()
                .userId(shopBasketDto.getUserId())
                .productNo(shopBasketDto.getProductNo())
                .productNm(shopBasketDto.getProductNm())
                .productCnt(1)
                .build();

        shopBasketRepository.save(shopBasketEntity);

        return ResponseEntity.ok("생성 완료");
    }

    @Override
    public ResponseEntity<?> updateShopBasketInfo(ShopBasketDto shopBasketDto) {
        shopBasketRepository.updateShopBasketInfo(
                 shopBasketDto.getUserId()
                ,shopBasketDto.getProductNo()
                ,shopBasketDto.getProductCnt());
        return ResponseEntity.ok("수정 완료");
    }

    @Override
    public ResponseEntity<?> deleteShopBasketInfo(long userId, long productNo) {
        shopBasketRepository.deleteShopBasketInfo(userId, productNo);
        return ResponseEntity.ok("삭제 완료");
    }

    public List<ShopBasketDto> shopBasketEntityToDto(long userId) {

        List<ShopBasketEntity> shopBasketEntity
                = shopBasketRepository.findByUserId(userId);

        if(shopBasketEntity == null)
            return null;

        List<ShopBasketDto> shopBasketDtoList = new ArrayList<>();
        for(int i=0; i< shopBasketEntity.size(); i++) {
            shopBasketDtoList.add(
                    ShopBasketDto
                            .builder()
                            .userId(shopBasketEntity.get(i).getUserId())
                            .productNo(shopBasketEntity.get(i).getProductNo())
                            .productNm(shopBasketEntity.get(i).getProductNm())
                            .productCnt(shopBasketEntity.get(i).getProductCnt())
                            .build());
        }

        return shopBasketDtoList;
    }

    @Override
    public ResponseEntity<?> getKurlyBagInfo(long userId) {
        List<KurlyBagDto> kurlyBagDtoList = kurlyBagEntityToDto(userId);

        if (ObjectUtils.isEmpty(kurlyBagDtoList)) {
            return ResponseEntity.ok("요청 ID의 컬리백 데이터가 존재하지 않습니다.");
        }

        return ResponseEntity.ok(kurlyBagDtoList);
    }

    @Override
    public ResponseEntity<?> updateKurlyBagInfo(KurlyBagDto kurlyBagDto) {

        KurlyBagEntity kurlyBagEntityList
                = kurlyBagRepository.findByUserIdAndProductNo(
                        kurlyBagDto.getUserId(), kurlyBagDto.getProductNo());

        if (ObjectUtils.isEmpty(kurlyBagEntityList)) {
            return ResponseEntity.ok("요청 ID의 컬리백 데이터가 존재하지 않습니다.");
        }

        kurlyBagRepository.updateKurlyBagInfo(
                kurlyBagDto.getUserId()
                ,kurlyBagDto.getProductNo()
                ,kurlyBagDto.getProductCnt());

        return ResponseEntity.ok("수정 완료");
    }

    @Override
    public ResponseEntity<?> deleteKurlyBagInfo(long userId, long productNo) {

        KurlyBagEntity kurlyBagEntity
                = kurlyBagRepository.findByUserIdAndProductNo(userId, productNo);

        if (ObjectUtils.isEmpty(kurlyBagEntity)) {
            return ResponseEntity.ok("요청 ID의 컬리백 데이터가 존재하지 않습니다.");
        }

        kurlyBagRepository.deleteKurlyBagInfo(userId, productNo);
        return ResponseEntity.ok("삭제 완료");
    }

    public List<KurlyBagDto> kurlyBagEntityToDto(long userId) {

        List<KurlyBagEntity> kurlyBagEntityList
                = kurlyBagRepository.findByUserId(userId);

        if(kurlyBagEntityList == null)
            return null;

        List<KurlyBagDto> kurlyBagDtoList = new ArrayList<>();
        for(int i=0; i< kurlyBagEntityList.size(); i++) {
            kurlyBagDtoList.add(
                    KurlyBagDto
                            .builder()
                            .userId(kurlyBagEntityList.get(i).getUserId())
                            .productNo(kurlyBagEntityList.get(i).getProductNo())
                            .productNm(kurlyBagEntityList.get(i).getProductNm())
                            .productCnt(kurlyBagEntityList.get(i).getProductCnt())
                            .price(kurlyBagEntityList.get(i).getPrice())
                            .productImgPath(kurlyBagEntityList.get(i).getProductImgPath())
                            .build());
        }

        return kurlyBagDtoList;
    }
}
