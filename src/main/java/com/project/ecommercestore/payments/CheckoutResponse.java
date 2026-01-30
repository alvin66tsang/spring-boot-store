package com.project.ecommercestore.payments;

import lombok.Data;

@Data
public class CheckoutResponse {

    private Long orderId;
    private String checkUrl;

    public CheckoutResponse(Long orderId, String checkUrl) {
        this.orderId = orderId;
        this.checkUrl = checkUrl;
    }
}
