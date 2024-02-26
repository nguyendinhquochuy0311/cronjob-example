package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@EnableScheduling

public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        scheduleTaskWithFixedRate();

    }

    @Scheduled(fixedRate = 2000)
    public static void scheduleTaskWithFixedRate() {
        // call send email method here
        System.out.println("Send email to producers to inform quantity sold items");
    }

}
