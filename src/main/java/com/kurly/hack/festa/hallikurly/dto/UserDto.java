package com.kurly.hack.festa.hallikurly.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserDto {

    @ApiModelProperty(value = "회원 ID", example = "1")
    private long userId;

    @ApiModelProperty(value = "회원 PW")
    private long userPw;

    @ApiModelProperty(value = "회원 별칭", example = "홍길동")
    private long userAlias;
}
