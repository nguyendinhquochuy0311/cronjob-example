package com.example.cronjob;

import com.example.model.Request;
import com.example.model.Response;
import com.example.service.CallHttpService;
import com.example.service.ChatGPTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CronJobService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CallHttpService callHttpService;
    private final ChatGPTService chatGPTService;

    @Autowired
    public CronJobService(CallHttpService callHttpService, ChatGPTService chatGPTService) {
        this.callHttpService = callHttpService;
        this.chatGPTService = chatGPTService;
    }

//    @Scheduled(fixedRate = 3000)
//    public void scheduleTaskWithFixedRate() {
//        // call send email method here
//        logger.info("[HELLO CRONJOB] - Time: {}", new Date().getTime());
//        try {
//            Response response = callHttpService.callChatGpt(new Request(), "");
//            logger.info("[RES] {}", response.getMessage());
//        } catch (Exception e) {
//            logger.warn("[EXCEPTION] message: {}", e.getMessage());
//        }
//    }

    @Scheduled(fixedRate = 3000)
    public void scheduleTaskWithFixedRate() {
        // call send email method here
        logger.info("[HELLO CRONJOB] - Time: {}", new Date().getTime());
        try {
            String response = chatGPTService.callChatGpt("hom nay la thu may");
            logger.info("[RES] {}", response);
        } catch (Exception e) {
            logger.warn("[EXCEPTION] message: {}", e.getMessage());
        }
    }
}
