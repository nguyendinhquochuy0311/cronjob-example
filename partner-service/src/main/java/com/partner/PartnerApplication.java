package com.partner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class PartnerApplication {
    private static final Logger logger = LoggerFactory.getLogger(PartnerApplication.class);

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        SpringApplication.run(PartnerApplication.class, args);
        logger.info("***********************************");
        logger.info("****** Partner Service Start ******");
        logger.info("***********************************");
    }
}