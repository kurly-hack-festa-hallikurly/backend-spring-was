package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.OrderEntity;
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
public class HomeService implements IHomeService{


    @Override
    public ResponseEntity<?> homeAccess() {
        //1.  s -> ml 컬리백 데이터 요청
        //2. 응답받은 컬리백 데이터 DB 적재
        return null;
    }
}
