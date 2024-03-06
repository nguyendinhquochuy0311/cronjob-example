package com.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class OrderApplication {
    private static final Logger logger = LoggerFactory.getLogger(OrderApplication.class);
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        SpringApplication.run(OrderApplication.class, args);
        logger.info("***********************************");
        logger.info("******** Order Service Start ******");
        logger.info("***********************************");
    }
}