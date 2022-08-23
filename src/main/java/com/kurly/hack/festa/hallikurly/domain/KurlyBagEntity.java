package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_kurly_bag")
public class KurlyBagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kurly_bag_id")
    private long kurlyBagId;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "PRODUCT_NO")
    private long productNo;

    @Column(name = "PRODUCT_NM")
    private String productNm;

    @Column(name = "PRODUCT_CNT")
    private int productCnt;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "PRODUCT_IMG_PATH")
    private String productImgPath;
}
