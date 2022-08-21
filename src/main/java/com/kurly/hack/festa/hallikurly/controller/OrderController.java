package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.dto.OrderDto;
import com.kurly.hack.festa.hallikurly.service.IOrderService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "상품 주문", notes = "주문할 상품 데이터를 서버에게 보낸다.")
    @PostMapping
    private ResponseEntity<?> order(
            @RequestBody List<OrderDto> orderDto
    ){
        return iOrderService.order(orderDto);
    }
}
