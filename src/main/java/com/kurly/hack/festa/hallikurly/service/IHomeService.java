package com.kurly.hack.festa.hallikurly.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface IHomeService {
    ResponseEntity<?> init();
}
