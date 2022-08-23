package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class KurlyBagInfoRequestDto {

    @JsonProperty("products")
    private List<Long> productNo;

    //order_dow: 구매 요일 (0-6: 각 요일을 의미 )
    @JsonProperty("order_dow")
    private List<Integer> orderDow;

    //order_hour_of_day: 구매 시간(0-23)
    @JsonProperty("product_no")
    private List<Integer> orderHourOfDay;
}
