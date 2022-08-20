package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class KurlyBagDto {
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("user_nm")
    private String userPw;

//    private long productNo;
//    private long productNm;
}
