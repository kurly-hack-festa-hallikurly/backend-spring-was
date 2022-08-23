package com.kurly.hack.festa.hallikurly.repository;

import com.kurly.hack.festa.hallikurly.domain.KurlyBagEntity;
import com.kurly.hack.festa.hallikurly.domain.ShopBasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface KurlyBagRepository extends JpaRepository<KurlyBagEntity, Long> {

    @Query(value =
            "SELECT " +
                    "KURLY_BAG_ID, USER_ID, PRODUCT_NO," +
                    "PRODUCT_NM, PRODUCT_CNT, PRICE, PRODUCT_IMG_PATH, CREATED_DTM " +
                    "FROM tb_kurly_bag " +
                    "WHERE user_id = :userId", nativeQuery = true)
    List<KurlyBagEntity> findByUserId(@Param("userId") long userId);

    @Query(value =
            "SELECT " +
                    "KURLY_BAG_ID, USER_ID, PRODUCT_NO, PRODUCT_NM, PRODUCT_CNT, PRICE, PRODUCT_IMG_PATH " +
                    "FROM tb_kurly_bag " +
                    "WHERE " +
                    "user_id = :userId " +
                    "AND " +
                    "product_no = :productNo", nativeQuery = true)
    KurlyBagEntity findByUserIdAndProductNo(long userId, long productNo);

    @Transactional
    @Modifying
    @Query(value =
            "UPDATE tb_kurly_bag " +
                    "SET product_cnt = :productCnt " +
                    "WHERE " +
                    "user_id = :userId " +
                    "AND " +
                    "product_no = :productNo"
            , nativeQuery = true)
    void updateKurlyBagInfo(
            @Param("userId") long userId
            ,@Param("productNo") long productNo
            ,@Param("productCnt") int productCnt);

    @Transactional
    @Modifying
    @Query(value =
            "DELETE FROM tb_kurly_bag " +
                    "where " +
                    "user_id = :userId " +
                    "and " +
                    "product_no = :productNo"
            , nativeQuery = true)
    void deleteKurlyBagInfo(
            @Param("userId") long userId
            ,@Param("productNo") long productNo);
}
