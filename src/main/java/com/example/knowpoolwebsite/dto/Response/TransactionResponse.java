package com.example.knowpoolwebsite.dto.Response;

import com.example.knowpoolwebsite.dto.CourseeResponse;
import com.example.knowpoolwebsite.dto.UserrResponse;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {
    private Integer transactionId;
    private Date date;
    private Time time;
    private Integer amount;
    private String paymentMethod;
    private CourseeResponse course;
    private UserrResponse user;
}
