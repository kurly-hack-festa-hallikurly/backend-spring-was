package com.kurly.hack.festa.hallikurly.service;

import com.kurly.hack.festa.hallikurly.domain.UserEntity;
import com.kurly.hack.festa.hallikurly.dto.UserDto;
import com.kurly.hack.festa.hallikurly.dto.UserReponseDto;
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
    public ResponseEntity<?> userInfoCheckInLogin(UserDto user) {
        Optional<UserEntity> userEntity = userRepository.findById(user.getUserId());

        if (ObjectUtils.isEmpty(userEntity)) {
            return ResponseEntity.badRequest().body("해당 ID의 사용자가 존재하지 않습니다.");
        }

        UserReponseDto userDto = UserReponseDto
                .builder()
                .userId(userEntity.get().getUserId())
                .userAlias(userEntity.get().getUserAlias())
                .build();

        if(userEntity.get().getUserPw() == user.getUserPw())
            return ResponseEntity.ok(userDto);
        else
            return ResponseEntity.badRequest().body("로그인 실패");

    }
}
