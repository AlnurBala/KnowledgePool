package com.example.knowpoolwebsite.dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionnResponse {
    private Integer transactionId;
    private Date date;
    private Time time;
    private Integer amount;
    private String paymentMethod;
}
