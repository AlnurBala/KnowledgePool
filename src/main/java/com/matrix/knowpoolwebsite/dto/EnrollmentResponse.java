package com.matrix.knowpoolwebsite.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponse {
    private Integer enrollmentId;
    private Date enrollmentDate;
    private Integer progress;

}
