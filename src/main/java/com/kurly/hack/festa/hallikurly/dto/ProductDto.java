package com.kurly.hack.festa.hallikurly.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ProductDto {

    @ApiModelProperty(value = "상품 번호", example = "1")
    private long productNo;

    @ApiModelProperty(value = "상품 이름", example = "Strawberry")
    private String productNm;

    @ApiModelProperty(value = "상품 가격", example = "7600")
    private int price;

    @ApiModelProperty(value = "상품 이미지 경로")
    private String productImgPath;
}
