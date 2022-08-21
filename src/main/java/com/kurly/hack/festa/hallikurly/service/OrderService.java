package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.OrderEntity;
import com.kurly.hack.festa.hallikurly.dto.KurlyBagDto;
import com.kurly.hack.festa.hallikurly.dto.OrderDto;
import com.kurly.hack.festa.hallikurly.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public ResponseEntity<?> order(List<OrderDto> orderDto) {
        List<OrderEntity> orderEntityList = new ArrayList<>();

        for (int i = 0; i< orderDto.size(); i++){
            orderEntityList.add(
                    OrderEntity
                            .builder()
                            .productNo(orderDto.get(i).getProductNo())
                            .userId(orderDto.get(i).getUserId())
                            .build()
            );
        }

        orderRepository.saveAll(orderEntityList);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
