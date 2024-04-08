package com.order.service;

import com.common.base.model.request.ItachiRequest;
import com.common.base.model.response.ItachiResponse;
import com.order.base.ServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {

    @Value(value = "${partner.service.domain}")
    private String partnerDomain;

    @Value(value = "${partner.service.path}")
    private String partnerPath;
    private final ServiceClient serviceClient;

    public PartnerService(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public ItachiResponse callPartner(String message) {
        String apiUrl = buildUrl(this.partnerDomain, this.partnerPath);
        return serviceClient.executePost(buildRequest(message), apiUrl, ItachiResponse.class);
    }

    private String buildUrl(String... value) {
        return String.join("/", value);
    }

    private ItachiRequest buildRequest(String message) {
        ItachiRequest partnerRequest = new ItachiRequest();
        partnerRequest.setId(123);
        partnerRequest.setName("phongsd");
        partnerRequest.setContent(message);
        return partnerRequest;
    }
}
