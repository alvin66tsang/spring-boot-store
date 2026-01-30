package com.project.ecommercestore.payments;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymentException extends RuntimeException {
    public PaymentException(String msg) {
        super(msg);
    }
}
