package com.partner.controler;

import com.common.base.model.request.ItachiRequest;
import com.common.base.json.JsonUtils;
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
    public MessageResponse exportDataExample(@RequestBody ItachiRequest request) {
        logger.info("REQUEST {}", JsonUtils.objectToJsonStr(request));
        return new MessageResponse(StatusCode.OK);
    }
}
