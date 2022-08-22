package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.service.IHomeService;
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

    private final IHomeService iHomeService;

    @ApiOperation(value = "초기 값 요청", notes = "처음 접속 시 user_id를 보내  S -> ML -> S -> DB 순으로 컬리백 데이터를 담아둔다.")
    @GetMapping
    private ResponseEntity<?> homeAccess(
            @RequestParam(name ="user_id", required = true) long userId
    ){
        return iHomeService.homeAccess();
    }

}
