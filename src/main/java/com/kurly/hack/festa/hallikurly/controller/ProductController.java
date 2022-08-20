package com.kurly.hack.festa.hallikurly.controller;

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

    private final ProductService productService;

    @GetMapping
    private ResponseEntity<?> getAllProductInfo(){
        return productService.getAllProductInfo();
    }

}
