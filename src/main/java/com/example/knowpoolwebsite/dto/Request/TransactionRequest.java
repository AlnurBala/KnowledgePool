package com.example.knowpoolwebsite.dto.Request;

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
    private Date date;
    private Time time;
    private Integer amount;
    private String paymentMethod;
}
