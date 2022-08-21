package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_shop_basket")
public class ShopBasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private long basketId;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "product_no")
    private long productNo;
}
