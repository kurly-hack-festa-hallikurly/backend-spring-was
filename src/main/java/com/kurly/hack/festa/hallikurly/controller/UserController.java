package com.kurly.hack.festa.hallikurly.controller;

import com.kurly.hack.festa.hallikurly.dto.UserDto;
import com.kurly.hack.festa.hallikurly.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final IUserService iUserService;

    @PostMapping
    private ResponseEntity<?> userInfoCheckInLogin(@RequestBody UserDto userDto){
        return iUserService.userInfoCheckInLogin(userDto);
    }
}
