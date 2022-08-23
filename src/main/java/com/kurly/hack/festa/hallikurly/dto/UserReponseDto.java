package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserReponseDto {

    @ApiModelProperty(value = "회원 ID", example = "xx")
    @JsonProperty("user_id")
    private long userId;

    @ApiModelProperty(value = "회원 별칭", example = "홍길동")
    @JsonProperty("user_alias")
    private String userAlias;
}
