package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.dto.ShopBasketDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IShopBasketService {
    ResponseEntity<?> getShoppingBasketInfo(long userId);
    ResponseEntity<?> getKurlyBagInfo(long userId);
    ResponseEntity<?> createShopBasketInfo(ShopBasketDto shopBasketDto);
    ResponseEntity<?> updateShopBasketInfo(ShopBasketDto shopBasketDto);
    ResponseEntity<?> deleteShopBasketInfo(long userId, long productNo);

}
