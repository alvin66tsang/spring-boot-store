package com.project.ecommercestore.payments;

import com.project.ecommercestore.entities.PaymentStaus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaymentResult {

    private Long orderId;
    private PaymentStaus paymentStatus;
}
