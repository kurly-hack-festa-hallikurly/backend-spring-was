package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class KurlyBagDto {

    private long productNo;

    private long productNm;
}
