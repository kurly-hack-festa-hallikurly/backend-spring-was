package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ShopBasketDto {

    @ApiModelProperty(value = "유저 ID", example = "1")
    @JsonProperty("user_id")
    private long userId;

    @ApiModelProperty(value = "상품 번호", example = "1")
    @JsonProperty("product_no")
    private long productNo;

    @ApiModelProperty(value = "상품명", example = "Chocolate Sandwich Cookies")
    @JsonProperty("product_nm")
    private String productNm;

    @ApiModelProperty(value = "갯수", example = "1")
    @JsonProperty("product_cnt")
    private int productCnt;

}
