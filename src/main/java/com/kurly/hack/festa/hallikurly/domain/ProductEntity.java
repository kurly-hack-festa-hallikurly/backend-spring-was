package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_product")
public class ProductEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_NO")
    private long productNo;

    @Column(name = "PRODUCT_NM")
    private String productNm;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "SOLD_OUT")
    private char soldOut;

    @Column(name = "SHELF_LIFE")
    private LocalDateTime shelfLife;

    @Column(name = "PRODUCT_IMG_PATH")
    private String productImgPath;

}
