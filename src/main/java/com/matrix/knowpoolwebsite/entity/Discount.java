package com.matrix.knowpoolwebsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "discounts", schema = "project")
public class Discount {
    @Id
    @Column(name = "discount_id")
    private Integer discountId;
    @Column(name = "discount_percentage",precision = 5,scale = 2)
    private BigDecimal discountPercentage;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "recipient_email")
    private String recipientEmail;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
