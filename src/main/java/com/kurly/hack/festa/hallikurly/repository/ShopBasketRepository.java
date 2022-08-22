package com.kurly.hack.festa.hallikurly.repository;

import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import com.kurly.hack.festa.hallikurly.domain.ShopBasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopBasketRepository extends JpaRepository<ShopBasketEntity, Long> {
}
