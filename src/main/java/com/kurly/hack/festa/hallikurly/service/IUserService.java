package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    ResponseEntity<?> userInfoCheckInLogin(UserDto userDto);
}
