package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.service.IProductService;
import com.kurly.hack.festa.hallikurly.service.ProductService;
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

    @GetMapping
    private ResponseEntity<?> getAllProductInfo(){
        return iProductService.getAllProductInfo();
    }

}
