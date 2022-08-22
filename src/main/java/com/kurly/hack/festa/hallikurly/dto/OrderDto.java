package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kurly.hack.festa.hallikurly.domain.BaseTimeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderDto {

    @ApiModelProperty(value = "상품 번호", example = "9")
    @JsonProperty("product_no")
    private long productNo;

    @ApiModelProperty(value = "구매 유저 ID", example = "1")
    @JsonProperty("user_id")
    private long userId;

    @ApiModelProperty(value = "상품 주문 개수", example = "2")
    @JsonProperty("order_cnt")
    private long orderCnt;
}
