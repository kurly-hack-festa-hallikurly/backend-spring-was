package com.kurly.hack.festa.hallikurly.repository;

import com.kurly.hack.festa.hallikurly.domain.KurlyBagEntity;
import com.kurly.hack.festa.hallikurly.domain.OrderEntity;
import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query(value =
            "SELECT " +
                    "ORDER_NO, PRODUCT_NO, USER_ID, ORDER_CNT, CREATED_DTM," +
                    "date_format(CREATED_DTM, '%w' ) as ORDER_DOW, date_format(CREATED_DTM , '%H' ) as ORDER_HOUR_OF_DAY " +
                    "FROM tb_order_history " +
                    "WHERE " +
                    "user_id = :userId " +
                    "ORDER BY CREATED_DTM DESC " +
                    "LIMIT 12 ", nativeQuery = true)
    List<OrderEntity> findTop12ByOrderByCreatedDtmDesc(long userId);
}
