package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import com.kurly.hack.festa.hallikurly.domain.ShopBasketEntity;
import com.kurly.hack.festa.hallikurly.dto.ProductDto;
import com.kurly.hack.festa.hallikurly.dto.ShopBasketDto;
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

    private final RestTemplateService restTemplateService;
    private final ShopBasketRepository shopBasketRepository;
    private final EntityManager entityManager;

    @Override
    public ResponseEntity<?> getShoppingBasketInfo(long userId) {
        List<ShopBasketDto> shopBasketDtoList = shopBasketEntityToDto(userId);

        if (ObjectUtils.isEmpty(shopBasketDtoList)) {
            return ResponseEntity.ok("해당 ID의 장바구니 데이터가 존재하지 않습니다.");
        }

        return ResponseEntity.ok(shopBasketDtoList);
    }

    @Override
    public ResponseEntity<?> getKurlyBagInfo(long userId) {
//        List<KurlyBagDto> MLReponseValue = restTemplateService.kurlyBagInfoReqToMLServer(userId);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> createShopBasketInfo(ShopBasketDto shopBasketDto) {
        //이미 등록한 장바구니인지 체크로직 필요함. 화요일날 구현할것.

        ShopBasketEntity shopBasketEntity = ShopBasketEntity
                .builder()
                .userId(shopBasketDto.getUserId())
                .productNo(shopBasketDto.getProductNo())
                .productCnt(1)
                .build();

        shopBasketRepository.save(shopBasketEntity);

        return ResponseEntity.ok("생성 완료");
    }

    @Override
    public ResponseEntity<?> updateShopBasketInfo(ShopBasketDto shopBasketDto) {
        // 수정 native query로 만들기 or mybatis로 만들기
        shopBasketRepository.updateShopBasketInfo(
                 shopBasketDto.getUserId()
                ,shopBasketDto.getProductNo()
                ,shopBasketDto.getProductCnt());
        return ResponseEntity.ok("수정 완료");
    }

    @Override
    public ResponseEntity<?> deleteShopBasketInfo(long userId, long productNo) {
        // 삭제 native query로 만들기 or mybatis로 만들기
        shopBasketRepository.deleteShopBasketInfo(userId, productNo);
        return ResponseEntity.ok("삭제 완료");
    }


    public List<ShopBasketDto> shopBasketEntityToDto(long userId) {

        List<ShopBasketEntity> shopBasketEntity
                = shopBasketRepository.findByUserId(userId);


//        String sql =
//                "select tbs.USER_ID as userId, tbp.product_no as productNo, tbp.PRODUCT_NM as productNm, tbs.CNT as cnt from tb_product tbp\n" +
//                        "left join tb_shop_basket tbs on tbp.product_no = tbs.PRODUCT_NO\n" +
//                        "where user_id =" + userId;
//
//        Query query = entityManager.createNativeQuery(sql);
//
//        JpaResultMapper jpaResultMapper = new JpaResultMapper();
//        List<ShopBasketDto> shopBasketDto = jpaResultMapper
//                .list(query, ShopBasketDto.class);
//
        List<ShopBasketDto> shopBasketDtoList = new ArrayList<>();
        for(int i=0; i< shopBasketEntity.size(); i++) {
            shopBasketDtoList.add(
                    ShopBasketDto
                            .builder()
                            .userId(shopBasketEntity.get(i).getUserId())
                            .productNo(shopBasketEntity.get(i).getProductNo())
                            .productCnt(shopBasketEntity.get(i).getProductCnt())
                            .build());
        }

        return shopBasketDtoList;
    }
}
