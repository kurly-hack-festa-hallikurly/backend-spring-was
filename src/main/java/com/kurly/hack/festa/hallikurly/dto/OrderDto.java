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

    @ApiModelProperty(value = "상품 번호", example = "10500")
    @JsonProperty("product_no")
    private long productNo;

    @ApiModelProperty(value = "구매 유저 ID", example = "1")
    @JsonProperty("user_id")
    private long userId;
}
