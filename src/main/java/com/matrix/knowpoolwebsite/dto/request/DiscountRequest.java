package com.matrix.knowpoolwebsite.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountRequest {
    private Integer discountId;
    private BigDecimal discountPercentage;
    private Date startDate;
    private Date endDate;
    private Integer courseId;
    private String recipientEmail;

}
