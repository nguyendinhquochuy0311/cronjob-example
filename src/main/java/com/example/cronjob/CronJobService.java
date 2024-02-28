package com.example.cronjob;

import com.example.model.Request;
import com.example.model.Response;
import com.example.service.CallHttpService;
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

    @Autowired
    public CronJobService(CallHttpService callHttpService) {
        this.callHttpService = callHttpService;
    }

    @Scheduled(fixedRate = 3000)
    public void scheduleTaskWithFixedRate() {
        // call send email method here
        logger.info("[HELLO CRONJOB] - Time: {}", new Date().getTime());
        try {
            Response response = callHttpService.callChatGpt(new Request(), "");
            logger.info("[RES] {}", response.getMessage());
        } catch (Exception e) {
            logger.warn("[EXCEPTION] message: {}", e.getMessage());
        }
    }
}
