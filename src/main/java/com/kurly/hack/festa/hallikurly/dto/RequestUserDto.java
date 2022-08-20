package com.kurly.hack.festa.hallikurly.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class RequestUserDto {

    private long userId;
}
