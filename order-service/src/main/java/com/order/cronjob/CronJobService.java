package com.order.cronjob;

import com.common.base.model.constant.ItachiStatusCode;
import com.common.base.model.response.ItachiResponse;
import com.order.service.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CronJobService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PartnerService geminiService;

    @Autowired
    public CronJobService(PartnerService geminiService) {
        this.geminiService = geminiService;
    }

    @Scheduled(fixedRate = 20000)
    public void scheduleTaskWithFixedRate() {
        // call send email method here
        logger.info("[HELLO CRONJOB] - Time: {}", new Date().getTime());
        ItachiResponse response = geminiService.callPartner("Test Call Microservice");
        if (ItachiStatusCode.OK.getStatus() == response.getStatus()) {
            logger.info("process success");
        } else {
            logger.info("Handle failed");
        }
    }
}
