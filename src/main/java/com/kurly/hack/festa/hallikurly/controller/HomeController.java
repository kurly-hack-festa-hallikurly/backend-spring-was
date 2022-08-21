package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.service.IProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home")
@RequiredArgsConstructor
@RestController
public class HomeController {

    private final IProductService iProductService;

    //1. S -> ML -> S -> DB 컬리백 데이터 담아두기
    @ApiOperation(value = "초기 값 요청", notes = "처음 접속 시 user_id를 보내  S -> ML -> S -> DB 순으로 컬리백 데이터를 담아둔다.")
    @GetMapping
    private ResponseEntity<?> SavekurlyBagInfo(
            @RequestParam(name ="user_id", required = true) long userId
    ){
        return iProductService.getAllProductInfo();
    }

    @ApiOperation(value = "상품 전체 조회", notes = "컬리 메인 홈페이지의 데이터를 가지고 올 때 사용한다.")
    @GetMapping("/product")
    private ResponseEntity<?> getAllProductInfo(){
        return iProductService.getAllProductInfo();
    }

}
