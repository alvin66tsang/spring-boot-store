package com.project.ecommercestore.payments;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebhookRequest {

    private String headers;
    private String payload;
}
