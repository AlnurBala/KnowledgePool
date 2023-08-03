package com.example.knowpoolwebsite.dto.Request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentRequest {
    private Integer enrollmentId;
    private Date enrollmentDate;
    private Integer progress;

}
