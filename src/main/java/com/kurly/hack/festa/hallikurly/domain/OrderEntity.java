package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "ORDER_DOW")
    private int orderDow;

    @Column(name = "ORDER_HOUR_OF_DAY")
    private int orderHourOfDay;

}
