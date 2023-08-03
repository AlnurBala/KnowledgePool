package com.example.knowpoolwebsite.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmenttResponse {
    private Integer enrollmentId;
    private Date enrollmentDate;
    private Integer progress;

}
