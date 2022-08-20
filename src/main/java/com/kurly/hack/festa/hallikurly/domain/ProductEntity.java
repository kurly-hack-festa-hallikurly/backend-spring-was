package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no")
    private long productNo;

    @Column(name = "product_nm")
    private String productNm;

    @Column(name = "product_img_path")
    private String productImgPath;
}
