package com.yishenheng.rapid;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yishenheng
 * @date 2020-05-23 22:14
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.yishenheng.rapid.mapper")
public class Application {

    public static void main(String[] args) {
        log.info("------------- springBootRapid run is start -------------");
        SpringApplication.run(Application.class, args);
        log.info("------------- springBootRapid run is end -------------");
    }
}
