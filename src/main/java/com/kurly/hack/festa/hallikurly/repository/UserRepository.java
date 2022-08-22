package com.kurly.hack.festa.hallikurly.repository;

import com.kurly.hack.festa.hallikurly.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
