package com.kurly.hack.festa.hallikurly.scheduler;

import com.kurly.hack.festa.hallikurly.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class StockScheduler {

    private final RestTemplateService restTemplateService;

    @Scheduled(cron = "0 0 0 * * *") //매일 매시 정각
    public void stockSyncToMLServer() {
        System.out.println("현재 시간 - " + new Date().toString());
        restTemplateService.stockSyncToMLServer();
    }

    //5분마다 판매완료 상품 동기화
    @Scheduled(cron = "0 */5 * * * *")
    public void soldOutProductSyncToMLServer() {
        System.out.println("현재 시간 - " + new Date().toString());
        restTemplateService.soldOutProductInfoToMLServer();
    }
}
