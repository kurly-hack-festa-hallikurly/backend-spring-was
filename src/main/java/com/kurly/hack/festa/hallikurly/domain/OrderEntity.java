package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_order_history")
public class OrderEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_NO")
    private long orderNo;

    @Column(name = "PRODUCT_NO")
    private long productNo;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "ORDER_CNT")
    private long orderCnt;

}
