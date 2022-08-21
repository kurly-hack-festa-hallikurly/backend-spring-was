package com.kurly.hack.festa.hallikurly.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IKurlyBagService {
    ResponseEntity<?> getKurlyBagInfo(long userId);

    ResponseEntity<?> getShoppingBasketInfo(long userId);
}
