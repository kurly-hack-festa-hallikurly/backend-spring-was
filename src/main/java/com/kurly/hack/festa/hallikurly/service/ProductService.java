package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import com.kurly.hack.festa.hallikurly.dto.ProductDto;
import com.kurly.hack.festa.hallikurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getAllProductInfo() {
        List<ProductDto> productDtoList = productEntityToDto();

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
                            .productImgPath(productEntityList.get(i).getProductImgPath())
                            .build());
        }

        return productDtoList;
    }
}
