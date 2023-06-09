package com.carsharing.dto.response;

import com.carsharing.model.Payment;
import java.math.BigDecimal;
import lombok.Data;

@Data
public final class PaymentResponseDto {
    private Long id;
    private Payment.Status status;
    private Payment.Type type;
    private Long rental;
    private String sessionUrl;
    private String receiptUrl;
    private String sessionId;
    private BigDecimal amount;
}
