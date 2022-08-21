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

    @Column(name = "PRODUCT_NO")
    private String productNo;

    @Column(name = "PRODUCT_NM")
    private String productNm;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "PRODUCT_IMG_PATH")
    private String productImgPath;
}
