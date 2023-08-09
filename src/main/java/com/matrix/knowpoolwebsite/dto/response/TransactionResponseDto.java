package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.CourseResponse;
import com.matrix.knowpoolwebsite.dto.UserResponse;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDto {
    private Integer transactionId;
    private Date date;
    private Time time;
    private Integer amount;
    private String paymentMethod;
    private CourseResponse course;
    private UserResponse user;
}
