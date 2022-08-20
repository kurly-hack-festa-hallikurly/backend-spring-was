package com.kurly.hack.festa.hallikurly.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserRequestDto {

    @ApiModelProperty(value = "회원 ID", example = "1,2,3,..")
    private long userId;
}
