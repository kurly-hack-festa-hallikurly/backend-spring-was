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

    @Query(value =
            "SELECT " +
                    "tbs.BASKET_ID, tbs.USER_ID, tbs.PRODUCT_NO," +
                    "tbp.PRODUCT_NM, tbs.PRODUCT_CNT, tbs.CREATED_DTM " +
                    "FROM tb_shop_basket tbs " +
                    "LEFT JOIN tb_product tbp " +
                    "ON " +
                    "tbs.product_no = tbp.product_no " +
                    "WHERE user_id = :userId", nativeQuery = true)
    List<ShopBasketEntity> findByUserId(@Param("userId") long userId);

    @Query(value =
            "SELECT " +
                    "BASKET_ID, USER_ID, PRODUCT_NO, PRODUCT_NM, PRODUCT_CNT " +
                    "FROM tb_shop_basket " +
                    "WHERE " +
                    "user_id = :userId " +
                    "AND " +
                    "product_no = :productNo", nativeQuery = true)
    ShopBasketEntity findByUserIdAndProductNo(long userId, long productNo);

    @Transactional
    @Modifying
    @Query(value =
            "UPDATE tb_shop_basket " +
            "SET product_cnt = :productCnt " +
            "WHERE " +
            "user_id = :userId " +
            "AND " +
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
