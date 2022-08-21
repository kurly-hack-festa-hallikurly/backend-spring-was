package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="TB_PRODUCT")
public class ProductEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_NO")
    private long productNo;

    @Column(name = "PRODUCT_NM")
    private String productNm;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "PRODUCT_IMG_PATH")
    private String productImgPath;
}
