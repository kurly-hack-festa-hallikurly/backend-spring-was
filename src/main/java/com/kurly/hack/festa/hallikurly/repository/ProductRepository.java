package com.kurly.hack.festa.hallikurly.repository;

import com.kurly.hack.festa.hallikurly.domain.OrderEntity;
import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value =
            "select " +
                    "PRODUCT_NO, PRODUCT_NM, PRICE, SOLD_OUT, SHELF_LIFE, PRODUCT_IMG_PATH " +
                    "FROM tb_product " +
                    "WHERE DATEDIFF(SHELF_LIFE,now()) BETWEEN  0 and 4", nativeQuery = true)
    List<ProductEntity> findBySoldOutProductInfo();
}
