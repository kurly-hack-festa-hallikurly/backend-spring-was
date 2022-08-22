package com.kurly.hack.festa.hallikurly.repository;

import com.kurly.hack.festa.hallikurly.domain.KurlyBagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurlyBagRepository extends JpaRepository<KurlyBagEntity, Long> {
}
