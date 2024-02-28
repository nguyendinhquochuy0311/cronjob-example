package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@EnableScheduling
public class DemoApplication {
    // todo : move cái class này ngoài  - từ com.example.demo -> com.example
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        /**
         * không cần khai báo trong đây @SpringBootApplication là Component...
         * thường người ta không thiết kế kiểu này . tham khảo CronJobService.class
         * */

//        scheduleTaskWithFixedRate();

    }

    @Scheduled(fixedRate = 2000)
    public static void scheduleTaskWithFixedRate() {
        // call send email method here
        System.out.println("Send email to producers to inform quantity sold items");
    }
}
