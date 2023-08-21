package com.matrix.knowpoolwebsite.dto.request;

import jakarta.validation.constraints.*;
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

    @NotNull(message = "Discount percentage is required")
    @DecimalMin(value = "0.01", message = "Discount percentage must be at least 0.01")
    @DecimalMax(value = "100.00", message = "Discount percentage cannot exceed 100.00")
    private BigDecimal discountPercentage;

    @NotNull(message = "Start date is required")
    private Date startDate;

    @NotNull(message = "End date is required")
    private Date endDate;


    private Integer courseId;

    @NotBlank(message = "Recipient email is required")
    @Email(message = "Invalid email address format")
    private String recipientEmail;

}
