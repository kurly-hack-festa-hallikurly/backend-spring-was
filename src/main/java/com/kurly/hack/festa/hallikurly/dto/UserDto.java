package com.kurly.hack.festa.hallikurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserDto {

    @ApiModelProperty(value = "회원 ID", example = "xxx")
    @JsonProperty("user_id")
    private long userId;

    @ApiModelProperty(value = "회원 PW", example = "xxx")
    @JsonProperty("user_pw")
    private long userPw;

    @ApiModelProperty(value = "회원 별칭", example = "홍길동", hidden = true)
    private long userAlias;
}
