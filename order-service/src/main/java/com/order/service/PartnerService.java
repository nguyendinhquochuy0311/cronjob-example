package com.order.service;

import com.order.base.ServiceClient;
import com.order.model.PartnerRequest;
import com.order.model.PartnerResponse;
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

    public PartnerResponse callPartner(String message) {
        String apiUrl = buildUrl(this.partnerDomain, this.partnerPath);
        return serviceClient.executePost(buildRequest(message), apiUrl, PartnerResponse.class);
    }

    private String buildUrl(String... value) {
        return String.join("/", value);
    }

    private PartnerRequest buildRequest(String message) {
        PartnerRequest partnerRequest = new PartnerRequest();
        partnerRequest.setId(123);
        partnerRequest.setName("phong");
        partnerRequest.setContent(message);
        return partnerRequest;
    }
}
