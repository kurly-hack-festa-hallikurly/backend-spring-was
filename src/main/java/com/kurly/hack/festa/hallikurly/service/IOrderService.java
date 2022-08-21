package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IOrderService {
    ResponseEntity<?> order(List<OrderDto> orderDto);

}
