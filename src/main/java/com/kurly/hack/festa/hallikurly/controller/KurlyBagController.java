package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.service.IKurlyBagService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/kurlybag")
@RestController
public class KurlyBagController {

    private final IKurlyBagService iKurlyBagService;

    @ApiOperation(value = "컬리백 데이터 요청", notes = "컬리백 데이터를 C -> S -> ML -> S -> C 순으로 데이터를 가져온다.")
    @ApiImplicitParam(name = "user_id", value = "유저 ID", required = true, dataType = "int", paramType = "query")
    @GetMapping
    private ResponseEntity<?> getKurlyBagInfo(
            @RequestParam(name ="user_id", required = true) long userId){
        return iKurlyBagService.getKurlyBagInfo(userId);
    }
}
