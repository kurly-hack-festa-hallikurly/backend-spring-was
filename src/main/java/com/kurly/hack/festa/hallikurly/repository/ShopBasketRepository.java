package com.kurly.hack.festa.hallikurly.repository;

import com.kurly.hack.festa.hallikurly.domain.ProductEntity;
import com.kurly.hack.festa.hallikurly.domain.ShopBasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShopBasketRepository extends JpaRepository<ShopBasketEntity, Long> {

    List<ShopBasketEntity> findByUserId(long userId);

    @Transactional
    @Modifying
    @Query(value =
            "UPDATE tb_shop_basket " +
            "set product_cnt = :productCnt " +
            "where " +
            "user_id = :userId " +
            "and " +
            "product_no = :productNo"
            , nativeQuery = true)
    void updateShopBasketInfo(
             @Param("userId") long userId
            ,@Param("productNo") long productNo
            ,@Param("productCnt") int productCnt);

    @Transactional
    @Modifying
    @Query(value =
            "DELETE FROM tb_shop_basket " +
                    "where " +
                    "user_id = :userId " +
                    "and " +
                    "product_no = :productNo"
            , nativeQuery = true)
    void deleteShopBasketInfo(
            @Param("userId") long userId
            ,@Param("productNo") long productNo);
}
