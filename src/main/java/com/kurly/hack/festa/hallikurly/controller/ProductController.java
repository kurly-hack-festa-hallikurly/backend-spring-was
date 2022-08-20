package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.service.IProductService;
import com.kurly.hack.festa.hallikurly.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final IProductService iProductService;

    @ApiOperation(value = "상품 전체 조회", notes = "컬리 메인 홈페이지의 데이터를 가지고 올 때 사용한다.")
    @GetMapping
    private ResponseEntity<?> getAllProductInfo(){
        return iProductService.getAllProductInfo();
    }

}
