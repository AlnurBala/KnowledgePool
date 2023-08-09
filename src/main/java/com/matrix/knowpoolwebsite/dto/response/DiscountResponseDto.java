package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.CourseResponse;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountResponseDto {
    private Integer discountId;
    private BigDecimal discountPercentage;
    private Date startDate;
    private Date endDate;
    private String recipientEmail;
    private CourseResponse course;
}
