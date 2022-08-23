package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import com.kurly.hack.festa.hallikurly.dto.ProductDto;
import com.kurly.hack.festa.hallikurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getAllProductInfo() {
        List<ProductDto> productDtoList = productEntityToDto();

        if (ObjectUtils.isEmpty(productDtoList)) {
            return ResponseEntity.ok("상품 데이터가 없습니다.");
        }

        return ResponseEntity.ok(productDtoList);
    }


    public List<ProductDto> productEntityToDto() {

        List<ProductEntity> productEntityList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();

        for(int i=0; i< productEntityList.size(); i++) {

            productDtoList.add(
                    ProductDto
                            .builder()
                            .productNo(productEntityList.get(i).getProductNo())
                            .productNm(productEntityList.get(i).getProductNm())
                            .price(productEntityList.get(i).getPrice())
                            .productImgPath(productEntityList.get(i).getProductImgPath())
                            .build());
        }

        return productDtoList;
    }

    public List<ProductDto> expirationDtmProductEntityToDto() {

        List<ProductEntity> productEntityList = productRepository.findByExpirationDtmProductInfo();

        List<ProductDto> productDtoList = new ArrayList<>();
        for(int i=0; i< productEntityList.size(); i++) {

            productDtoList.add(
                    ProductDto
                            .builder()
                            .productNo(productEntityList.get(i).getProductNo())
                            .productNm(productEntityList.get(i).getProductNm())
                            .price(productEntityList.get(i).getPrice())
                            .productImgPath(productEntityList.get(i).getProductImgPath())
                            .build());
        }

        return productDtoList;
    }

    public List<ProductDto> soldOutProductEntityToDto() {

        List<ProductEntity> productEntityList = productRepository.findBySoldOutProductInfo();

        List<ProductDto> productDtoList = new ArrayList<>();
        for(int i=0; i< productEntityList.size(); i++) {

            productDtoList.add(
                    ProductDto
                            .builder()
                            .productNo(productEntityList.get(i).getProductNo())
                            .productNm(productEntityList.get(i).getProductNm())
                            .price(productEntityList.get(i).getPrice())
                            .productImgPath(productEntityList.get(i).getProductImgPath())
                            .build());
        }

        return productDtoList;
    }
}
