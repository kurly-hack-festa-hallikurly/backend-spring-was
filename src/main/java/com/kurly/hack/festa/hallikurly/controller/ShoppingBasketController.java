package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.dto.KurlyBagDto;
import com.kurly.hack.festa.hallikurly.dto.ShopBasketDto;
import com.kurly.hack.festa.hallikurly.service.IShopBasketService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/shopping-baskets")
@RestController
public class ShoppingBasketController {

    private final IShopBasketService iShopBasketService;

    @ApiOperation(value = "장바구니 데이터 조회", notes = "장바구니 데이터를 가져온다.")
    @ApiImplicitParam(name = "user_id", value = "유저 ID", required = true, dataType = "int", paramType = "query")
    @GetMapping
    private ResponseEntity<?> getShoppingBasketInfo(
            @RequestParam(name ="user_id", required = true) long userId){
        return iShopBasketService.getShoppingBasketInfo(userId);
    }

    @ApiOperation(value = "장바구니 데이터 생성", notes = "장바구니 데이터를 생성한다.")
    @PostMapping
    private ResponseEntity<?> createShopBasketInfo(
            @RequestBody ShopBasketDto shopBasketDto){
        return iShopBasketService.createShopBasketInfo(shopBasketDto);
    }

    @ApiOperation(value = "장바구니 데이터 수정", notes = "장바구니 데이터를 수정한다.")
    @PutMapping
    private ResponseEntity<?> updateShopBasketInfo(
            @RequestBody ShopBasketDto shopBasketDto){
        return iShopBasketService.updateShopBasketInfo(shopBasketDto);
    }

    @ApiOperation(value = "장바구니 데이터 삭제", notes = "장바구니 데이터를 삭제한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "유저 ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "product_no", value = "상품 번호", required = true, dataType = "int", paramType = "query")
    })
    @DeleteMapping
    private ResponseEntity<?> deleteShopBasketInfo(
            @RequestParam(name ="user_id", required = true) long userId,
            @RequestParam(name ="product_no", required = true) long productNo){
        return iShopBasketService.deleteShopBasketInfo(userId, productNo);
    }

    @ApiOperation(value = "컬리백 데이터 조회", notes = "컬리백 데이터를 C -> S -> ML -> S -> C 순으로 가져온다.")
    @ApiImplicitParam(name = "user_id", value = "유저 ID", required = true, dataType = "int", paramType = "query")
    @GetMapping("/kurly-bag")
    private ResponseEntity<?> getKurlyBagInfo(
            @RequestParam(name ="user_id", required = true) long userId){
        return iShopBasketService.getKurlyBagInfo(userId);
    }

    @ApiOperation(value = "컬리백 데이터 수정", notes = "컬리백 데이터를 수정한다.")
    @PutMapping("/kurly-bag")
    private ResponseEntity<?> updateKurlyBagInfo(
            @RequestBody KurlyBagDto kurlyBagDto){
        return iShopBasketService.updateKurlyBagInfo(kurlyBagDto);
    }

    @ApiOperation(value = "컬리백 데이터 삭제", notes = "컬리백 데이터를 삭제한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "유저 ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "product_no", value = "상품 번호", required = true, dataType = "int", paramType = "query")
    })
    @DeleteMapping("/kurly-bag")
    private ResponseEntity<?> deleteKurlyBagInfo(
            @RequestParam(name ="user_id", required = true) long userId,
            @RequestParam(name ="product_no", required = true) long productNo){
        return iShopBasketService.deleteKurlyBagInfo(userId, productNo);
    }
}
