package com.matrix.knowpoolwebsite.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest {
    private Integer transactionId;
    private Integer userId;
    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Time is required")
    private Time time;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be at least 1")
    private Integer amount;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;
}
