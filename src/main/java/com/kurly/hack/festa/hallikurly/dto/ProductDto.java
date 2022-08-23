package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ProductDto {

    @ApiModelProperty(value = "상품 번호", example = "1")
    @JsonProperty("product_no")
    private long productNo;

    @ApiModelProperty(value = "상품 이름", example = "Strawberry")
    @JsonProperty("product_nm")
    private String productNm;

    @ApiModelProperty(value = "상품 가격", example = "7600")
    @JsonProperty("price")
    private int price;

    @ApiModelProperty(value = "상품 이미지 경로")
    @JsonProperty("product_img_path")
    private String productImgPath;
}
