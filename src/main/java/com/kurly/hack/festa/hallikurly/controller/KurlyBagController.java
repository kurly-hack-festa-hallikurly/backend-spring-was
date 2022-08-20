package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.service.IKurlyBagService;
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

    @GetMapping
    private ResponseEntity<?> getKurlyBagInfo(
            @RequestParam(name ="user_id", required = true) long userId){
        return iKurlyBagService.getKurlyBagInfo(userId);
    }
}
