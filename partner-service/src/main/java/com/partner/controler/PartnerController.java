package com.partner.controler;

import com.partner.model.DataRequest;
import com.partner.model.StatusCode;
import com.partner.response.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "data-test")
    public MessageResponse exportDataExample(@RequestBody DataRequest request) {
        logger.info("REQUEST {}", request.toString());
        return new MessageResponse(StatusCode.OK);
    }
}
