package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.dto.OrderDto;
import com.kurly.hack.festa.hallikurly.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
public class OrderController {

    private final IOrderService iOrderService;

    @PostMapping
    private ResponseEntity<?> order(
            @RequestBody List<OrderDto> orderDto
    ){
        return iOrderService.order(orderDto);
    }
}
