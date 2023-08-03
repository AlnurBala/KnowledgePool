package com.example.knowpoolwebsite.dto.Response;

import com.example.knowpoolwebsite.dto.CourseeResponse;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountResponse {
    private Integer discountId;
    private BigDecimal discountPercentage;
    private Date startDate;
    private Date endDate;
    private String recipientEmail;
    private CourseeResponse course;
}
