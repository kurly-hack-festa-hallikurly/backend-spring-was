package com.kurly.hack.festa.hallikurly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class HallikurlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HallikurlyApplication.class, args);
    }

}
