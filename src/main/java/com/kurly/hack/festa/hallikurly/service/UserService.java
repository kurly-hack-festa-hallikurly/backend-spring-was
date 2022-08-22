package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.UserEntity;
import com.kurly.hack.festa.hallikurly.dto.UserDto;
import com.kurly.hack.festa.hallikurly.repository.OrderRepository;
import com.kurly.hack.festa.hallikurly.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> userInfoCheckInLogin(UserDto userDto) {
        Optional<UserEntity> user = userRepository.findById(userDto.getUserId());

        if (ObjectUtils.isEmpty(user)) {
            return ResponseEntity.badRequest().body("해당 ID의 사용자가 존재하지 않습니다.");
        }

        if(user.get().getUserPw() == userDto.getUserPw())
            return ResponseEntity.ok("로그인 성공");
        else
            return ResponseEntity.badRequest().body("로그인 실패");

    }
}
